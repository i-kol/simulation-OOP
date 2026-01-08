package com.example;

import com.example.actions.Action;
import com.example.actions.MoveAction;
import com.example.actions.RespawnAction;
import com.example.actions.SpawnAction;
import com.example.callback.ModelCallbackManager;
import com.example.map.WorldMap;
import com.example.view.ConsoleRenderer;
import com.example.view.Renderer;
import com.example.view.dialog.ConsoleViewMessage;

import java.util.List;

public class Simulation {
    //    nextTurn() - просимулировать и отрендерить один ход
    //    startSimulation() - запустить бесконечный цикл симуляции и рендеринга
    //    pauseSimulation() - приостановить бесконечный цикл симуляции и рендеринга

    public void start() {
        WorldMap worldMap = new WorldMap(10, 10);
        ConsoleViewMessage consoleViewMessage = new ConsoleViewMessage();
        ModelCallbackManager modelCallbackManager = new ModelCallbackManager(consoleViewMessage);
        Renderer renderer = new ConsoleRenderer();

//        modelCallbackManager.setupHealthCallBack(herbivore);
//        modelCallbackManager.setupHealthCallBack(herbivore2);
//        modelCallbackManager.setupActionCallBack(predator);

        SpawnAction spawnAction = new SpawnAction();
        spawnAction.execute(worldMap);

        do {
            List<Action> actions = List.of(new MoveAction(), new SpawnAction());
            for (Action a : actions) {
                a.execute(worldMap);
            }
        } while (true);
    }
}
