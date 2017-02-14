package com.coviu;

import com.coviu.auth.AuthClient;
import com.coviu.auth.ClientCredentials;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.lang.reflect.Type;

public class HttpClient {

    private OkHttpClient client;

    public HttpClient() {
       client = new OkHttpClient();
    }

    public HttpClient(OkHttpClient client) {
        this.client = client;
    }

    /**
     * Execute the request, decoding to JSON, or die trying.
     * @param req okhttp request to be executed.
     * @param <A> The type we're attempting to deserialize into.
     * @return An A if anything at all.
     */
    public <A> A expectJsonOf(Request req, Type returnType) {
        try {
            Response res = client.newCall(req).execute();
            if (res.isSuccessful()) {
                Gson gson = new GsonBuilder().create();
                return gson.fromJson(res.body().string(), returnType);
            }
            throw new RuntimeException("");
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static interface Authenticator {
        public Request.Builder apply(Request.Builder builder);
    }

    public static class OAuth2Authenticator implements Authenticator {
        private AuthClient auth;

        public OAuth2Authenticator(AuthClient auth) {
            this.auth = auth;
        }

        public Request.Builder apply(Request.Builder builder) {
            return builder.addHeader("Authorization" , "Bearer " + auth.getAccessToken());
        }
    }

    public static class BasicAuthAuthenticator implements Authenticator {
        private ClientCredentials credentials;

        public BasicAuthAuthenticator(ClientCredentials credentials) {
            this.credentials = credentials;
        }

        public Request.Builder apply(Request.Builder builder) {
            return builder.addHeader("Authorization" , credentials.basic());
        }
    }
}
