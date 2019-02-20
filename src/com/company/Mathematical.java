package com.company;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

class Mathematical {

    static void calc() throws InterruptedException {
        Scanner calcu = new Scanner(System.in); //Creating a scanner
        System.out.println("Enter two numbers and an operator and spaces between them (Ex. 12 + 15)");
        String insertVal = calcu.nextLine();    //Read input
        String[] split = insertVal.split(" ");  //Split input where spaces are and store them in an array
        try {
            double num1 = Double.valueOf(split[0]); //Set num1 a value of split[0] which contains a number
            double num2 = Double.valueOf(split[2]); //Set num2 a value of split[2] which contains a number
            double result = 0;
            if (split.length == 3) { //check if array of split is long enough
                switch (split[1]) {//check the operator
                    case "+":
                        result = sum(num1, num2);
                        break;
                    case "-":
                        result = diff(num1, num2);
                        break;
                    case "*":
                        result = times(num1, num2);
                        break;
                    case "/":
                        if (num2 == 0) {
                            break;
                        } else {
                            result = div(num1, num2);
                        }
                        break;
                    case "%":
                        if (num2 == 0) {
                            break;
                        } else {
                            result = mod(num1, num2);
                        }
                        break;
                    default:
                        System.out.println("Bad operator");
                }
                if (num2 == 0) {    //if divided by zero
                    System.out.println("Infinity");
                } else if (num1 == 0) {
                    System.out.println("Result: " + result);
                } else {
                    System.out.println("Result: " + Main.decimalFormat.format(result));
                }
                Main.menuText(); //call menuText
            } else {
                System.out.println("Bad equation format");
                Thread.sleep(300);
                Main.menuText();
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException | InterruptedException e) {
            System.out.println("Unrecognised calculator command");
            Thread.sleep(300);
            Main.menuText();
        }
    }

    static void precision() throws InterruptedException {
        Scanner precis = new Scanner(System.in);    //Create scanner
        System.out.println("Choose how many decimal points to display (1 - 5)");
        try {
            Main.p = precis.nextInt(); //read p for decimalFormat
            //switch checks and sets decimalFormat format accordingly
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
                default:    //error message if value exceeds 5 or is less than 1
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

    //mathematical operation methods
    private static double sum(double num1, double num2) {
        return num1 + num2; //return addition
    }

    private static double diff(double num1, double num2) {
        return num1 - num2; //return subtraction
    }

    private static double times(double num1, double num2) {
        return num1 * num2; //return multiplication
    }

    private static double mod(double num1, double num2) {
        return num1 % num2; //return modulo
    }

    private static double div(double num1, double num2) {
        return num1 / num2; //return division
    }
}

//equations class
class Equations {
    private static double sum;  //defining global variables for the linear and quadratic methods
    private static double a;
    private static double b;
    private static double c;

    static void solver() throws InterruptedException {
        Scanner slv = new Scanner(System.in);   //creating scanner for solver method
        //listing options
        System.out.println("Which equation would you like to use?");
        Thread.sleep(300);
        System.out.println("1. Linear: ax + b = c");
        Thread.sleep(300);
        System.out.println("2. Quadratic: ax^2 + bx + c");
        Thread.sleep(300);
        System.out.println("3. Cancel");
        while (true) {  //input validation loop
            String ch;  //defining string variable
            ch = slv.nextLine();    //setting ch through the scanner
            ch.toLowerCase();       //converting to lowercase
            ch.trim();              //removing whitespaces

            switch (ch) {           //comparing ch to cases and running code when matched
                case "1":
                case "linear":
                    linear();       //calling linear method
                    return;
                case "2":
                case "quadratic":
                    quadratic();    //calling quadratic method
                    return;
                case "cancel":
                case "3":
                    return;         //returning to main
                default:
                    System.out.println("Unrecognised choice");
            }
        }
    }

    private static void inputScan() {
        Scanner in = new Scanner(System.in);        //creating another scanner for linear method, so it does not interfere with other method scanners
        System.out.println("Enter the numbers as follows:\na- first number");
        try {                   //try and catch input mismatch
            //read numbers
            a = in.nextDouble();
            System.out.println("b - second number");
            b = in.nextDouble();
            System.out.println("c - third number");
            c = in.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Input mismatch");
            inputScan();
        }
    }

    private static void linear() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);   //scanner for rounding
        inputScan();

        //calculating linear equation
        sum = c - b;
        sum /= a;
        System.out.println("Would you like to round the result? (Current precision is set to " + Main.p + ")");
        String ans;
        ans = scanner.nextLine();

        //checking if result needs to be rounded
        if (ans.equals("y")) {
            System.out.println("X = " + Main.decimalFormat.format(sum));    //decimalFormat rounds result to set precision
        } else if (ans.equals("n")) {
            System.out.println("X = " + sum);
        } else {
            System.out.println("Unrecognised input, rounding by default");
            Thread.sleep(300);
            System.out.println("X = " + Main.decimalFormat.format(sum));

        }
    }

    private static void quadratic() throws InterruptedException {
        inputScan();

        double d = Math.pow(b, 2) - 4 * a * c;                          //calculating discriminant

        //depending on result of discriminant, appropriate answer is outputted
        if (d > 0) {
            System.out.println("There are two roots");
            Thread.sleep(300);
            //calculating roots
            System.out.println(((-b + Math.sqrt(d)) / (2 * a)));
            Thread.sleep(300);
            System.out.println(((-b - Math.sqrt(d)) / (2 * a)));
        } else if (d == 0) {
            System.out.println("There is only one root");
            Thread.sleep(300);
            System.out.println(((-b + Math.sqrt(d)) / (2 * a)));
        } else {
            System.out.println("There are no roots");
            Thread.sleep(300);
            System.out.println("The discriminant was: " + d);
        }
    }
}
