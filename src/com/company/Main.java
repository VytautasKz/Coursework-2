package com.company;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    private static DecimalFormat decimalFormat = new DecimalFormat(".#");
    private static Scanner sc = new Scanner(System.in);
    private static int p = 1;

    public static void main(String[] args) {

        String choice;
        System.out.println("Choose an option\nCalculate\nChange precision (current precision is set at: " + p + ")\nBubble Sort\nEquation solver\nExit");
        while (true) {
            choice = sc.nextLine();
            choice = choice.toLowerCase();
            switch (choice) {
                case "calculate":
                    calc();
                    break;
                case "change precision":
                    precision();
                    break;
                case "bubble sort":
                    sort();
                    break;
                case "equation solver":
                    solver();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Unrecognised input");
            }
        }

    }

    private static void precision() {
        int pp = 0;
        System.out.println("Choose how many decimal points to display (1 - 5)");
        try {
            p = sc.nextInt();
            switch (p) {
                case 1:
                    decimalFormat = new DecimalFormat(".#");
                    break;
                case 2:
                    decimalFormat = new DecimalFormat(".##");
                    break;
                case 3:
                    decimalFormat = new DecimalFormat(".###");
                    break;
                case 4:
                    decimalFormat = new DecimalFormat(".####");
                    break;
                case 5:
                    decimalFormat = new DecimalFormat(".#####");
                    break;
                default:
                    System.out.println("Cannot display " + p + " decimal points");
                    p = 1;
            }
        } catch (InputMismatchException e) {
            System.out.println("Bad input");
        }
        System.out.println("Choose an option\nCalculate\nChange precision (current precision is set at: " + p + ")\nBubble Sort\nEquation solver\nExit");
    }

    private static void calc() {
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
            System.out.println("Unrecognised command");
            System.out.println("Choose an option\nCalculate\nChange precision (current precision is set at: " + p + ")\nBubble Sort\nEquation solver\nExit");
        }
    }

    private static void sort() {
        int temp;
        int amm;

        System.out.println("Enter how many numbers to sort");
        try {
            amm = sc.nextInt();

            if (amm > 0) {
                int[] sorter = new int[amm];

                System.out.println("Enter the " + amm + " numbers to sort (type in one number and press enter, then keep repeating till the desired amount is reached");

                for (int i = 0; i < amm; i++) {
                    sorter[i] = sc.nextInt();
                }

                for (int j = 0; j < (amm - 1); j++) {
                    for (int k = 0; k < amm - 1; k++) {
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
            } else {
                System.out.println("Nothing to sort");
            }
        } catch (InputMismatchException e) {
            System.out.println("Unrecognised input");
        }
        System.out.println();
        System.out.println("Choose an option\nCalculate\nChange precision (current precision is set at: " + p + ")\nBubble Sort\nEquation solver\nExit");
    }

    private static void solver() {
        String ans;
        System.out.println("Do you want to round the result? (current precision is set at: " + p + ") Y/N");
        ans = sc.nextLine();
        ans = ans.toLowerCase();
        if (ans.equals("y") || ans.equals("n")) {
            System.out.println("Equation format is ax + b = c\nEnter the numbers as follows:\na - first number");
            try {
                double a = sc.nextDouble();
                System.out.println("b - second number");
                double b = sc.nextDouble();
                System.out.println("c - third number");
                double c = sc.nextDouble();
                double sum = c - b;
                sum /= a;
                if (ans.equals("y")) {
                    System.out.println(decimalFormat.format(sum));
                } else {
                    System.out.println("X is: " + sum);
                }
            } catch (InputMismatchException e) {
                System.out.println("Unrecognized input");
            }
        } else {
            System.out.println("Unrecognised input");
        }
        System.out.println("Choose an option\nCalculate\nChange precision (current precision is set at: " + p + ")\nBubble Sort\nEquation solver\nExit");
    }
}