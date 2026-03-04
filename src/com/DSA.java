package com;

public class DSA {
    public static void main(String[] args) {
        // Number pattern problem :
        pattern(6);

        // parallel star pattern :
        pattern2(3);

        // numbern pattern :
        pattern3(5);
 
        // row wise number pattern print :
        pattern4(4);
    }
    public static void pattern(int n){
        for (int i = 1 ; i<=n ; i++){
            for (int j = 1 ; j<=n ; j++){
                System.out.print(n);
            }
            System.out.println();
        }
    }
    public static void pattern2(int n){
        for (int i = 1 ; i<=n ; i++){
            for (int j = 1 ; j<=n ; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern3(int n){
        for (int i = 1 ; i<=n ; i++){
            for (int j = 1 ; j<=n ; j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void pattern4(int n){
        for (int i = 1 ; i<=n ; i++){
            for (int j = 1 ; j<=n ; j++){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
