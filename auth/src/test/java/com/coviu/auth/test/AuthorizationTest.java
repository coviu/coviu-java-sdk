package com.coviu.auth.test;

import com.coviu.auth.Authorization;
import com.coviu.auth.GrantResponse;
import junit.framework.*;

public class AuthorizationTest extends TestCase {

    private GrantResponse buildGrant(String seed) {
       return new GrantResponse()
        .setAccessToken("accessToken" + seed)
        .setRefreshToken("refresToken" + seed)
        .setExpiresIn(300l)
        .setTokenType("bearer" + seed)
        .setScope("scope" + seed);
    }

    private Authorization buildAuthorization(String seed) {
        return Authorization.newAuthorization(buildGrant(seed));
    }

    public void testCanSerialise() {
        String str = buildAuthorization("testCanSerialise").serialise();
        assertTrue(str.startsWith("{") && str.endsWith("}"));
    }

    public void testCanDeserialise() {
        Authorization auth = Authorization.load(buildAuthorization("testCanDeserialse").serialise());
        assertTrue(auth != null);
    }

    public void testStatePreserved() {
        Authorization auth1 = buildAuthorization("testStatePreserved");
        Authorization auth2 = Authorization.load(auth1.serialise());
        assertTrue(auth1.equals(auth2));
    }

    public void testRefreshTime() {
        GrantResponse grant = buildGrant("testRefreshTime");
        Authorization authz = Authorization.newAuthorization(grant);
        Long scheduledRefresh = authz.getScheduledRefresh();
        Long receivedAt  = authz.getReceivedAt();
        assertTrue(scheduledRefresh - receivedAt == 150000);
    }

}
