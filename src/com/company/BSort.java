package com.company;

import java.util.Scanner;

class BSort {
    static void sort() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int temp;

        System.out.println("Enter the numbers to sort(e.g 57348567348634)");
        String raw = sc.nextLine();
        if (raw.matches("[a-zA-Z]+")) {
            System.out.println("Input mismatch");
        } else {
            char[] list = raw.toCharArray();
            int[] num = new int[list.length];

            for (int i = 0; i < list.length; i++) {

                num[i] = list[i] - '0';
            }
            for (int j = 0; j < (list.length - 1); j++) {
                for (int k = 0; k < list.length - 1; k++) {
                    if (num[k] > num[k + 1]) {
                        temp = num[k];
                        num[k] = num[k + 1];
                        num[k + 1] = temp;
                    }
                }
            }

            for (int s = 0; s < list.length; s++) {
                System.out.print(num[s] + " ");
            }

            System.out.println();
        }

        Main.menuText();

    }

}
