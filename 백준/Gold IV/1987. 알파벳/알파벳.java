import java.util.*;
import java.io.*;

public class Main {

    static int R, C;
    static char[][] board;
    static Set<Character> included = new HashSet<>();
    static int answer = 0;
    static int[] dx = new int[] { -1, 1, 0, 0 };
    static int[] dy = new int[] { 0, 0, -1, 1 };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        for (int i = 0; i < R; ++i) {
            board[i] = br.readLine().toCharArray();
        }
        br.close();
        included.add(board[0][0]);
        dfs(1, 0, 0);
        System.out.println(answer);
    }

    private static void dfs(int depth, int x, int y) {
        answer = Math.max(answer, depth);
        if (answer == 26) {
            return;
        }
        for (int i = 0; i < 4; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < R && 0 <= ny && ny < C && !included.contains(board[nx][ny]))  {
                included.add(board[nx][ny]);
                dfs(depth + 1, nx, ny);
                included.remove(board[nx][ny]);
            }
        }
    }
}