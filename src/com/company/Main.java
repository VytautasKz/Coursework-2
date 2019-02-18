package com.company;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    static DecimalFormat decimalFormat = new DecimalFormat("#.#");
    static int p = 1;
    static int tick = 0;
    static int t = 0;

    public static void main(String[] args) throws InterruptedException {
        Menu.menu();
    }

    static void menuText() throws InterruptedException {
        System.out.println("/////////////////////////////////////////////////////////////");
        Thread.sleep(300);
        System.out.println("Choose an option                                            /");
        Thread.sleep(300);
        System.out.println("1. Calculate                                                /");
        Thread.sleep(300);
        System.out.println("2. Change precision (current precision is set at: " + p + ")        /");
        Thread.sleep(300);
        System.out.println("3. Bubble Sort                                              /");
        Thread.sleep(300);
        System.out.println("4. Equation solver                                          /");
        Thread.sleep(300);
        System.out.println("5. Exit                                                     /");
        Thread.sleep(300);
        if (tick == 0) {
            System.out.println("6. ???");
            Thread.sleep(300);
            tick++;
        }
        System.out.println("/////////////////////////////////////////////////////////////");
    }

}
