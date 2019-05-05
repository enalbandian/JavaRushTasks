package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame  extends Game {

    private static final int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField = 0;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }


    private void createGame() {
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                boolean b = getRandomNumber(10)==1;
               gameField[j][i] = new GameObject(i,j,b);
               if (b) {
                   countMinesOnField++;
               }
                setCellColor(i,j,Color.GREY);
            }
        }
     //   System.out.println();
    }

    private void countMineNeighbors() {

    }


    private List<GameObject> getNeighbors(GameObject field) {
        List<GameObject> neighbors = new ArrayList<>();

        if (field.x>0 && field.x < SIDE-1 ) {
            if (field.y>0 && field.y < SIDE-1) {

            }
        }

        return neighbors;
    }
}



