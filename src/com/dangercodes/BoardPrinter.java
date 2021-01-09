package com.dangercodes;

import java.util.ArrayList;

public class BoardPrinter {

    BoardPrinter(int[] arr1, int[] arr2){

        ArrayList<Integer> arrList = new ArrayList<>(arr1.length);

        for (int i : arr1)
        {
            arrList.add(i);
        }

        ArrayList<Integer> arrList2 = new ArrayList<>(arr2.length);

        for (int i : arr2)
        {
            arrList2.add(i);
        }

        for (int i = 1; i <= 9; i++){

            if (arrList.contains(i))
                System.out.print("x ");
            else if (arrList2.contains(i))
                System.out.print("o ");
            else
                System.out.print(i+" ");

            if (isFactorOf3(i))
                System.out.println();       //changes the line after 3 elements in each row
        }

    }
    private boolean isFactorOf3(int x){
        return x % 3 == 0;
    }

}
