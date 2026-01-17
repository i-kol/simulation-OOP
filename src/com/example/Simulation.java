package com.example;

import com.example.actions.Action;
import com.example.actions.MoveAction;
import com.example.actions.RespawnAction;
import com.example.actions.SpawnAction;
import com.example.map.WorldMap;
import com.example.dialog.Dialog;
import com.example.dialog.IntegerMinMaxDialog;
import com.example.renderer.ConsoleRenderer;
import com.example.renderer.Renderer;

import java.util.List;

public class Simulation {
    private volatile boolean isRunning = true;
    private volatile boolean isPaused = false;
    private final Renderer renderer = new ConsoleRenderer();
    private final Menu menu = new Menu();
    private WorldMap currentWorldMap;

    protected void setCurrentWorldMap(WorldMap worldMap) {
        this.currentWorldMap = worldMap;
    }

    protected WorldMap getCurrentWorldMap() {
        return currentWorldMap;
    }

    protected void startSimulation() throws InterruptedException {
        Dialog<Integer> integerDialog = new IntegerMinMaxDialog(
                "Enter a number between 5 and 50",
                "Invalid number entered!",
                5,
                50);

        System.out.println("\nEnter world map size.\nNumber of rows: ");
        int row = integerDialog.input();
        System.out.println("Enter number of columns: ");
        int column = integerDialog.input();

        WorldMap worldMap = new WorldMap(row, column);
        setCurrentWorldMap(worldMap);

        Action spawnAction = new SpawnAction();
        spawnAction.execute(worldMap);
        renderer.show(worldMap);

        do {
            if (!isPaused) {
                doTurn(worldMap);
                Thread.sleep(1000);
            }
        } while (isRunning);
    }

    public void nextTurn() {
        if (currentWorldMap == null) {
            return;
        }
        pauseSimulation();
        doTurn(currentWorldMap);
    }

    private void doTurn(WorldMap worldMap) {
        List<Action> actions = List.of(new MoveAction(), new RespawnAction());
        for (Action a : actions) {
            a.execute(worldMap);
        }
        renderer.show(worldMap);
        menu.showMenu();
    }

    protected void pauseSimulation() {
        isPaused = true;
    }

    protected void continueSimulation() {
        isPaused = false;
    }

    protected void stopSimulation() {
        isRunning = false;
    }
}
