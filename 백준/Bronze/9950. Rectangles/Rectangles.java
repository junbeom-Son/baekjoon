import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input;
        StringBuilder output = new StringBuilder();
        final String space = " ";
        while (true) {
            input = new StringTokenizer(bufferedReader.readLine(), " ");
            int length = Integer.parseInt(input.nextToken());
            int width = Integer.parseInt(input.nextToken());
            int area = Integer.parseInt(input.nextToken());
            if (length == 0 && width == 0 && area == 0) {
                break;
            }

            if (length == 0) {
                length = area / width;
            } else if (width == 0) {
                width = area / length;
            } else {
                area = length * width;
            }
            
            output.append(length).append(space).append(width).append(space).append(area).append("\n");
        }

        System.out.println(output.toString());
    }
}