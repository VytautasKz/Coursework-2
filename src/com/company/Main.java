package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;


public class Main {

    static DecimalFormat decimalFormat = new DecimalFormat("#.#"); //Setting a default value for decimalFormat
    static int p = 1; //Initialising a variable needed for decimalFormat
    private static int tick = 0; //Simple ticker variable
    private static int t = 0; //Simple ticker variable

    public static void main(String[] args) throws InterruptedException {
        //Calling menu
        menu();
    }

    private static void menu() throws InterruptedException {
        Scanner menuRead = new Scanner(System.in);  //Creating a scanner
        menuText();    //Calling method menuText
        while (true) {
            String choice;                  //Creating a variable to use in switch
            choice = menuRead.nextLine();   //Reading input
            choice = choice.toLowerCase();  //Making input lowercase
            choice = choice.trim();         //Removes spaces from beginning and end of string
            switch (choice) {               //Switch compares variable choice to see if it is equal to the cases
                case "calculate":
                case "1":
                    Mathematical.calc();
                    break;
                case "change precision":
                case "2":
                    Mathematical.precision();
                    break;
                case "bubble sort":
                case "3":
                    Mathematical.sort();
                    break;
                case "equation solver":
                case "4":
                    Mathematical.solver();
                    break;
                case "exit":
                case "5":
                    return;
                case "6":
                    hello();
                    break;
                default:                    //Defaults to here if choice does not match anything
                    System.out.println("Bad menu input");
                    break;
            }
            Main.tick++;
        }
    }

    static void menuText() throws InterruptedException {
        //Prints available options to console
        System.out.println("/////////////////////////////////////////////////////////////");
        Thread.sleep(300);                                                            //Pause output for 300 milliseconds
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
        if (tick == 0) {                                                                    //Checks if variable tick is equal to 0
            System.out.println("6. ???");
            Thread.sleep(300);
            tick++;                                                                         //Increases tick by 1
        }
        System.out.println("/////////////////////////////////////////////////////////////");
    }

    private static void hello() throws InterruptedException {
        if (Main.tick == 0 || Main.t == 0) {
            System.out.println("                     Created by:");
            System.out.println();
            System.out.println("  #####   #####   #####  #       #######   ###     ###   ");
            System.out.println(" #     # #     # #     # #    #  #    #   #   #   #   #  ");
            System.out.println(" #     # #       #     # #    #      #   #     # #     # ");
            System.out.println("  #####  ######   ###### #    #     #    #     # #     # ");
            System.out.println(" #     # #     #       # #######   #     #     # #     # ");
            System.out.println(" #     # #     # #     #      #    #      #   #   #   #  ");
            System.out.println("  #####   #####   #####       #    #       ###     ###   ");
            System.out.println();
            System.out.println("                     Vytautas Kuzma");
            Main.t++;
        } else {
            System.out.println("Bad input");
        }

        Main.menuText();
    }
}
