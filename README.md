# coviu-sdk

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


```java

import com.coviu.core.*;
import com.coviu.core.auth.*;
import com.coviu.sessions.model.*;
import com.coviu.sessions.api.SessionApi;

import org.joda.time.DateTime;

import java.io.File;
import java.util.*;

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

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author



