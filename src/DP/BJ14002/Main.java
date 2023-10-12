package DP.BJ14002;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scanner.nextInt();
        int a[] = new int[n];
        ArrayList<Integer>[] dp = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new ArrayList<Integer>();
            a[i] = scanner.nextInt();
        }
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            dp[i].add(a[i]);
            for (int j = 0; j < i; j++){
                if (a[j] < a[i]) {
                    if (dp[i].size() <= dp[j].size()) {
                        dp[i] = new ArrayList<>();
                        dp[i].addAll(dp[j]);
                        dp[i].add(a[i]);
                    }
                }
            }
            if (dp[i].size() > dp[maxIndex].size()){
                maxIndex = i;
            }
        }
        System.out.println(dp[maxIndex].size());
        String result = dp[maxIndex].stream()
                .map(Object::toString)
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }
}
