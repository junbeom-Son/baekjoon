import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        StringBuilder output = new StringBuilder();
        for (int i = 1; i <= t; ++i) {
            output.append("Case #").append(i).append(": ");
            int score = Integer.parseInt(bufferedReader.readLine());
            String finalRound = getFinalRound(score);
            output.append(finalRound).append("\n");
        }
        System.out.println(output.toString());
    }

    private static String getFinalRound(int score) {
        if (score > 4500) {
            return "Round 1";
        }

        if (score > 1000) {
            return "Round 2";
        }

        if (score > 25) {
            return "Round 3";
        }

        return "World Finals";
    }
}