package com.coviu;

public interface Config {
    String getBasePath();
    HttpClient getHttpClient();
    HttpClient.Authenticator getBasicAuthAuthenticator();
}
