package ControlFlowStatement;

import java.util.Scanner;

class ValidTriangle {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter three sides of a triangle: ");
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            
            if (a + b > c && a + c > b && b + c > a)
                System.out.println("Valid Triangle");
            else
                System.out.println("Invalid Triangle");
        }
    }
}