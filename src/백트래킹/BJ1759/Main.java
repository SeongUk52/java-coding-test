package 백트래킹.BJ1759;

import java.util.*;
import java.util.stream.Collectors;

class Main {
    final static ArrayList<Character> VOWELS = new ArrayList<>(Arrays.asList('a','e','i','o','u'));
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int l = scanner.nextInt();  //암호의 길이
        int c = scanner.nextInt();  //주어진 알파벳 개수
        ArrayList<Character> arr = new ArrayList<>();
        for (int i = 0; i < c; i++){
            arr.add(scanner.next().charAt(0));
        }
        Collections.sort(arr);
        ArrayList<ArrayList<Character>> result = new ArrayList<>();
        ArrayList<Character> comb = new ArrayList<>();
        bt(comb,result,l,c,arr,0);
        result.stream().map(combi -> combi.stream().map(String::valueOf).collect(Collectors.joining()))
                .forEach(System.out::println);

    }

    static void bt(ArrayList<Character> comb, ArrayList<ArrayList<Character>> result, int l, int c, ArrayList<Character> arr, int start) {
        if (comb.size() == l) {
            if (comb.stream().anyMatch(VOWELS::contains)) {
                if (comb.stream().filter(word -> !VOWELS.contains(word)).count() >= 2){
                result.add(new ArrayList<>(comb));
                return;
                }
            }
        }
        for (int i = start; i < c; i++) {
            if (!comb.contains(arr.get(i))) {
                comb.add(arr.get(i));
                bt(comb,result,l,c,arr, i + 1);
                comb.remove(comb.size() - 1);
            }
        }
    }
}
