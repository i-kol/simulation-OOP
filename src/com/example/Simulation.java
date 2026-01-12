package com.example;

import com.example.actions.Action;
import com.example.actions.MoveAction;
import com.example.actions.SpawnAction;
import com.example.callback.ModelCallbackManager;
import com.example.factories.WorldMapFactory;
import com.example.map.WorldMap;
import com.example.view.dialog.Dialog;
import com.example.view.dialog.IntegerMinMaxDialog;
import com.example.view.renderer.ConsoleRenderer;
import com.example.view.renderer.Renderer;
import com.example.view.dialog.ConsoleViewMessage;

import java.util.List;

public class Simulation {
    //    nextTurn() - просимулировать и отрендерить один ход
    //    startSimulation() - запустить бесконечный цикл симуляции и рендеринга
    //    pauseSimulation() - приостановить бесконечный цикл симуляции и рендеринга

    private boolean isRunning = true;
    private boolean isPaused = false;

    public void start() {
        WorldMapFactory worldMapFactory = new WorldMapFactory();
        Dialog<Integer> integerDialog = new IntegerMinMaxDialog(
                "Enter a number between 5 and 50",
                "Invalid number entered!",
                5,
                50);

        System.out.println("\nEnter world map size.\nNumber of rows: ");
        int row = integerDialog.input();
        System.out.println("Enter number of columns: ");
        int column = integerDialog.input();

        WorldMap worldMap = worldMapFactory.createWorldMap(row, column);
        Renderer renderer = new ConsoleRenderer();
        SpawnAction spawnAction = new SpawnAction();
        spawnAction.execute(worldMap);
        renderer.show(worldMap);

        do {
            List<Action> actions = List.of(new MoveAction(), new SpawnAction());
            for (Action a : actions) {
                a.execute(worldMap);
            }
            renderer.show(worldMap);
        } while (true);
    }
}
