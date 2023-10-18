package 백트래킹.BJ1469;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    byte n;
    Byte[] arrX;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        main.n = scanner.nextByte();
        main.arrX = new Byte[main.n];
        for (byte i = 0; i < main.n; i++) {
            byte j = scanner.nextByte();
            main.arrX[i] = j;
        }
        main.bt();
    }
    void bt() {
        ArrayList<ArrayList<Byte>> q = new ArrayList<>();
        ArrayList<Byte> comb;
        for (Byte x : arrX) {
            q.add(new ArrayList<>(new ArrayList<>(x)));
        }
        while (!q.isEmpty()) {
            comb = q.remove(0);
            if (comb.size() == this.n * 2) {
                System.out.println(comb.stream().map(Object::toString).reduce((s1, s2) -> s1 + " " + s2).orElse(""));
                return;
            }
            for (Byte x : arrX) {
                if (!comb.contains(x) || (comb.stream().filter(a -> a.equals(x)).count() == 1) && (comb.size() - comb.lastIndexOf(x) - 1 == x)) {
                    comb.add(x);
                    if (!q.containsAll(comb)) {
                        q.add(new ArrayList<>(comb));
                    }
                    comb.remove(comb.size() - 1);
                }
            }
        }
        System.out.println(-1);
    }
}
