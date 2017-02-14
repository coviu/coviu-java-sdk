# coviu-sdk-sessions

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>com.coviu</groupId>
    <artifactId>coviu-sdk-sessions</artifactId>
    <version>1.0-SNAPSHOT</version>
    <scope>compile</scope>
</dependency>
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/coviu-sdk-sessions-1.0-SNAPSHOT.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import com.coviu.core.*;
import com.coviu.core.auth.*;
import com.coviu.sessions.model.*;
import com.coviu.sessions.api.SessionApi;

import java.io.File;
import java.util.*;

public class SessionApiExample {

    public static void main(String[] args) {
        ApiClient client = new ApiClient();
        client.setCredentials("myApiKey", "myApiKeySecret", null);

        SessionApi api = new SessionApi(client);
        String sessionId = "sessionId_example"; // String | The session id of the session that the operation applies to.
        ParticipantCreationRequest body = new ParticipantCreationRequest(); // ParticipantCreationRequest | 
        try {
            Participant result = apiInstance.addSessionParticipant(sessionId, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SessionApi#addSessionParticipant");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://api.coviu.com/v1*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*SessionApi* | [**addSessionParticipant**](docs/SessionApi.md#addSessionParticipant) | **POST** /sessions/{session_id}/participants | 
*SessionApi* | [**createSession**](docs/SessionApi.md#createSession) | **POST** /sessions | 
*SessionApi* | [**deleteSession**](docs/SessionApi.md#deleteSession) | **DELETE** /sessions/{session_id} | 
*SessionApi* | [**deleteSessionParticipant**](docs/SessionApi.md#deleteSessionParticipant) | **DELETE** /participants/{participant_id} | 
*SessionApi* | [**getSessionById**](docs/SessionApi.md#getSessionById) | **GET** /sessions/{session_id} | 
*SessionApi* | [**getSessionPage**](docs/SessionApi.md#getSessionPage) | **GET** /sessions | 
*SessionApi* | [**getSessionParticipant**](docs/SessionApi.md#getSessionParticipant) | **GET** /participants/{participant_id} | 
*SessionApi* | [**getSessionParticipants**](docs/SessionApi.md#getSessionParticipants) | **GET** /sessions/{session_id}/participants | 
*SessionApi* | [**updateSession**](docs/SessionApi.md#updateSession) | **PUT** /sessions/{session_id} | 
*SessionApi* | [**updateSessionParticipant**](docs/SessionApi.md#updateSessionParticipant) | **PUT** /participants/{participant_id} | 


## Documentation for Models

 - [Participant](docs/Participant.md)
 - [ParticipantCreationRequest](docs/ParticipantCreationRequest.md)
 - [ParticipantPage](docs/ParticipantPage.md)
 - [ParticipantUpdateRequest](docs/ParticipantUpdateRequest.md)
 - [Session](docs/Session.md)
 - [SessionCreationRequest](docs/SessionCreationRequest.md)
 - [SessionPage](docs/SessionPage.md)
 - [SessionUpdateRequest](docs/SessionUpdateRequest.md)
 - [UnitResponse](docs/UnitResponse.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### oauth2

- **Type**: OAuth
- **Flow**: application
- **Authorizatoin URL**: 
- **Scopes**: N/A


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author



