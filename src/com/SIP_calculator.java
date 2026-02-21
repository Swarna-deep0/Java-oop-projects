package com;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SIP_calculator {
    public static double calculate(int pa,int ir ,int t){
        double T = pa;
        for (int i = 0; i < t; i++) {
            T = T + (T * ir/100);
        }
        return T;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean valid = true;
        while (valid) {
            try {
                System.out.print("Enter your principle amount : ");
                int pa = sc.nextInt();
                System.out.print("Enter your CAGR : ");
                int ir = sc.nextInt();
                System.out.print("Enter your Tenure : ");
                int t = sc.nextInt();
                double Total = calculate(pa,ir,t);
                System.out.println("Total amount is : " + Total);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Not allowed - Please enter valid numbers");
                sc.next(); // Clear the invalid input from buffer
            }
        }
    }
}

