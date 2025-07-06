import java.util.*;
import java.io.*;

public class Main {

    private static Map<Character, Character> wins = new HashMap<>();

    public static void main(String[] args) throws IOException {
        wins.put('S', 'P');
        wins.put('P', 'R');
        wins.put('R', 'S');
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int R = Integer.parseInt(bufferedReader.readLine());
        String sangGeun = bufferedReader.readLine();
        int N = Integer.parseInt(bufferedReader.readLine());
        String[] friends = new String[N];
        for (int i = 0; i < N; ++i) {
            friends[i] = bufferedReader.readLine();
        }
        StringBuilder output = new StringBuilder();
        output.append(getRealScore(R, N, sangGeun, friends))
                .append("\n")
                .append(getMaxScore(R, N, friends));

        System.out.println(output.toString());
    }

    private static int getRealScore(int R, int N, String sangGeun, String[] friends) {
        int score = 0;
        for (int i = 0; i < R; ++i) {
            score += calculateRound(i, N, sangGeun.charAt(i), friends);
        }
        return score;
    }

    private static int getMaxScore(int R, int N, String[] friends) {
        int score = 0;
        char[] shapes = { 'S', 'P', 'R' };
        for (int i = 0; i < R; ++i) {
            int roundScore = 0;
            for (char shape : shapes) {
                roundScore = Math.max(roundScore, calculateRound(i, N, shape, friends));
            }
            score += roundScore;
        }

        return score;
    }

    private static int calculateRound(int round, int N, char sangGeun, String[] friends) {
        int score = 0;
        for (int i = 0; i < N; ++i) {
            score += compete(sangGeun, friends[i].charAt(round));
        }
        return score;
    }

    private static int compete(char sangGeun, char friend) {
        if (sangGeun == friend) {
            return 1;
        }
        if (wins.get(sangGeun) == friend) {
            return 2;
        }
        return 0;
    }
}