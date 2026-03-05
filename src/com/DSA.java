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

        // Binary search algo :
        int[]arr = new int[6];
        arr[0]=1;
        arr[1]=0;
        arr[2]=5;
        arr[3]=7;
        arr[4]=7;
        arr[5]=9;
        System.out.println(binarysearch(arr,7));
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

    public static int binarysearch(int[]arr,int x){
        int s = 0; //starting
        int l = arr.length - 1; //Ending
        while (s<=l) {
            int mid = (s + l) / 2;
            if (arr[mid] == x) return mid;
            else if (x > arr[mid]) s = mid + 1;
            else l = mid - 1;
        }
        return -1;
    }
}
