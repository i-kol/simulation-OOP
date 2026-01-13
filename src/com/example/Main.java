package com.example;

public class Main {
    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        simulation.start();
    }
}

//TODO исправить ошибку: респаун происходит на каждом ходу, вне зависимости от того, ноль сущностей или нет
//TODO травоядное ест травоядных. Надо сделать еще один CallBack для атак и поедания. Сделать один интерфейс CallBack, а от него 3 имплементирующих класса с подвидами коллбэков
//TODO сделать CallBack для спауна и респауна сущностей