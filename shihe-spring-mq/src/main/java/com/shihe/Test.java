package com.shihe;

public class Test {

    public static void main(String[] args) {
        int max = min(7, 4);
        System.out.println(max);

    }

    public static int max(int a, int b){
        if(a<b) {
            int temp = a;
            a = b;
            b = temp;
        }
        if (a % b == 0) {
            return b;
        }
        return max(b, a%b);
    }

    public static int min(int a, int b){
        return a*b/max(a,b);
    }
}
