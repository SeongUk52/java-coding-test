import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        long result = 0;
        for (int a : arr) {
            result++;
            long temp = a - b;
            if (temp <= 0) {
                continue;
            }
            temp = (long) Math.ceil(((double) temp / c));
            result += temp;
        }
        System.out.print(result);
    }
}
