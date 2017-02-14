package com.coviu;

import com.coviu.auth.Authorization;

public interface RefreshObserver {
    void onRefresh(Authorization az);
}
