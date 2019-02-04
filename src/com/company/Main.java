package com.company;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    static DecimalFormat decimalFormat = new DecimalFormat(".#");
    static Scanner sc = new Scanner(System.in);
    static int p = 1;
    static int i = 0;

    public static void main(String[] args) {

        String choice;
        System.out.println("Choose an option\nCalculate\nChange precision (current precision is set at: " + p + ")\nBubble Sort\nEquation solver\nExit");
        while (i == 0) {
            choice = sc.nextLine();
            if (choice.equals("Calculate") || choice.equals("calculate")) {
                calc();
            } else if (choice.equals("Bubble sort") || choice.equals("bubble sort")) {
                sort();
            } else if (choice.equals("Change precision") || choice.equals("change precision")) {
                precision();
            } else if (choice.equals("Equation solver") || choice.equals("equation solver")) {
                solver();
            } else if (choice.equals("Exit") || choice.equals("exit")) {
                return;
            }
        }

    }

    static void precision() {
        int pp = 0;
        System.out.println("Choose how many decimal points to display (1 - 5)");
        while (pp == 0) {
            try {
                p = sc.nextInt();
                if (p == 1) {
                    decimalFormat = new DecimalFormat(".#");
                    pp++;
                } else if (p == 2) {
                    decimalFormat = new DecimalFormat(".##");
                    pp++;
                } else if (p == 3) {
                    decimalFormat = new DecimalFormat(".###");
                    pp++;
                } else if (p == 4) {
                    decimalFormat = new DecimalFormat(".####");
                    pp++;
                } else if (p == 5) {
                    decimalFormat = new DecimalFormat(".#####");
                    pp++;
                }
            } catch (InputMismatchException e) {
                System.out.println("Bad input");
                pp++;
            }
            System.out.println("Choose an option\nCalculate\nChange precision (current precision is set at: " + p + ")\nBubble Sort\nEquation solver\nExit");
        }
    }

    static void calc() {
        System.out.println("Enter two numbers and an operator and spaces between them (Ex. 12 + 15)");
        String insertVal = sc.nextLine();
        String[] split = insertVal.split(" ");
        Main2 calculator = new Main2();
        try {
            double num1 = Double.valueOf(split[0]);
            double num2 = Double.valueOf(split[2]);
            double result = 0;
            if (split.length == 3) {
                switch (split[1]) {
                    case "+":
                        result = calculator.sum(num1, num2);
                        break;
                    case "-":
                        result = calculator.diff(num1, num2);
                        break;
                    case "*":
                        result = calculator.times(num1, num2);
                        break;
                    case "/":
                        if (num2 == 0) {
                            break;
                        } else {
                            result = calculator.div(num1, num2);
                        }
                        break;
                    case "%":
                        if (num2 == 0) {
                            break;
                        } else {
                            result = calculator.mod(num1, num2);
                        }
                        break;
                    default:
                        System.out.println("Bad operator");
                }
                if (num2 == 0) {
                    System.out.println("Infinity");
                } else if (num1 == 0) {
                    System.out.println("Result: " + result);
                } else {
                    System.out.println("Result: " + decimalFormat.format(result));
                }
                System.out.println("Choose an option\nCalculate\nChange precision (current precision is set at: " + p + ")\nBubble Sort\nEquation solver\nExit");
            } else {
                System.out.println("Bad equation format");
                System.out.println("Choose an option\nCalculate\nChange precision (current precision is set at: " + p + ")\nBubble Sort\nEquation solver\nExit");
            }
        } catch (NumberFormatException e) {
            System.out.println("Unrecognized command");
            System.out.println("Choose an option\nCalculate\nChange precision (current precision is set at: " + p + ")\nBubble Sort\nEquation solver\nExit");
        }
    }

    static void sort() {
        int temp;
        int amm;

        System.out.println("Enter how many numbers to sort");
        amm = sc.nextInt();

        int sorter[] = new int[amm];

        System.out.println("Enter the " + amm + " numbers to sort (type in one number and press enter, then keep repeating till the desired amount is reached");

        for (int i = 0; i < amm; i++) {
            sorter[i] = sc.nextInt();
        }

        for (int j = 0; j < (amm - 1); j++) {
            for (int k = 0; k < amm - i - 1; k++) {
                if (sorter[k] > sorter[k + 1]) {
                    temp = sorter[k];
                    sorter[k] = sorter[k + 1];
                    sorter[k + 1] = temp;
                }
            }
        }
        System.out.println("Sorted numbers: ");
        for (int s = 0; s < amm; s++) {
            System.out.print(sorter[s] + " ");
        }
        System.out.println();
        System.out.println("Choose an option\nCalculate\nChange precision (current precision is set at: " + p + ")\nBubble Sort\nEquation solver\nExit");
    }

    static void solver() {
        System.out.println("Do you want to use precision? (current precision is set at: " + p + ") Y/N");
        String ans = sc.nextLine();
        System.out.println("Enter the numbers as follows:\nEquation format is ax + b = c\na - first number");
        double a = sc.nextDouble();
        System.out.println("b - second number");
        double b = sc.nextDouble();
        System.out.println("c - third number");
        double c = sc.nextDouble();
        double sum = c - b;
        sum /= a;
        if (ans == "Y" || ans == "y") {
            System.out.println(decimalFormat.format(sum));
        } else {
            System.out.println("X is: " + sum);
        }
        System.out.println("Choose an option\nCalculate\nChange precision (current precision is set at: " + p + ")\nBubble Sort\nEquation solver\nExit");
    }
}