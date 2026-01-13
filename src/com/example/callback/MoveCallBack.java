package com.example.callback;

import com.example.map.Coordinates;

public interface MoveCallBack {
    void executeMove(ActionType actionType, Coordinates coordinates);
}
