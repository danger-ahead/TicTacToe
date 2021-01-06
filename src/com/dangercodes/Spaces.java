package com.dangercodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Spaces {

    boolean t = true, f = false, won;
    int index, j = 0, pl1Index = 0, pl2Index = 0;
    int[] indexCheck = new int[9];
    int[] player1index = new int[9];        //stores indexes taken by player1
    int[] player2index = new int[9];        //stores indexes taken by player2

    public void input(){

        Scanner sc = new Scanner(System.in);
        int i;

        for (i=1; t; i++) {                       //loop continues till either player1 or player2 has won
            if (i % 2 == 0) {                     //checks for turns
                System.out.print("Player 2 : Enter index : ");

                while (t) {
                    index = sc.nextInt();
                    if (indexTaken(index) == 1) {       //index has been taken
                        System.out.print("Index Taken, enter another index.\nPlayer 2 : Enter index : ");
                    } else
                        break;
                }
                won = player2(index);
                if (won) {
                    System.out.println("Player 2 has won.");
                    break;
                }
            } else {
                System.out.print("Player 1 : Enter index : ");

                while (t) {
                    index = sc.nextInt();
                    if (indexTaken(index) == 1) {       //index has been taken
                        System.out.print("Index Taken, enter another index.\nPlayer 1 : Enter index : ");
                    } else
                        break;
                }
                won = player1(index);
                if (won){
                    System.out.println("Player 1 has won.");
                    break;
                }
            }
        }
    }

    public int indexTaken(int a){

        boolean doesContain = Arrays.stream(indexCheck).anyMatch(x -> x==a);
        Arrays.sort(indexCheck);
        if (doesContain==t)                      //match found
            return 1;
        else {
            indexCheck[++j] = a;                 //store indexes in indexCheck
            return -1;
        }
    }

    public boolean player1 (int a) {

        player1index[++pl1Index] = a;

        if (hasWonLineWise(player1index)){               //checks if player has line wise
            return t;
        }
        else if (hasWonDiagonally(player1index)){        //checks if player has diagonally
            return t;
        }
        else{
            return f;
        }
    }

    public boolean player2 (int a) {

        player2index[++pl2Index] = a;

        if (hasWonLineWise(player2index)){
            return t;
        }
        else if (hasWonDiagonally(player2index)){
            return t;
        }
        else{
            return f;
        }
    }

    private boolean hasWonLineWise(int[] arr){

        ArrayList<Integer> arrList = new ArrayList<Integer>(arr.length);
        for (int i : arr)           //adding items in ArrayList
        {
            arrList.add(i);
        }

        //checks for index values in player's taken indexes (line wise)//

        if (arrList.contains(1)&&arrList.contains(2)&&arrList.contains(3))
            return t;
        else if (arrList.contains(4)&&arrList.contains(5)&&arrList.contains(6))
            return t;
        else if (arrList.contains(7)&&arrList.contains(8)&&arrList.contains(9))
            return t;
        else if (arrList.contains(1)&&arrList.contains(4)&&arrList.contains(7))
            return t;
        else if (arrList.contains(2)&&arrList.contains(5)&&arrList.contains(8))
            return t;
        else if (arrList.contains(3)&&arrList.contains(6)&&arrList.contains(9))
            return t;
        else
            return f;
    }
    private boolean hasWonDiagonally(int[] arr){

        ArrayList<Integer> arrList2 = new ArrayList<Integer>(arr.length);
        for (int i : arr)
        {
            arrList2.add(i);
        }

        //checks for index values in player's taken indexes (diagonally)//

        if (arrList2.contains(1)&&arrList2.contains(5)&&arrList2.contains(9))
            return t;
        else if (arrList2.contains(3)&&arrList2.contains(5)&&arrList2.contains(7))
            return t;
        else
            return f;
    }
}