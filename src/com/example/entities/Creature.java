package com.example.entities;

import com.example.callback.CallBack;
import com.example.map.Coordinates;
import com.example.map.Pathfinder;
import com.example.map.WorldMap;

import java.util.List;
import java.util.Optional;

public abstract class Creature extends Entity {
    private final int speed;
    private int currentHealth;
    private final int maxHealth;
    private int actionPoint;
    private final int maximumHealthRecovery;
    Class<? extends Entity> target;
    private final Pathfinder pathfinder;
    CallBack onAttack;
    CallBack onEat;
    CallBack onMove;
    CallBack onMoveImpossible;
    CallBack onUpdateHealth;

    public Creature(int speed, int currentHealth, int maxHealth, int actionPoint, int maximumHealthRecovery, Class<? extends Entity> target) {
        this.speed = speed;
        this.currentHealth = currentHealth;
        this.maxHealth = maxHealth;
        this.actionPoint = actionPoint;
        this.maximumHealthRecovery = maximumHealthRecovery;
        this.target = target;
        this.pathfinder = new Pathfinder();
    }

    public void makeMove(WorldMap worldMap, Coordinates coordinates) {
        actionPoint++;
        Optional<Coordinates> currentTarget = fillTarget(worldMap, coordinates);

        if (currentTarget.isPresent()) {
            Coordinates targetCell = currentTarget.get();
            attackTarget(worldMap, targetCell);
        } else {
            makeStep(worldMap, coordinates);
        }
        actionPoint--;
    }

    private Optional<Coordinates> fillTarget(WorldMap worldMap, Coordinates coordinates) {
        List<Coordinates> neighborCells = worldMap.getNeighborCells(coordinates);
        for (Coordinates cell : neighborCells) {
            Entity entity = worldMap.get(cell);
            if (target.isInstance(entity)) {
                return Optional.of(cell);
            }
        }
        return Optional.empty();
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
        } else {
            if (onMoveImpossible != null) {
                onMoveImpossible.execute(coordinates);
            }
        }
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public void setOnAttack(CallBack onAttack) {
        this.onAttack = onAttack;
    }

    public void setOnEat(CallBack onEat) {
        this.onEat = onEat;
    }

    public void setOnMove(CallBack onMove) {
        this.onMove = onMove;
    }

    public void setOnMoveImpossible(CallBack onMoveImpossible) {
        this.onMoveImpossible = onMoveImpossible;
    }

    public void setOnUpdateHealth(CallBack onUpdateHealth) {
        this.onUpdateHealth = onUpdateHealth;
    }
}
