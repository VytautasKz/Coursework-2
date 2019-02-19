package com.company;

import java.util.Scanner;

class BSort {
    static void sort() throws InterruptedException {
        Scanner sc = new Scanner(System.in);    //Create scanner
        int temp; //placeholder integer

        System.out.println("Enter the numbers to sort(e.g 57348567348634)");
        String raw = sc.nextLine(); //read input
        if (raw.matches("[a-zA-Z]+")) { //check if raw contains letters
            System.out.println("Input mismatch");
        } else {
            char[] list = raw.toCharArray();    //create char array
            int[] num = new int[list.length];   //create integer array

            for (int i = 0; i < list.length; i++) {

                num[i] = list[i] - '0'; //num[i] gets value of list[i]
            }
            for (int j = 0; j < (list.length - 1); j++) {   //loop with a length of the list array
                for (int k = 0; k < list.length - 1; k++) { //nested loop with a length of the list array
                    if (num[k] > num[k + 1]) {
                        temp = num[k];                      //temp gets value of num[k]
                        num[k] = num[k + 1];                //num[k] gets value of num[k+1]
                        num[k + 1] = temp;                  //num[k+1] gets value of temp
                    }
                }
            }

            //loop to output all elements of array
            for (int s = 0; s < list.length; s++) {
                System.out.print(num[s] + " ");
            }

            System.out.println();
        }

        Main.menuText();

    }

}
