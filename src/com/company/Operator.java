package com.company;

import java.util.Scanner;

class Operator {
    static void calc() throws InterruptedException {
        Scanner calcu = new Scanner(System.in);
        System.out.println("Enter two numbers and an operator and spaces between them (Ex. 12 + 15)");
        String insertVal = calcu.nextLine();
        String[] split = insertVal.split(" ");
        Calculate calculator = new Calculate();
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
                    System.out.println("Result: " + Main.decimalFormat.format(result));
                }
                Main.menuText();
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

}
