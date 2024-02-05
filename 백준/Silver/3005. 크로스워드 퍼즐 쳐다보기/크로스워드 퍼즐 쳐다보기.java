import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int r;
    static int c;
    static char [][] crossWord;
    static int [] xDirections = { 0, 1 };
    static int [] yDirections = { 1, 0 };
    public static void main(String[] args) throws IOException {
        initialize();
        List<String> words = new ArrayList<>();
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                for (int k = 0; k < 2; ++k) {
                    if (isStarting(i, j, xDirections[k], yDirections[k])) {
                        words.add(extractString(i, j, xDirections[k], yDirections[k]));
                    }
                }
            }
        }
        Collections.sort(words);
        System.out.println(words.get(0));
    }

    static String extractString(int row, int col, int dx, int dy) {
        StringBuilder string = new StringBuilder();
        while (row < r && col < c) {
            if (crossWord[row][col] == '#') {
                break;
            }
            string.append(crossWord[row][col]);
            row += dx;
            col += dy;
        }
        return string.toString();
    }

    static boolean isStarting(int row, int col, int dx, int dy) {
        if (crossWord[row][col] == '#') {
            return false;
        }
        if (row - dx >= 0 && col - dy >= 0) {
            if (crossWord[row - dx][col - dy] != '#') {
                return false;
            }
        }
        if (row + dx == r || col + dy == c) {
            return false;
        }
        if (crossWord[row + dx][col + dy] == '#') {
            return false;
        }
        return true;
    }

    static void initialize() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        crossWord = new char[r][c];
        for (int i = 0; i < r; ++i) {
            crossWord[i] = bufferedReader.readLine().toCharArray();
        }
        bufferedReader.close();
    }
}