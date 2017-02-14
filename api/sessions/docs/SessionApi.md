# SessionApi

All URIs are relative to *https://api.coviu.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addSessionParticipant**](SessionApi.md#addSessionParticipant) | **POST** /sessions/{session_id}/participants | 
[**createSession**](SessionApi.md#createSession) | **POST** /sessions | 
[**deleteSession**](SessionApi.md#deleteSession) | **DELETE** /sessions/{session_id} | 
[**deleteSessionParticipant**](SessionApi.md#deleteSessionParticipant) | **DELETE** /participants/{participant_id} | 
[**getSessionById**](SessionApi.md#getSessionById) | **GET** /sessions/{session_id} | 
[**getSessionPage**](SessionApi.md#getSessionPage) | **GET** /sessions | 
[**getSessionParticipant**](SessionApi.md#getSessionParticipant) | **GET** /participants/{participant_id} | 
[**getSessionParticipants**](SessionApi.md#getSessionParticipants) | **GET** /sessions/{session_id}/participants | 
[**updateSession**](SessionApi.md#updateSession) | **PUT** /sessions/{session_id} | 
[**updateSessionParticipant**](SessionApi.md#updateSessionParticipant) | **PUT** /participants/{participant_id} | 



# **addSessionParticipant**
> Participant addSessionParticipant(sessionId, body)



It is sometimes useful to add a participant to a session after the session has been created. It is possible to add a participant to a session that has already start, but not to a session that has already finished.

### Example
```java
// Import classes:
//import com.coviu.core.ApiClient;
//import com.coviu.core.ApiException;
//import com.coviu.core.Configuration;
//import com.coviu.core.auth.*;
//import com.coviu.sessions.api.SessionApi;

ApiClient client = new ApiClient();
client.setCredentials("myApiKey", "myApiKeySecret", null);

SessionApi api = new SessionApi(client);
String sessionId = "sessionId_example"; // String | The session id of the session that the operation applies to.
ParticipantCreationRequest body = new ParticipantCreationRequest(); // ParticipantCreationRequest | 
try {
    Participant result = api.addSessionParticipant(sessionId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SessionApi#addSessionParticipant");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sessionId** | **String**| The session id of the session that the operation applies to. |
 **body** | [**ParticipantCreationRequest**](ParticipantCreationRequest.md)|  |

### Return type

[**Participant**](Participant.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


# **createSession**
> Session createSession(body)



Create a new session. Note that the session start time must be in the future, and the session end time must be after the session start time.

### Example
```java
// Import classes:
//import com.coviu.core.ApiClient;
//import com.coviu.core.ApiException;
//import com.coviu.core.Configuration;
//import com.coviu.core.auth.*;
//import com.coviu.sessions.api.SessionApi;

ApiClient client = new ApiClient();
client.setCredentials("myApiKey", "myApiKeySecret", null);

SessionApi api = new SessionApi(client);
SessionCreationRequest body = new SessionCreationRequest(); // SessionCreationRequest | 
try {
    Session result = api.createSession(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SessionApi#createSession");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**SessionCreationRequest**](SessionCreationRequest.md)|  |

### Return type

[**Session**](Session.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


# **deleteSession**
> UnitResponse deleteSession(sessionId)



A session that is scheduled for the future may be canceled. No participants will be able to join the session after it has been canceled, and it can not be uncanceled once it has been canceled. A session that has already started may not be canceled.

### Example
```java
// Import classes:
//import com.coviu.core.ApiClient;
//import com.coviu.core.ApiException;
//import com.coviu.core.Configuration;
//import com.coviu.core.auth.*;
//import com.coviu.sessions.api.SessionApi;

ApiClient client = new ApiClient();
client.setCredentials("myApiKey", "myApiKeySecret", null);

SessionApi api = new SessionApi(client);
String sessionId = "sessionId_example"; // String | The session id of the session that the operation applies to.
try {
    UnitResponse result = api.deleteSession(sessionId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SessionApi#deleteSession");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sessionId** | **String**| The session id of the session that the operation applies to. |

### Return type

[**UnitResponse**](UnitResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


# **deleteSessionParticipant**
> UnitResponse deleteSessionParticipant(participantId)



Cancel a session participant. The participant will no longer be able to enter the session. Once a participant has been canceled, it may not be uncanceled. A participant may not be canceled after a session has finished.

### Example
```java
// Import classes:
//import com.coviu.core.ApiClient;
//import com.coviu.core.ApiException;
//import com.coviu.core.Configuration;
//import com.coviu.core.auth.*;
//import com.coviu.sessions.api.SessionApi;

ApiClient client = new ApiClient();
client.setCredentials("myApiKey", "myApiKeySecret", null);

SessionApi api = new SessionApi(client);
String participantId = "participantId_example"; // String | The participant id of the participant that the operation applies to.
try {
    UnitResponse result = api.deleteSessionParticipant(participantId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SessionApi#deleteSessionParticipant");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **participantId** | **String**| The participant id of the participant that the operation applies to. |

### Return type

[**UnitResponse**](UnitResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


# **getSessionById**
> Session getSessionById(sessionId, deletedParticipants)



Get a single session by id.

### Example
```java
// Import classes:
//import com.coviu.core.ApiClient;
//import com.coviu.core.ApiException;
//import com.coviu.core.Configuration;
//import com.coviu.core.auth.*;
//import com.coviu.sessions.api.SessionApi;

ApiClient client = new ApiClient();
client.setCredentials("myApiKey", "myApiKeySecret", null);

SessionApi api = new SessionApi(client);
String sessionId = "sessionId_example"; // String | The session id of the session that the operation applies to.
Boolean deletedParticipants = true; // Boolean | Also include participants that have been removed from the session.
try {
    Session result = api.getSessionById(sessionId, deletedParticipants);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SessionApi#getSessionById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sessionId** | **String**| The session id of the session that the operation applies to. |
 **deletedParticipants** | **Boolean**| Also include participants that have been removed from the session. | [optional]

### Return type

[**Session**](Session.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


# **getSessionPage**
> SessionPage getSessionPage(page, pageSize, startTime, endTime, includeCanceled, deletedParticipants, state, order)



Get a list of sessions. By default, the returned order is  paginated with the first page containing the created sessions  in chronological order (oldest created first). If you set the   \&quot;order\&quot; parameter to \&quot;reverse\&quot;, the newest created sessions  will be returned. You can filter sessions by start and end time,  at which stage the returned result list is ordered by start time  in chronological order (rather than by creation time). The \&quot;order\&quot;  parameter allows you to reverse this order to retrieve sessions by  start time with the newest start time first.

### Example
```java
// Import classes:
//import com.coviu.core.ApiClient;
//import com.coviu.core.ApiException;
//import com.coviu.core.Configuration;
//import com.coviu.core.auth.*;
//import com.coviu.sessions.api.SessionApi;

ApiClient client = new ApiClient();
client.setCredentials("myApiKey", "myApiKeySecret", null);

SessionApi api = new SessionApi(client);
Integer page = 56; // Integer | The page number to return
Integer pageSize = 56; // Integer | The number of sessions per page. Max 200. Default 200.
DateTime startTime = new DateTime(); // DateTime | Includes sessions that start at or after start_time.
DateTime endTime = new DateTime(); // DateTime | Include sessions that start upto and including end_time..
Boolean includeCanceled = true; // Boolean | Includes sessions that have been canceled.
Boolean deletedParticipants = true; // Boolean | Also include participants that have been removed from the session.
String state = "state_example"; // String | Return only sessions containing participants with the supplied state value.
String order = "order_example"; // String | Order the results. forward returns oldest first by start time. backwards includes newest first by startime.
try {
    SessionPage result = api.getSessionPage(page, pageSize, startTime, endTime, includeCanceled, deletedParticipants, state, order);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SessionApi#getSessionPage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **Integer**| The page number to return | [optional]
 **pageSize** | **Integer**| The number of sessions per page. Max 200. Default 200. | [optional]
 **startTime** | **DateTime**| Includes sessions that start at or after start_time. | [optional]
 **endTime** | **DateTime**| Include sessions that start upto and including end_time.. | [optional]
 **includeCanceled** | **Boolean**| Includes sessions that have been canceled. | [optional]
 **deletedParticipants** | **Boolean**| Also include participants that have been removed from the session. | [optional]
 **state** | **String**| Return only sessions containing participants with the supplied state value. | [optional]
 **order** | **String**| Order the results. forward returns oldest first by start time. backwards includes newest first by startime. | [optional]

### Return type

[**SessionPage**](SessionPage.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


# **getSessionParticipant**
> Participant getSessionParticipant(participantId)



Get a single participant by its id.

### Example
```java
// Import classes:
//import com.coviu.core.ApiClient;
//import com.coviu.core.ApiException;
//import com.coviu.core.Configuration;
//import com.coviu.core.auth.*;
//import com.coviu.sessions.api.SessionApi;

ApiClient client = new ApiClient();
client.setCredentials("myApiKey", "myApiKeySecret", null);

SessionApi api = new SessionApi(client);
String participantId = "participantId_example"; // String | The participant id of the participant that the operation applies to.
try {
    Participant result = api.getSessionParticipant(participantId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SessionApi#getSessionParticipant");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **participantId** | **String**| The participant id of the participant that the operation applies to. |

### Return type

[**Participant**](Participant.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


# **getSessionParticipants**
> ParticipantPage getSessionParticipants(sessionId, deletedParticipants)



Get the list of participants for a session.

### Example
```java
// Import classes:
//import com.coviu.core.ApiClient;
//import com.coviu.core.ApiException;
//import com.coviu.core.Configuration;
//import com.coviu.core.auth.*;
//import com.coviu.sessions.api.SessionApi;

ApiClient client = new ApiClient();
client.setCredentials("myApiKey", "myApiKeySecret", null);

SessionApi api = new SessionApi(client);
String sessionId = "sessionId_example"; // String | The session id of the session that the operation applies to.
Boolean deletedParticipants = true; // Boolean | Also include participants that have been removed from the session.
try {
    ParticipantPage result = api.getSessionParticipants(sessionId, deletedParticipants);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SessionApi#getSessionParticipants");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sessionId** | **String**| The session id of the session that the operation applies to. |
 **deletedParticipants** | **Boolean**| Also include participants that have been removed from the session. | [optional]

### Return type

[**ParticipantPage**](ParticipantPage.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


# **updateSession**
> Session updateSession(sessionId, body)



It is possible to update some attributes of a session, namely the start and end time, session name and image. A session that has already finished may not be changed.

### Example
```java
// Import classes:
//import com.coviu.core.ApiClient;
//import com.coviu.core.ApiException;
//import com.coviu.core.Configuration;
//import com.coviu.core.auth.*;
//import com.coviu.sessions.api.SessionApi;

ApiClient client = new ApiClient();
client.setCredentials("myApiKey", "myApiKeySecret", null);

SessionApi api = new SessionApi(client);
String sessionId = "sessionId_example"; // String | The session id of the session that the operation applies to.
SessionUpdateRequest body = new SessionUpdateRequest(); // SessionUpdateRequest | 
try {
    Session result = api.updateSession(sessionId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SessionApi#updateSession");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sessionId** | **String**| The session id of the session that the operation applies to. |
 **body** | [**SessionUpdateRequest**](SessionUpdateRequest.md)|  |

### Return type

[**Session**](Session.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


# **updateSessionParticipant**
> Participant updateSessionParticipant(participantId, body)



It is possible to update a participant&#39;s name, role, picture, and state after it has been created.

### Example
```java
// Import classes:
//import com.coviu.core.ApiClient;
//import com.coviu.core.ApiException;
//import com.coviu.core.Configuration;
//import com.coviu.core.auth.*;
//import com.coviu.sessions.api.SessionApi;

ApiClient client = new ApiClient();
client.setCredentials("myApiKey", "myApiKeySecret", null);

SessionApi api = new SessionApi(client);
String participantId = "participantId_example"; // String | The participant id of the participant that the operation applies to.
ParticipantUpdateRequest body = new ParticipantUpdateRequest(); // ParticipantUpdateRequest | 
try {
    Participant result = api.updateSessionParticipant(participantId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SessionApi#updateSessionParticipant");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **participantId** | **String**| The participant id of the participant that the operation applies to. |
 **body** | [**ParticipantUpdateRequest**](ParticipantUpdateRequest.md)|  |

### Return type

[**Participant**](Participant.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

