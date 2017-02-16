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

The full set of api documentations is available in the [**api director**](api/sessions/README.md).

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

### List sessions

It's possible to recover a list of sessions that have been booked, held, deleted etc. Sessions are returned one page at a time.

```java
SessionApi api = new SessionApi(client);
Integer page = 0; // Integer | The page number to return
Integer pageSize = 200; // Integer | The number of sessions per page. Max 200. Default 200.
DateTime startTime = DateTime().now(); // DateTime | Includes sessions that start at or after start_time.
DateTime endTime = DateTime().now().plusDays(30); // DateTime | Include sessions that start upto and including end_time..
Boolean includeCanceled = false; // Boolean | Includes sessions that have been canceled.
Boolean deletedParticipants = false; // Boolean | Also include participants that have been removed from the session.
String state = null; // String | Return only sessions containing participants with the supplied state value.
String order = null; // String | Order the results. forward returns oldest first by start time. backwards includes newest first by startime.
try {
    SessionPage result = api.getSessionPage(page, pageSize, startTime, endTime, includeCanceled, deletedParticipants, state, order);
    System.out.println(result);
} catch (ApiException e) {
    //...
}
```

### Update a session

A session may be updated by e.g. changing the start and end times, or setting name for the session


```java
        SessionUpdateRequest update = new SessionUpdateRequest()
                .startTime(DateTime.now().plusDays(1).plusHours(1))
                .endTime(DateTime.now().plusDays(1).plusHours(2))
                .sessionName("Fun time with coviu");
        Session s2 = api.updateSession(s.getSessionId(), update);
```


### Cancel a session

A session may also be canceled, meaning it will no longer take place, no new participants can be added or removed, no updates can be applied. This operation can not be undone.

```java
        api.deleteSession(s.getSessionId());
```

### OAuth2

Coviu uses OAuth2 for controlling access to resources. The coviu java sdk takes care of recovering, using, and refreshing access tokens. There are two use cases for access the coviu api.
Firstly you may wish to access the api on behalf of the owner of the client credentials, that is to say follow the flow for the client credentials grant outlined in https://tools.ietf.org/html/rfc6749#section-4.4.
In this situation, you only need to supply the sdk with your credentials. Your account may incurr 

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.