package com.company;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    private static DecimalFormat decimalFormat = new DecimalFormat("#.#");
    private static int p = 1;

    public static void main(String[] args) throws InterruptedException {
        menu();
    }

    private static void menu() throws InterruptedException {
        Scanner menuRead = new Scanner(System.in);
        menuText();
        while (true) {
            String choice;
            choice = menuRead.nextLine();
            choice = choice.toLowerCase();
            choice = choice.trim();
            switch (choice) {
                case "calculate":
                case "1":
                    calc();
                    break;
                case "change precision":
                case "2":
                    precision();
                    break;
                case "bubble sort":
                case "3":
                    sort();
                    break;
                case "equation solver":
                case "4":
                    solver();
                    break;
                case "exit":
                case "5":
                    return;
                default:
                    System.out.println("Bad menu input");
                    break;
            }

        }
    }

    private static void precision() throws InterruptedException {
        Scanner precis = new Scanner(System.in);
        System.out.println("Choose how many decimal points to display (1 - 5)");
        try {
            p = precis.nextInt();
            switch (p) {
                case 1:
                    decimalFormat = new DecimalFormat("#.#");
                    break;
                case 2:
                    decimalFormat = new DecimalFormat("#.##");
                    break;
                case 3:
                    decimalFormat = new DecimalFormat("#.###");
                    break;
                case 4:
                    decimalFormat = new DecimalFormat("#.####");
                    break;
                case 5:
                    decimalFormat = new DecimalFormat("#.#####");
                    break;
                default:
                    System.out.println("Cannot display " + p + " decimal points");
                    p = 1;
                    Thread.sleep(300);
            }
        } catch (InputMismatchException e) {
            System.out.println("Bad decimal point input");
            Thread.sleep(300);
        }
        menuText();
    }

    private static void calc() throws InterruptedException {
        Scanner calcu = new Scanner(System.in);
        System.out.println("Enter two numbers and an operator and spaces between them (Ex. 12 + 15)");
        String insertVal = calcu.nextLine();
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
                menuText();
            } else {
                System.out.println("Bad equation format");
                Thread.sleep(300);
                menuText();
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException | InterruptedException e) {
            System.out.println("Unrecognised calculator command");
            Thread.sleep(300);
            menuText();
        }
    }

    private static void sort() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int temp;

        System.out.println("Enter the numbers to sort(e.g 57348567348634)");
        try {
            String raw = sc.nextLine();
            if (!raw.isEmpty()) {
                char[] list = raw.toCharArray();
                int[] num = new int[list.length];

                for (int i = 0; i < list.length; i++) {

                    num[i] = list[i] - '0';
                }
                for (int j = 0; j < (list.length - 1); j++) {
                    for (int k = 0; k < list.length - 1; k++) {
                        if (num[k] > num[k + 1]) {
                            temp = num[k];
                            num[k] = num[k + 1];
                            num[k + 1] = temp;
                        }
                    }
                }

                for (int s = 0; s < list.length; s++) {
                    System.out.print(num[s] + " ");
                }

            } else {
                System.out.println("Nothing to sort");
                Thread.sleep(300);
            }
            System.out.println();
        } catch (InputMismatchException |
                InterruptedException e) {
            System.out.println("Unrecognised sorter input");
            Thread.sleep(300);
        }

        menuText();

    }

    private static void solver() throws InterruptedException {
        Scanner slv = new Scanner(System.in);
        String ans;
        System.out.println("Do you want to round the result? (current precision is set at: " + p + ") Y/N");
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
                    System.out.println(decimalFormat.format(sum));
                } else {
                    System.out.println("X is: " + sum);
                }
            } catch (InputMismatchException e) {
                System.out.println("Unrecognized input");
            }
        } else {
            System.out.println("Unrecognised solver input");
        }
        menuText();
    }

    private static void menuText() throws InterruptedException {
        System.out.println("Choose an option");
        Thread.sleep(300);
        System.out.println("1. Calculate");
        Thread.sleep(300);
        System.out.println("2. Change precision (current precision is set at: " + p + ")");
        Thread.sleep(300);
        System.out.println("3. Bubble Sort");
        Thread.sleep(300);
        System.out.println("4. Equation solver");
        Thread.sleep(300);
        System.out.println("5. Exit");
    }
}