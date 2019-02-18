package com.company;

import java.util.Scanner;

class Menu {
    static void menu() throws InterruptedException {
        Scanner menuRead = new Scanner(System.in);
        Main.menuText();
        while (true) {
            String choice;
            choice = menuRead.nextLine();
            choice = choice.toLowerCase();
            choice = choice.trim();
            switch (choice) {
                case "calculate":
                case "1":
                    Operator.calc();
                    break;
                case "change precision":
                case "2":
                    Precision.precision();
                    break;
                case "bubble sort":
                case "3":
                    BSort.sort();
                    break;
                case "equation solver":
                case "4":
                    Equations.solver();
                    break;
                case "exit":
                case "5":
                    return;
                case "6":
                    Bug.hello();
                    break;
                default:
                    System.out.println("Bad menu input");
                    break;
            }
            Main.tick++;

        }
    }

}
