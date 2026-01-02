package com.example.callback;

import com.example.map.Coordinates;

public interface ActionCallBack {
    void execute(ActionType actionType, Coordinates coordinates);
}
