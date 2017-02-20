package com.coviu.examples;

import com.coviu.core.ApiClient;
import com.coviu.core.ApiException;
import com.coviu.sessions.api.SessionApi;
import com.coviu.sessions.model.*;

import static org.joda.time.DateTime.now;

public class Main {

    public static void main(String[] args) {

        try {
            String apiKey = getSystemPropertyOrFail("coviu.api-key");
            String apiKeySecret = getSystemPropertyOrFail("coviu.api-secret");

            // Create an api client.
            ApiClient client = new ApiClient();
            client.setCredentials(apiKey, apiKeySecret, null);

            // We we obtain, and update a new authorization (access_token, refresh_token, expires_in)
            // we usually want to save it for later use.
            client.setAuthorizationObserver(new ApiClient.AuthorizationObserver(){
                public void observe(String s) {
                    saveUpdatedAuthorization(s);
                }
            });

            // Construct a new session api instance using the freshly constructed api client.
            SessionApi api = new SessionApi(client);

            // Lets book a new session.
            SessionCreationRequest scr = new SessionCreationRequest()
                    // Starts this time tomorrow
                    .startTime(now().plusDays(1))
                    // Finishes an hour later
                    .endTime(now().plusDays(1).plusHours(1))
                    // adding a single host participant at the moment.
                    .addParticipantsItem(exampleHostParticipant());
            Session session = api.createSession(scr);

            System.out.println(session);

            // Lets add a second participant to the session
            Participant guest = api.addSessionParticipant(session.getSessionId(), exampleGuestParticipant());
            System.out.println(guest);

            // Lets move it to start half an hour later.
            SessionUpdateRequest sur = new SessionUpdateRequest()
                    .startTime(session.getStartTime().plusMinutes(30));
            api.updateSession(session.getSessionId(), sur);

            // Ok, lets cancel the session.
            api.deleteSession(session.getSessionId());

        } catch (ApiException e) {
            e.printStackTrace();
        }


    }

    public static String getSystemPropertyOrFail(String key) {

        String result = System.getProperty(key);
        if (result == null) {
            System.err.println("The property \""+key+"\" must be supplied.");
            System.exit(1);
        }

        return result;
    }

    public static ParticipantCreationRequest exampleGuestParticipant() {
        return new ParticipantCreationRequest()
                .displayName("Joe")
                .role("guest");
    }

    public static ParticipantCreationRequest exampleHostParticipant() {
        return new ParticipantCreationRequest()
                .displayName("Jill")
                .role("host");
    }

    public static void saveUpdatedAuthorization(String authorization) {
        System.out.println("Authorization received...................");
        System.out.println(authorization);
    }

}
