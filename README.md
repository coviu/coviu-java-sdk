# coviu-sdk

Coviu provides a session based API for creating and restricting access to coviu calls. The core concepts exposed are

* Session: A coviu call that occurs between two or more parties at a specified time, and has a finite duration.
* Participants: Users who may participate in a coviu call.

Participants join a call by following a _session link_ in their browser, or mobile app. The _session link_
identifies the participant, including their name, optional avatar, and importantly their _role_. As such,
it is important that each person joining the call be issued a different _session link_, i.e. have a distinct
_participant_ created for them. A participant's _role_ identifies whether that user may access the call directly,
or if they are required the be _let in_ by an existing participant.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>com.coviu</groupId>
    <artifactId>coviu-sdk</artifactId>
    <version>1.0-SNAPSHOT</version>
    <scope>compile</scope>
</dependency>
```


## Getting Started


### Create a session

A session can be created by constructing a `SessionCreationRequest` with a start and end time.

```java

import com.coviu.core.*;
import com.coviu.core.auth.*;
import com.coviu.sessions.model.*;
import com.coviu.sessions.api.SessionApi;

import org.joda.time.DateTime;

public class SessionApiExample {

    public static void main(String[] args) {
        ApiClient client = new ApiClient();
        client.setCredentials("myApiKey", "myApiKeySecret", null);

        SessionApi api = new SessionApi(client);

        // Create a session that starts in an hour and finishes an hour later.
        SessionCreationRequest scr = new SessionCreationRequest()
            .startTime(DateTime.now().plusHours(1))
            .endTime(DateTime.now().plusHours(2));

        try {
            Session s = api.createSession(scr);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SessionApi#addSessionParticipant");
            e.printStackTrace();
        }
    }
}

```

Example output

```
class Session {
    featureFlags: []
    sessionId: 32c22a74-bc97-4d06-a0c2-ef8d502258c2
    teamId: e1bbc77f-5312-4e82-b3c0-b629c22aeb50
    clientId: 2a6a7b2c-2f44-4410-ad18-531f942d9453
    participants: []
    picture: null
    startTime: 2017-02-15T11:57:40.664+11:00
    endTime: 2017-02-15T12:57:40.664+11:00
    canceledTime: null
    sessionName: null
}
```

### Add a participant to a session

In order for a call to take place, you will need to add two or more participants to the session

```java
    // ...
    ParticipantCreationRequest r = new ParticipantCreationRequest()
        .displayName("Joe")
        .role("host");
    try {
        Participant p = api.addSessionParticipant(s.getSessionId(), r);
        Session s2 = api.getSessionById(s.getSessionId(), false);
        System.out.println(s2);
    } catch (ApiException e) {
        //...
    }
    
```

```
class Session {
    featureFlags: []
    sessionId: 8627196e-0a86-4527-b606-f11838dc258d
    teamId: 34aaeb76-0d41-4135-aac4-6c629a6999d5
    clientId: 47eaf1b7-cc72-4d74-a543-578bba0bde3b
    participants: [class Participant {
        sessionId: 8627196e-0a86-4527-b606-f11838dc258d
        state: ciz66y7dl000ltz68z9mfm09j
        displayName: Joe
        participantId: 0df16821-a1de-4ba0-9613-3fddd3e97e2e
        clientId: 47eaf1b7-cc72-4d74-a543-578bba0bde3b
        role: HOST
        picture: null
        deletedAt: null
        coviuUserId: null
        entryUrl: http://dev.localhost:3000/session/0df16821-a1de-4ba0-9613-3fddd3e97e2e
    }]
    picture: null
    startTime: 2017-02-15T12:00:26.014+11:00
    endTime: 2017-02-15T13:00:26.016+11:00
    canceledTime: null
    sessionName: null
}
```

Notice that we constructed a `HOST`, by setting the `.role("host")`. This means our participant may join the call directly, without
the having to _ring_. Possible values for role are `host` and `guest`. Values are not case sensitive.
If no value is set, the role defaults to `guest`.


Note that it is also possible to add participants directly to the session when you're creating the session by adding them with `addParticipantsItem` to the `SessionCreationRequest`.

```java
    ParticipantCreationRequest pcr = new ParticipantCreationRequest()
        .displayName("Joe")
        .role("host");

    SessionCreationRequest scr = new SessionCreationRequest()
            .startTime(DateTime.now().plusHours(1))
            .endTime(DateTime.now().plusHours(2))
            .addParticipantsItem(pcr);
```

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.