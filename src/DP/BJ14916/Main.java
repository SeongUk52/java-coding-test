package DP.BJ14916;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    static final int MAX = 100000000;
    int[] arr;
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        main.arr = IntStream.range(0, n + 1)
                .map(i -> MAX)
                .toArray();
        if (n < 2) {
            main.print(n);
            return;
        }
        main.arr[2] = 1;
        if (n < 4) {
            main.print(n);
            return;
        }
        main.arr[4] = 2;
        if (n < 5) {
            main.print(n);
            return;
        }
        main.arr[5] = 1;
        if (n < 6) {
            main.print(n);
            return;
        }
        for (int i = 6; i <= n; i++) {
            main.arr[i] = Math.min(main.arr[i - 2] + 1, main.arr[i - 5] + 1);
        }
        main.print(n);
    }
    void print(int x) {
        int[] printArr = Arrays.stream(arr).map(i -> (i == MAX) ? -1 : i).toArray();
        System.out.println(printArr[x]);
    }
}
