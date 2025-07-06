import java.util.*;
import java.io.*;

public class Main {

    static final int LOSE = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(bufferedReader.readLine(), " ");
        Set<Integer> invalidValues = new HashSet<>();
        invalidValues.add(1);
        invalidValues.add(3);
        invalidValues.add(4);
        int junSeong = Integer.parseInt(input.nextToken());
        int ikJoon = Integer.parseInt(input.nextToken());
        if (invalidValues.contains(junSeong)) {
            junSeong = LOSE;
        }
        if (invalidValues.contains(ikJoon)) {
            ikJoon = LOSE;
        }
        System.out.println(getResult(junSeong, ikJoon));
    }

    private static String getResult(int junSeong, int ikJoon) {
        if (junSeong == ikJoon) {
            return "=";
        }

        if (junSeong == LOSE) {
            return "<";
        }

        if (ikJoon == LOSE) {
            return ">";
        }
        Map<Integer, Integer> wins = new HashMap<>();
        wins.put(0, 2);
        wins.put(2, 5);
        wins.put(5, 0);
        
        if (wins.get(junSeong) == ikJoon) {
            return ">";
        }
        return "<";
    }
}