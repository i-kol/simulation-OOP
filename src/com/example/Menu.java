package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    private final static String PAUSE = "1";
    private final static String CONTINUE = "2";
    private final static String ONE_TURN = "3";
    private final static String STOP = "4";

    public void showMenu() {
        System.out.println("Press:");
        System.out.printf("%s and \"Enter\" - to pause the simulation %n", PAUSE);
        System.out.printf("%s and \"Enter\" - to continue the simulation %n", CONTINUE);
        System.out.printf("%s and \"Enter\" - to make 1 move %n", ONE_TURN);
        System.out.printf("%s and \"Enter\" - to stop the simulation and exit %n", STOP);
    }

    public void execute(Simulation simulation) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = reader.readLine();

            switch (input) {
                case PAUSE:
                    System.out.println("You have paused the simulation");
                    simulation.pauseSimulation();
                    break;
                case CONTINUE:
                    System.out.println("You continued the simulation");
                    simulation.continueSimulation();
                    break;
                case ONE_TURN:
                    simulation.nextTurn();
                    break;
                case STOP:
                    System.out.println("You stop the simulation");
                    simulation.stopSimulation();
                    return;
                default:
                    System.out.println("Unknown command!");
            }
        }
    }
}
