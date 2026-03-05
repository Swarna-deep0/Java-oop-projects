package com;

import java.util.Arrays;

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

        // rotated array : Rotate the array from right by k steps
        int[]num = {1,2,3,4,5,6,7};
        int k = 2;
        rotate(num,k);
        System.out.println(Arrays.toString(num));

        // Search an element in a Sorted & Rotated Array in java
        int[]srr = {8,7,6,1,2,3,4,5};
        int target = 8;
        int s = search(srr, target);

        if ( s != -1 ) System.out.println("Element found at index : " + s);
        else System.out.println("element not found ");
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

    public static void rotate(int[]num , int k){
        int n = num.length;
        if (k > n) k = k % n ;
        reverse(num,0,n-1);
        reverse(num,0,k -1);
        reverse(num,k,n-1);
    }

    public static void reverse(int[]num , int start , int end){
        while (start < end){
            int temp = num[start];
            num[start] = num[end];
            num[end] = temp;

            start++;
            end--;
        }
    }

    public static int search (int[]srr , int target){
        int start = 0;
        int end = srr.length - 1;

        while (start<=end){
            int mid = (start + end)/2 ;

            if (srr[mid] == target) return mid;

            if (srr[start] < srr[mid]) {
                if (target >=srr[start] && target <= srr[mid]) {
                    end = mid -1;
                }
                else start = mid + 1;
            }
            else {
                if (target >= srr[mid] && target <= srr[end]) {
                    start = mid + 1;
                }
                else end = mid - 1;
            }
        }
        return -1;
    }
}
