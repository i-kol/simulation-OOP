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

        creature.setOnMove(new ActionCallBack() {
            @Override
            public void execute(ActionType actionType, Coordinates coordinates) {
                consoleViewMessage.showActionMessage(actionType, creatureType, coordinates);
            }
        });

        creature.setOnMoveImpossible(new ActionCallBack() {
            @Override
            public void execute(ActionType actionType, Coordinates coordinates) {
                consoleViewMessage.showActionMessage(actionType, creatureType, coordinates);
            }
        });

        creature.setOnAttack(new ActionCallBack() {
            @Override
            public void execute(ActionType actionType, Coordinates coordinates) {
                consoleViewMessage.showActionMessage(actionType, creatureType, coordinates);
            }
        });

        creature.setOnEat(new ActionCallBack() {
            @Override
            public void execute(ActionType actionType, Coordinates coordinates) {
                consoleViewMessage.showActionMessage(actionType, creatureType, coordinates);
            }
        });
    }

    public void setupHealthCallBack(Creature creature) {
        String creatureType = creature.getClass().getSimpleName();

        creature.setOnUpdateHealth(new HealthCallBack() {
            @Override
            public void executeHealth(ActionType actionType, int health, Coordinates coordinates) {
                consoleViewMessage.showHealthMessage(actionType, creatureType, coordinates, health);
            }
        });
    }
}

//TODO надо как-то соединить ModelCallbackManager с существами... ModelCallbackManager modelCallbackManager = newModelCallbackManager();
//TODO соеденить ModelCallbackManager с существами надо в Action'ах, там задается последовательность того, что делает существо в новом круге
