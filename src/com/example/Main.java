package com.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Simulation simulation = new Simulation();
        Menu menu = new Menu();

        Thread simulationThread = new Thread(simulation::startSimulation);
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
                menu.controlSimulation(simulation);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        menuThread.start();
    }
}
//TODO замедлить скорость рендеринга ходов
//TODO переместить показ меню управления симуляцией под информацию коллбеков
//TODO выяснить, почему не работает запуск симуляции после паузы и выход из симуляции