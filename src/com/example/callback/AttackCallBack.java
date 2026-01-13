package com.example.callback;

import com.example.entities.Entity;
import com.example.map.Coordinates;

public interface AttackCallBack {
    void executeAttack(ActionType actionType, Coordinates coordinates, Entity target);
}
