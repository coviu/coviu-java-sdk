package com.coviu.auth;

import com.coviu.Config;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;


public class AuthRequests {

    public static Request clientCredentials(Config config) {
        return postBody(new FormEncodingBuilder()
                .add("grant_type", "client_credentials")
                .build(), config);
    }

    public static Request refresh(Authorization auth, Config config) {
        return postBody(new FormEncodingBuilder()
                .add("grant_type", "refresh_token")
                .add("refresh_token", auth.getRefreshToken())
                .build(), config);
    }

    public static Request authorizationCode(String code, Config config) {
        return postBody(new FormEncodingBuilder()
                .add("grant_type", "code")
                .add("code", code)
                .build(), config);
    }

    private static Request postBody(RequestBody body, Config config) {
        return config.getBasicAuthAuthenticator().apply(new Request.Builder()
                .url(config.getBasePath() + "/auth/token")
                .post(body))
                .build();
    }
}
