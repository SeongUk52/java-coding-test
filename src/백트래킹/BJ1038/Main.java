package 백트래킹.BJ1038;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Main {
    static Scanner scanner = new Scanner(System.in);
    int n;
    ArrayList<Long> result = new ArrayList<>();

    public static void main(String[] args) {
        Main main = new Main();
        main.n = scanner.nextInt();
        main.bt(new ArrayList<>());
        main.result.sort(Comparator.comparingLong(x -> x));
        try {
            System.out.println(main.result.get(main.n));
        } catch (Exception e) {
            System.out.println(-1);
        }

    }
    void bt(ArrayList<Integer> comb) {
        if (comb.size() >= 2) {
            if (comb.get(comb.size() - 2) <= comb.get(comb.size() - 1)) {
                return;
            }
        }

        if (!comb.isEmpty()) {
            StringBuilder temp = new StringBuilder();
            for (Integer c : comb) {
                temp.append(c);
            }
            this.result.add(Long.parseLong(temp.toString()));
        }
        for (int i = 0; i <= 9; i++) {
            comb.add(i);
            bt(comb);
            comb.remove(comb.size() - 1);
        }

    }
}
