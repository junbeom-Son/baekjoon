import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < t; ++i) {
            String input = bufferedReader.readLine();
            output.append(input);
            if (input.charAt(input.length() - 1) != '.') {
                output.append(".");
            }
            output.append("\n");
        }
        System.out.println(output.toString());
    }
}