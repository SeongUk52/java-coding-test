package DP.BJ2294;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Main {
    final static int MAX = 100001;
    int n;
    int k;
    ArrayList<Integer> arr = new ArrayList<>();
    int[] dp;

    public static void main(String[] args) {
        Main main = new Main();
        main.inputValue();
        for (int i = 1; i <= main.k; i++) {
            for (int a : main.arr) {
                if (a <= i && main.dp[i - a] != MAX) {
                    main.dp[i] = Math.min(main.dp[i], main.dp[i - a] + 1);
                }
            }
        }
        if (main.dp[main.k] == MAX) {
            System.out.println(-1);
            return;
        }
        System.out.println(main.dp[main.k]);



    }
    void inputValue() {
        Scanner scanner = new Scanner(System.in);
        this.n = scanner.nextInt();
        this.k = scanner.nextInt();
        this.dp = new int[this.k + 1];
        Arrays.fill(this.dp, MAX);
        dp[0] = 0;
        for (int i = 0; i < this.n; i++) {
            this.arr.add(scanner.nextInt());
        }
        this.arr.sort(Comparator.comparingInt(x -> -x));
    }
}
