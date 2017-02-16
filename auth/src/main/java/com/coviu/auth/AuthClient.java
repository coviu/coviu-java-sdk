package com.coviu.auth;

import com.coviu.Config;
import com.coviu.HttpClient;
import com.coviu.RefreshObserver;
import com.coviu.util.F0;
import com.coviu.util.FVoid;
import com.coviu.util.Maybe;
import com.coviu.util.Thunk;

public class AuthClient {

    private final Config config;
    private Maybe<Authorization> authorization;
    private Maybe<RefreshObserver> refreshObserver;
    private HttpClient client;

    private final Thunk<Authorization> getAuthorization = Thunk.thunk(new F0<Authorization>() {
        public Authorization apply() {
            GrantResponse g = client.expectJsonOf(
                    AuthRequests.clientCredentials(config),
                    GrantResponse.class);
            Authorization authz = Authorization.newAuthorization(g);
            setAuthorization(authz);
            return authz;
        }
    });

    public AuthClient(Config config,
                      RefreshObserver refreshObserver,
                      Authorization authorization) {
        this.config = config;
        this.refreshObserver = Maybe.just(refreshObserver);
        this.authorization = Maybe.just(authorization);
        this.client = config.getHttpClient();
    }

    public void setRefreshObserver(RefreshObserver refreshObserver) {
        this.refreshObserver = Maybe.just(refreshObserver);
    }

    private Authorization refresh(Authorization az) {
        GrantResponse g = client.expectJsonOf(
                AuthRequests.refresh(az, config),
                GrantResponse.class);

        final Authorization authz = Authorization.newAuthorization(g);
        setAuthorization(authz);
        return authz;
    }

    public Authorization getActiveAuthorization() {
        return authorization.getOrElseLazy(getAuthorization);
    }

    public String getAccessToken() {
        Authorization authz = getActiveAuthorization();

        if (authz.isExpired()) {
            return refresh(authz).getAccessToken();
        }
        return authz.getAccessToken();
    }

    public Authorization useAuthorizationCode(String code) {
        GrantResponse g = client.expectJsonOf(
            AuthRequests.authorizationCode(code, config),
            GrantResponse.class);
        return Authorization.newAuthorization(g);
    }

    public Authorization usernamePasswordAuthorization(String username, String password) {
        GrantResponse g = client.expectJsonOf(
                AuthRequests.password(username, password, config),
                GrantResponse.class);
        return Authorization.newAuthorization(g);
    }

    public Authorization forceRefresh() {
        return refresh(getActiveAuthorization());
    }

    public void setAuthorization(final Authorization authorization) {
        this.authorization = Maybe.just(authorization);
        refreshObserver.forEach(new FVoid<RefreshObserver>(){
            public void apply(RefreshObserver o) {
                o.onRefresh(authorization);
            }
        });
    }

    public ClientCredentials getCredentials() {
        return config.getBasicAuthAuthenticator().getCredentials();
    }
}
