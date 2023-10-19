package 데이크스트라.BJ1584;

import java.util.*;

public class Main {
    final byte DANGER_AREA = 1;
    final byte DEATH_AREA = 2;
    final int INF = 100000;
    final byte[] KEY_ROW = new byte[]{1,-1,0,0};
    final byte[] KEY_COL = new byte[]{0,0,1,-1};
    byte[][] graph = new byte[501][501];
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Main main = new Main();
        int[][] dists = main.dijkstra();
        if (dists[500][500] >= main.INF) {
            System.out.println(-1);
            return;
        }
        System.out.println(dists[500][500]);
    }
    Main() {
        distict(DANGER_AREA);
        distict(DEATH_AREA);
    }

    void distict(byte vari) {
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            int temp = 0;
            if (x1 > x2) {
                temp = x1;
                x1 = x2;
                x2 = temp;
            }
            if (y1 > y2) {
                temp = y1;
                y1 = y2;
                y2 = temp;
            }
            for (int j = x1; j <= x2; j++) {
                for (int k = y1; k <= y2; k++) {
                    graph[j][k] = vari;
                }
            }
        }
    }

    int[][] dijkstra() {
        int[][] dists = new int[501][501];
        for (int i = 0; i < 501; i++) {
            for (int j = 0; j < 501; j++) {
                dists[i][j] = INF;
            }
        }
        dists[0][0] = 0;
        PriorityQueue<int []> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0,0,0});
        while (!pq.isEmpty()) {
            int[] u = pq.poll();
            int cd = u[0];
            int cx = u[1];
            int cy = u[2];

            if (cd > dists[cx][cy]) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int newX = cx + KEY_ROW[i];
                int newY = cy + KEY_COL[i];
                if (newX >= 0 && newX < 501 && newY >= 0 && newY < 501) {
                    int weight = graph[newX][newY];
                    if (weight == 2) {
                        continue;
                    }

                    if (cd + weight < dists[newX][newY]) {
                        dists[newX][newY] = (cd + weight);
                        pq.offer(new int[]{dists[newX][newY], newX, newY});
                    }
                }
            }
        }
        return dists;

    }
}
