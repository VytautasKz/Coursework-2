package com.company;

import java.util.Scanner;

class Menu {
    static void menu() throws InterruptedException {
        Scanner menuRead = new Scanner(System.in);  //Creating a scanner
        Main.menuText();    //Calling method menuText from class Main
        while (true) {
            String choice;                  //Creating a variable to use in switch
            choice = menuRead.nextLine();   //Reading input
            choice = choice.toLowerCase();  //Making input lowercase
            choice = choice.trim();         //Removes spaces from beginning and end of string
            switch (choice) {               //Switch compares variable choice to see if it is equal to the cases
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
                default:                    //Defaults to here if choice does not match anything
                    System.out.println("Bad menu input");
                    break;
            }
            Main.tick++;
        }
    }

}
