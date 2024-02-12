import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            List<Character> list = new LinkedList<>();
            int index = -1;
            for (char c : br.readLine().toCharArray()) {
                if (c == '<') {
                    if (list.size() > 0 && index >= 0) {
                        --index;
                    }
                } else if (c == '>') {
                    if (list.size() > 0 && index < list.size() - 1) {
                        ++index;
                    }
                } else if (c == '-') {
                    if (list.size() > 0 && index >= 0) {
                        list.remove(index--);
                    }
                } else {
                    list.add(++index, c);
                }
            }
            for (char c : list) {
                answer.append(c);
            }
            answer.append("\n");
        }
        System.out.print(answer);
        br.close();
    }
}