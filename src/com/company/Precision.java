package com.company;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

class Precision {
    static void precision() throws InterruptedException {
        Scanner precis = new Scanner(System.in);
        System.out.println("Choose how many decimal points to display (1 - 5)");
        try {
            Main.p = precis.nextInt();
            switch (Main.p) {
                case 1:
                    Main.decimalFormat = new DecimalFormat("#.#");
                    break;
                case 2:
                    Main.decimalFormat = new DecimalFormat("#.##");
                    break;
                case 3:
                    Main.decimalFormat = new DecimalFormat("#.###");
                    break;
                case 4:
                    Main.decimalFormat = new DecimalFormat("#.####");
                    break;
                case 5:
                    Main.decimalFormat = new DecimalFormat("#.#####");
                    break;
                default:
                    System.out.println("Cannot display " + Main.p + " decimal points");
                    Main.p = 1;
                    Thread.sleep(300);
            }
        } catch (InputMismatchException e) {
            System.out.println("Bad decimal point input");
            Thread.sleep(300);
        }
        Main.menuText();
    }
}
