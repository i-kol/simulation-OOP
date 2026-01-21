package com.example.view;

import com.example.callback.ActionType;
import com.example.map.Coordinates;

public class ConsoleViewMessage {

    public void showAttackMessage(ActionType actionType, String creatureType, String targetType, Coordinates coordinates) {
        switch (actionType) {
            case ATTACK:
                System.out.printf("%s attacked %s at cell: [%d, %d]%n", creatureType, targetType, coordinates.row(), coordinates.column());
                break;
            case EAT:
                System.out.printf("%s ate %s at cell: [%d, %d]%n", creatureType, targetType, coordinates.row(), coordinates.column());
                break;
            default:
                System.out.printf("%s performed unknown action at: [%d, %d]%n", creatureType, coordinates.row(), coordinates.column());
        }
    }

    public void showMoveMessage(ActionType actionType, String creatureType, Coordinates coordinates) {
        switch (actionType) {
            case MOVE:
                System.out.printf("%s moved to the cell: [%d, %d]%n", creatureType, coordinates.row(), coordinates.column());
                break;
            case MOVE_IMPOSSIBLE:
                System.out.printf("%s couldn't move from cell: [%d, %d]%n", creatureType, coordinates.row(), coordinates.column());
                break;
            default:
                System.out.printf("%s performed unknown action at: [%d, %d]%n", creatureType, coordinates.row(), coordinates.column());
        }
    }

    public void showHealthMessage(String creatureType, Coordinates coordinates, int health) {
        System.out.printf("%s health is %d points at: [%d, %d]%n", creatureType, health, coordinates.row(), coordinates.column());
    }
}