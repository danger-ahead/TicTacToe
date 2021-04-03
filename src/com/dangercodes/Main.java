package com.dangercodes;

public class Main {

    public static void main(String[] args) {
        System.out.println("The index positions of the board are:");
        for (int i = 1; i <= 9; i++){
            System.out.print(i+" ");

            if (i%3 == 0)
                System.out.println();
        }
        Spaces spaces = new Spaces();
        spaces.input();
    }
}


/*//-------------------------------------//
                BY SHOURYA
//-------------------------------------//*/
