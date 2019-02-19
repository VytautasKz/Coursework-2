package com.company;

import java.util.Scanner;

class Operator {
    static void calc() throws InterruptedException {
        Scanner calcu = new Scanner(System.in); //Creating a scanner
        System.out.println("Enter two numbers and an operator and spaces between them (Ex. 12 + 15)");
        String insertVal = calcu.nextLine();    //Read input
        String[] split = insertVal.split(" ");  //Split input where spaces are and store them in an array
        Calculate calculator = new Calculate();       //Create object called calculator
        try {
            double num1 = Double.valueOf(split[0]); //Set num1 a value of split[0] which contains a number
            double num2 = Double.valueOf(split[2]); //Set num2 a value of split[2] which contains a number
            double result = 0;
            if (split.length == 3) { //check if array of split is long enough
                switch (split[1]) {//check the operator
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

}
