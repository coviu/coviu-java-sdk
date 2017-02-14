package com.coviu.auth;

import com.google.gson.annotations.SerializedName;

public class GrantResponse {
    @SerializedName("access_token")
    private String accessToken;

    @SerializedName("refresh_token")
    private String refreshToken;

    @SerializedName("expires_in")
    private Long expiresIn;

    @SerializedName("token_type")
    private String tokenType;

    @SerializedName("scope")
    private String scope;

    public String getAccessToken() {
        return this.accessToken;
    }

    public GrantResponse setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public GrantResponse setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }

    public Long getExpiresIn() {
        return this.expiresIn;
    }

    public GrantResponse setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }

    public String getTokenType() {
        return this.tokenType;
    }

    public GrantResponse setTokenType(String tokenType) {
        this.tokenType = tokenType;
        return this;
    }

    public String getScope() {
        return this.scope;
    }

    public GrantResponse setScope(String scope) {
        this.scope = scope;
        return this;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        GrantResponse r = (GrantResponse) o;

        return this.accessToken.equals(r.accessToken)
            && this.refreshToken.equals(r.refreshToken)
            && this.expiresIn.equals(r.expiresIn)
            && this.tokenType.equals(r.tokenType)
            && this.scope.equals(r.scope);

    }
}
