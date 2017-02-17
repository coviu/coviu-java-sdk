package com.coviu.examples;

import com.coviu.core.ApiClient;
import com.coviu.sessions.api.SessionApi;
import com.coviu.sessions.model.*;

public class Main {

    public static String getSystemPropertyOrFail(String key) {

        String result = System.getProperty(key);
        if (result == null) {
            System.err.println("The property \""+key+"\" must be supplied.");
            System.exit(1);
        }

        return result;
    }

    public static void main(String[] args) {
        String apiKey = getSystemPropertyOrFail("coviu.api-key");
        String apiKeySecret = getSystemPropertyOrFail("coviu.api-secret");
        ApiClient client = new ApiClient();
        client.setCredentials(apiKey, apiKeySecret, null);

    }
}
