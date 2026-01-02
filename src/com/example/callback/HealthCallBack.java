package com.example.callback;

import com.example.map.Coordinates;

public interface HealthCallBack {
    void executeHealth(ActionType actionType, int targetHealth, Coordinates coordinates);
}
