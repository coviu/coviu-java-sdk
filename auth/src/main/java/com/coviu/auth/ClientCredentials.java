package com.coviu.auth;

import com.squareup.okhttp.Credentials;

public class ClientCredentials {
    private final String apiKey;
    private final String apiKeySecret;

    public ClientCredentials(String apiKey, String apiKeySecret) {
        this.apiKey = apiKey;
        this.apiKeySecret = apiKeySecret;
    }

    public String basic() {
        return Credentials.basic(this.apiKey, this.apiKeySecret);
    }

    public String getApiKey() {
        return apiKey;
    }
}
