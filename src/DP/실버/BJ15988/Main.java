package DP.실버.BJ15988;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int tc = scanner.nextInt();
        for (int i = 0; i < tc; i++) {
            int n = scanner.nextInt();
            if (n == 1) {
                System.out.println(1);
                continue;
            }
            if (n == 2) {
                System.out.println(2);
                continue;
            }
            if (n == 3) {
                System.out.println(4);
                continue;
            }
            long[] dp = new long[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for (int j = 4; j < n + 1; j++) {
                dp[j] = (dp[j - 1] + dp[j - 2] + dp[j - 3]) % 1000000009;
            }
            System.out.println(dp[n]);

        }
    }
}
