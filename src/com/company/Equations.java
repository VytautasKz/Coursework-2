package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

class Equations {
    static void solver() throws InterruptedException {
        Scanner slv = new Scanner(System.in);
        String ans;
        System.out.println("Do you want to round the result? (current precision is set at: " + Main.p + ") Y/N");
        ans = slv.nextLine();
        ans = ans.toLowerCase();
        if (ans.equals("y") || ans.equals("n")) {
            System.out.println("Equation format is ax + b = c");
            Thread.sleep(300);
            System.out.println("Enter the numbers as follows:");
            Thread.sleep(300);
            System.out.println("a - first number");
            try {
                double a = slv.nextDouble();
                System.out.println("b - second number");
                double b = slv.nextDouble();
                System.out.println("c - third number");
                double c = slv.nextDouble();
                double sum = c - b;
                sum /= a;
                if (ans.equals("y")) {
                    System.out.println("X = " + Main.decimalFormat.format(sum));
                } else {
                    System.out.println("X = " + sum);
                }
            } catch (InputMismatchException e) {
                System.out.println("Unrecognized input");
            }
        } else {
            System.out.println("Unrecognised solver input");
        }
        Main.menuText();
    }
}
