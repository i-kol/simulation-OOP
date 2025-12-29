package com.example.callback;

import com.example.entities.Creature;
import com.example.map.Coordinates;

public class ModelCallbackManager {
    public void setupCallBack(Creature creature, Coordinates coordinates) {
        String creatureType = creature.getClass().getSimpleName();

        creature.setOnMove(c ->
                System.out.printf("%s moved to the cell: [%d, %d]%n", creatureType, coordinates.row(), coordinates.column()));

        creature.setOnMoveImpossible(c ->
                System.out.printf("%s couldn't move from cell: [%d, %d]%n", creatureType, coordinates.row(), coordinates.column()));

        creature.setOnAttack(c ->
                System.out.printf("%s attacked the Herbivore at cell: [%d, %d]%n", creatureType, coordinates.row(), coordinates.column()));

        creature.setOnEat(c ->
                System.out.printf("%s ate the Herbivore at cell: [%d, %d]%n", creatureType, coordinates.row(), coordinates.column()));
    }

    public void setupHealthUpdateCallBack(Creature target, Coordinates coordinates) {
        String targetType = target.getClass().getSimpleName();
        int targetHealth = target.getCurrentHealth();

        target.setOnUpdateHealth(c ->
                System.out.printf("%s health is %d points %n", targetType, targetHealth));
    }
}

//TODO надо как-то соединить ModelCallbackManager с существами... ModelCallbackManager modelCallbackManager = newModelCallbackManager();
//TODO нужно ли в параметры метода execute добавлять существо или оставить только координату?
//TODO creature.setOnMove(coordinates -> isMove = true("Move to" + coordinates)) - есть в проекте Snake и на видео (part6 33:50)
