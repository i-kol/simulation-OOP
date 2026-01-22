package com.example.callback;

import com.example.entities.Creature;
import com.example.view.ConsoleViewMessage;

public class ModelCallbackManager {
    private final ConsoleViewMessage consoleViewMessage;

    public ModelCallbackManager(ConsoleViewMessage viewMessage) {
        this.consoleViewMessage = viewMessage;
    }

    public void setupAttackCallBack(Creature creature) {
        String creatureType = creature.getClass().getSimpleName();

        AttackCallBack attackCallBack = (actionType, coordinates, target) ->
        {
            String targetType = target.getClass().getSimpleName();
            consoleViewMessage.showAttackMessage(actionType, creatureType, targetType, coordinates);
        };

        creature.setOnAttack(attackCallBack);
        creature.setOnEat(attackCallBack);
    }

    public void setupMoveCallBack(Creature creature) {
        String creatureType = creature.getClass().getSimpleName();

        MoveCallBack moveCallBack = (actionType, coordinates) ->
                consoleViewMessage.showMoveMessage(actionType, creatureType, coordinates);

        creature.setOnMove(moveCallBack);
        creature.setOnMoveImpossible(moveCallBack);
    }

    public void setupHealthCallBack(Creature creature) {
        String creatureType = creature.getClass().getSimpleName();

        HealthCallBack healthCallBack = (actionType, coordinates, health) ->
                consoleViewMessage.showHealthMessage(creatureType, coordinates, health);

        creature.setOnUpdateHealth(healthCallBack);
    }
}
