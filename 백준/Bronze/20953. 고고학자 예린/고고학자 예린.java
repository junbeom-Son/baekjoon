import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(bufferedReader.readLine());
        int t = Integer.parseInt(input.nextToken());
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < t; ++i) {
            input = new StringTokenizer(bufferedReader.readLine(), " ");
            int a = Integer.parseInt(input.nextToken());
            int b = Integer.parseInt(input.nextToken());
            int sum = 0;
            for (int j = 1; j < a + b; ++j) {
                sum += j;
            }
            int result = (a + b) * sum;
            output.append(result).append("\n");
        }
        System.out.println(output.toString());
    }
}