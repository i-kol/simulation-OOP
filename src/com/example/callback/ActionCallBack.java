package com.example.callback;

import com.example.map.Coordinates;

public interface ActionCallBack {
    void executeAction(ActionType actionType, Coordinates coordinates);
}
