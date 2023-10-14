package 데이크스트라.BJ6248;

import java.util.*;

class Main {
    final static int INF = (int) Math.pow(10, 9);
    static Scanner scanner = new Scanner(System.in);
    int n;
    int m;
    int x;

    Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();

    public static void main(String[] args) {
        Main main = new Main();
        main.n = scanner.nextInt();
        main.m = scanner.nextInt();
        main.x = scanner.nextInt();
        for (int i = 1; i < main.n + 1; i++) {
            main.graph.put(i, new HashMap<>());
        }
        for (int i = 0; i < main.m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int t = scanner.nextInt();
            if (main.graph.get(a).containsKey(b)) {
                if (t > main.graph.get(a).get(b)) {
                    continue;
                }
            }
            main.graph.get(a).put(b,t);
            main.graph.get(b).put(a,t);
        }
        int[] dists = main.dijkstra(main.x);
        dists[0] = 0;
        System.out.println(Arrays.stream(dists).max().getAsInt() * 2);
    }

    int[] dijkstra(Integer start) {
        int[] dists = new int[this.n + 1];
        for (int i = 0; i < this.n + 1; i++) {
            dists[i] = INF;
        }
        dists[start] = 0;
        PriorityQueue<int []> pq = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[0]));
        pq.offer(new int[]{0, start});

        while (!pq.isEmpty()) {
            int[] u = pq.poll();
            int cd = u[0];
            int cv = u[1];

            if (cd > dists[cv]) {
                continue;
            }
            Map<Integer, Integer> neighbors = graph.get(cv);
            for (Map.Entry<Integer, Integer> entry : neighbors.entrySet()) {
                int v = entry.getKey();
                int weight = entry.getValue();

                if (cd + weight < dists[v]) {
                    dists[v] = cd + weight;
                    pq.offer(new int[]{dists[v], v});
                }
            }
        }
        return dists;
    }
}
