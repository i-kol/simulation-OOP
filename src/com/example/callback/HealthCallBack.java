package com.example.callback;

import com.example.map.Coordinates;

public interface HealthCallBack {
    void executeHealth(int targetHealth, Coordinates coordinates);
}
