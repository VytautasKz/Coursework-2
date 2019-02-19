package com.company;

import java.text.DecimalFormat;


public class Main {

    static DecimalFormat decimalFormat = new DecimalFormat("#.#"); //Setting a default value for decimalFormat
    static int p = 1; //Initialising a variable needed for decimalFormat
    static int tick = 0; //Simple ticker variable
    static int t = 0; //Simple ticker variable

    public static void main(String[] args) throws InterruptedException {
        //Calling menu
        Menu.menu();
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

}
