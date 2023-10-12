package DP.BJ11055;

import java.util.Scanner;

class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int n = in.nextInt();
        int max = 0;
        int[] a = new int[n];
        int[] dp = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            dp[i] = a[i];
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + a[i]);
                }
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        System.out.println(max);
    }

}
