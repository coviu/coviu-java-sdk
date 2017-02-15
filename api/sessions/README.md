# coviu-sdk-sessions

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