package com.example.callback;

import com.example.map.Coordinates;

public interface HealthCallBack {
    void executeHealth(ActionType actionType, Coordinates coordinates, int targetHealth);
}
