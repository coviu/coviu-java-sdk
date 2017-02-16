package com.coviu.auth;

import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class Authorization {

    @SerializedName("grant")
    private GrantResponse grant;

    @SerializedName("scheduled_refresh")
    private final Long scheduledRefresh;

    @SerializedName("received_at")
    private final Long receivedAt;

    private Authorization(GrantResponse grant, Long receivedAt, Long scheduledRefresh) {
        this.grant = grant;
        this.scheduledRefresh = scheduledRefresh;
        this.receivedAt = receivedAt;
    }

    private static final Long MS_IN_SEC = 1000l;
    private static final Long REFRESH_PERIOD = 2l;
    private static final Long SCALE_EXPIRES_IN =  MS_IN_SEC / REFRESH_PERIOD;

    public Boolean isExpired() {
        return new Date().getTime() > scheduledRefresh;
    }

    public static Authorization newAuthorization(GrantResponse grant) {
        Long now = new Date().getTime();
        Long refresh = now + grant.getExpiresIn() * SCALE_EXPIRES_IN;
        return new Authorization(grant, now, refresh);
    }

    public String getAccessToken() {
        return grant.getAccessToken();
    }

    public String getRefreshToken() {
        return grant.getRefreshToken();
    }

    public String serialise() {
        return store(this);
    }

    public Long getScheduledRefresh() {
        return scheduledRefresh;
    }

    public Long getReceivedAt() {
        return receivedAt;
    }

    public GrantResponse getGrant() {
        return grant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Authorization r = (Authorization) o;
        return this.scheduledRefresh.equals(r.scheduledRefresh)
            && this.grant.equals(r.grant);
    }

    public static Authorization load(String json) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(json, Authorization.class);
    }

    public static String store(Authorization authorization) {
        Gson gson = new GsonBuilder().create();
        return  gson.toJson(authorization);
    }
}
