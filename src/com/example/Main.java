package com.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        Simulation simulation = new Simulation();
        Menu menu = new Menu();

        Thread simulationThread = new Thread(() ->
        {
            try {
                simulation.startSimulation();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        simulationThread.start();

        while (simulation.getCurrentWorldMap() == null) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        Thread menuThread = new Thread(() -> {
            try {
                menu.execute(simulation);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        menuThread.start();
    }
}
