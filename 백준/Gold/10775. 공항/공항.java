import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        int[] flights = new int[P];
        for (int i = 0; i < P; ++i) {
            flights[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        TreeSet<Integer> gates = new TreeSet<>();
        for (int i = 1; i <= G; ++i) {
            gates.add(i);
        }

        int answer = 0;
        for (int flight : flights) {
            if (gates.isEmpty()) {
                break;
            }
            Integer gate = gates.floor(flight);
            if (gate == null) {
                break;
            }
            ++answer;
            gates.remove(gate);
        }

        System.out.println(answer);
    }
}