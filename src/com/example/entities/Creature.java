package com.example.entities;

import com.example.map.Coordinates;
import com.example.map.Pathfinder;
import com.example.map.WorldMap;

import java.util.List;

public abstract class Creature extends Entity {
    private final int speed;
    private int currentHealth;
    private final int maxHealth;
    private int actionPoint;
    private final int maximumHealthRecovery;
    Class<? extends Entity> target;
    private final Pathfinder pathfinder;
    private CallBack onAttack;
    private CallBack onMove;
    private CallBack onMoveImpossible;


    public Creature(int speed, int currentHealth, int maxHealth, int actionPoint, int maximumHealthRecovery, Class<? extends Entity> target) {
        this.speed = speed;
        this.currentHealth = currentHealth;
        this.maxHealth = maxHealth;
        this.actionPoint = actionPoint;
        this.maximumHealthRecovery = maximumHealthRecovery;
        this.target = target;
        this.pathfinder = new Pathfinder();
    }

    private void makeMove(WorldMap worldMap, Coordinates coordinates) {
        actionPoint++;

        if (isTarget(worldMap, coordinates)) {
            attackTarget(worldMap, coordinates);
        }
        if (actionPoint > 0) {
            makeStep(worldMap, coordinates);
        }
    }

    private boolean isTarget(WorldMap worldMap, Coordinates coordinates) {
        List<Coordinates> neighborCells = worldMap.getNeighborCells(coordinates);
        for (Coordinates cell : neighborCells) {
            Entity entity = worldMap.get(cell);
            if (target.isInstance(entity) && actionPoint > 0) {
                return true;
            }
        }
        return false;
    }

    protected abstract void attackTarget(WorldMap worldMap, Coordinates coordinates);

    protected void restoreHealth() {
        if (currentHealth > (maxHealth - maximumHealthRecovery)) {
            currentHealth = maxHealth;
        } else {
            currentHealth += maximumHealthRecovery;
        }
    }

    private void makeStep(WorldMap worldMap, Coordinates coordinates) {
        List<Coordinates> path = pathfinder.findPath(worldMap, coordinates, target);
        Coordinates nextStep;

        if (!path.isEmpty() && actionPoint > 0) {
            worldMap.remove(coordinates);

            if (path.size() - 1 > speed) {
                nextStep = path.get(speed);
                worldMap.put(this, nextStep);
            } else {
                nextStep = path.get(path.size() - 2);
                worldMap.put(this, nextStep);
            }

            actionPoint--;
            if (onMove != null) {
                onMove.execute(nextStep);
            }
//            System.out.println(getClass().getSimpleName() + " moved to the coordinate: [" + coordinates.row() + "," + coordinates.column() + "]");
        } else {
            if (onMoveImpossible != null) {
                onMoveImpossible.execute(coordinates);
            }
//            System.out.println(getClass().getSimpleName() + " cannot move because it cannot see the way");
        }
    }

    public interface CallBack {
        void execute(Coordinates coordinates);
    }

    public void setOnAttack(CallBack onAttack) {
        this.onAttack = onAttack;
    }

    public void setOnMove(CallBack onMove) {
        this.onMove = onMove;
    }

    public void setOnMoveImpossible(CallBack onMoveImpossible) {
        this.onMoveImpossible = onMoveImpossible;
    }

    //TODO прикрутить эти сеттеры для вывода информации о ходах в слое View
    //TODO creature.setOnMove(coordinates -> isMove = true("Move to" + coordinates)) - есть в проекте Snake и на видео
}
