package DP.실버.BJ9625;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dpa = new int[n + 1];
        int[] dpb = new int[n + 1];
        dpa[0] = 1;
        for (int i = 1; i <= n; i++) {
            dpa[i] = dpb[i - 1];
            dpb[i] = dpa[i - 1] + dpb[i - 1];
        }
        System.out.println(dpa[n] + " " + dpb[n]);
    }
}
