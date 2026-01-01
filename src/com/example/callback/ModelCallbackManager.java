package com.example.callback;

import com.example.entities.Creature;
import com.example.map.Coordinates;

public class ModelCallbackManager {
    public void setupCallBack(Creature creature) {
        String creatureType = creature.getClass().getSimpleName();

        creature.setOnMove(coordinates ->
                System.out.printf("%s moved to the cell: [%d, %d]%n", creatureType, coordinates.row(), coordinates.column()));

        creature.setOnMoveImpossible(coordinates ->
                System.out.printf("%s couldn't move from cell: [%d, %d]%n", creatureType, coordinates.row(), coordinates.column()));

        creature.setOnAttack(coordinates ->
                System.out.printf("%s attacked the Herbivore at cell: [%d, %d]%n", creatureType, coordinates.row(), coordinates.column()));

        creature.setOnEat(coordinates ->
                System.out.printf("%s ate the Herbivore at cell: [%d, %d]%n", creatureType, coordinates.row(), coordinates.column()));
    }

    public void setupHealthUpdateCallBack(Creature target) {
        String targetType = target.getClass().getSimpleName();

        target.setOnUpdateHealth((health, coordinates) ->
                System.out.printf("%s health is %d points at: [%d, %d]%n", targetType, health, coordinates.row(), coordinates.column()));
    }
}

//TODO надо как-то соединить ModelCallbackManager с существами... ModelCallbackManager modelCallbackManager = newModelCallbackManager();
//TODO соеденить ModelCallbackManager с существами надо в Action'ах, там задается последовательность того, что делает существо в новом круге
