import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static char[][] board;
	static boolean[][][][] visited;
	static int[] dx = new int[] { -1, 1, 0, 0 };
	static int[] dy = new int[] { 0, 0, -1, 1 };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		for (int i = 0; i < N; ++i) {
			board[i] = br.readLine().toCharArray();
		}
		int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (board[i][j] == 'R') {
					x1 = i;
					y1 = j;
				} else if (board[i][j] == 'B') {
					x2 = i;
					y2 = j;
				}
			}
		}
		visited = new boolean[N][M][N][M];
		visited[x1][y1][x2][y2] = true;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x1, y1, x2, y2, 0 });
		int answer = -1;
		while (!queue.isEmpty()) {
			int[] position = queue.remove();
			x1 = position[0];
			y1 = position[1];
			x2 = position[2];
			y2 = position[3];
			int count = position[4];
			if (board[x2][y2] == 'O') {
				continue;
			}
			if (board[x1][y1] == 'O') {
				answer = count;
				break;
			}
			for (int i = 0; i < 4; ++i) {
				int[] newPosition = move(x1, y1, x2, y2, dx[i], dy[i]);
				int nx1 = newPosition[0];
				int ny1 = newPosition[1];
				int nx2 = newPosition[2];
				int ny2 = newPosition[3];
				if (!visited[nx1][ny1][nx2][ny2] && count < 10) {
					queue.add(new int[] { nx1, ny1, nx2, ny2, count + 1 });
					visited[nx1][ny1][nx2][ny2] = true;
				}
			}
		}
		System.out.println(answer);
	}
	
	private static int[] move(int x1, int y1, int x2, int y2, int x, int y) { // 항상 빨간색 먼저 움직임
		boolean ball1Move = true;
		boolean ball2Move = true;
		while (ball1Move || ball2Move) {
			if (board[x1][y1] == 'O') {
				ball1Move = false;
			}
			if (board[x2][y2] == 'O') {
				ball2Move = false;
			}
			if (!inRange(x1 + x, y1 + y) || board[x1 + x][y1 + y] == '#' || (x1 + x == x2 && y1 + y == y2 && board[x2 + x][y2 + y] == '#' && board[x2][y2] != 'O')) {
				ball1Move = false;
			}
			if (!inRange(x2 + x, y2 + y) || board[x2 + x][y2 + y] == '#' || (x2 + x == x1 && y2 + y == y1 && board[x1 + x][y1 + y] == '#' && board[x1][y1] != 'O')) {
				ball2Move = false;
			}
			if (ball1Move) {
				x1 += x;
				y1 += y;
			}
			if (ball2Move) {
				x2 += x;
				y2 += y;
			}
		}
		return new int[] { x1, y1, x2, y2 };
	}
	
	private static boolean inRange(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < M) {
			return true;
		}
		return false;
	}
}