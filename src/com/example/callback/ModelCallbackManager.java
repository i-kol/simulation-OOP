package com.example.callback;

import com.example.entities.Creature;
import com.example.map.Coordinates;
import com.example.view.dialog.ConsoleViewMessage;

public class ModelCallbackManager {
    private final ConsoleViewMessage consoleViewMessage;

    public ModelCallbackManager(ConsoleViewMessage viewMessage) {
        this.consoleViewMessage = viewMessage;
    }

    public void setupActionCallBack(Creature creature) {
        String creatureType = creature.getClass().getSimpleName();

        ActionCallBack actionCallBack = (actionType, coordinates) ->
                consoleViewMessage.showActionMessage(actionType, creatureType, coordinates);

        creature.setOnMove(actionCallBack);
        creature.setOnMoveImpossible(actionCallBack);
        creature.setOnAttack(actionCallBack);
        creature.setOnEat(actionCallBack);
    }

    public void setupHealthCallBack(Creature creature) {
        String creatureType = creature.getClass().getSimpleName();

        HealthCallBack healthCallBack = (actionType, health, coordinates) ->
                consoleViewMessage.showHealthMessage(actionType, creatureType, coordinates, health);

        creature.setOnUpdateHealth(healthCallBack);
    }
}

//TODO надо как-то соединить ModelCallbackManager с существами... ModelCallbackManager modelCallbackManager = newModelCallbackManager();
//TODO соеденить ModelCallbackManager с существами надо в Action'ах, там задается последовательность того, что делает существо в новом круге
