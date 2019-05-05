package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {


    public static Hippodrome game;

    private List<Horse> horses;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    //Добавь в класс Hippodrome методы run, move и print. Без параметров.
    public void run() {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    public void move() {
        for (Horse h:
             horses) {
            h.move();

        }
    }



    public void print() {

        for (Horse hr:
                horses) {
            hr.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

/*
Метод getWinner должен возвращать лошадь пробежавшую самую большую дистанцию.
Метод printWinner выводит на экран имя победителя в виде: Winner is <name>!
 */

public Horse getWinner() {
    int index = 0;
    for (int i = 1; i < horses.size(); i++) {
        if (horses.get(i).getDistance() > horses.get(index).getDistance()) {
            index = i;
        }
    }
    return horses.get(index);
}


    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() +"!");
    }


    public static void main(String[] args) {

        List<Horse> horses = new ArrayList<>();
        //б) Создать три объекта "лошадь". Имена придумай сам. Начальные скорость у всех лошадей - 3, дистанция - 0.

        Horse h1 = new Horse("kuch", 3, 0);
        Horse h2 = new Horse("ed11", 3, 0);
        Horse h3 = new Horse("mur1", 3, 0);

        horses.add(h1);
        horses.add(h2);
        horses.add(h3);
        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }
}
