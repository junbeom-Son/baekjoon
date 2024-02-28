import java.io.*;
import java.util.*;

public class Main {
	static int w, h;
	static int[] dx = new int[] { -1, 1, 0, 0 };
	static int[] dy = new int[] { 0, 0, -1, 1 };
	static int[] horseX = new int[] { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] horseY = new int[] { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		board = new int[h][w];
		boolean[][][] visited = new boolean[k + 1][h][w];
		for (int i = 0; i < h; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < w; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		int INF = 100000;
		int answer = INF;
		visited[0][0][0] = true;
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { 0, 0, 0, 0 }); // x, y, 거리, 점프 횟수
		while (!queue.isEmpty()) {
			int[] status = queue.remove();
			int x = status[0];
			int y = status[1];
			int distance = status[2];
			if (x == h - 1 && y == w - 1) {
				answer = distance;
				break;
			}
			int jumpCount = status[3];
			for (int i = 0; i < 4; ++i) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (inRange(nx, ny) && !visited[jumpCount][nx][ny] && board[nx][ny] == 0) {
					visited[jumpCount][nx][ny] = true;
					queue.add(new int[] { nx, ny, distance + 1, jumpCount });
				}
			}
			
			if (jumpCount == k) {
				continue;
			}
			
			for (int i = 0; i < 8; ++i) {
				int nx = x + horseX[i];
				int ny = y + horseY[i];
				if (inRange(nx, ny) && !visited[jumpCount + 1][nx][ny] && board[nx][ny] == 0) {
					visited[jumpCount + 1][nx][ny] = true;
					queue.add(new int[] { nx, ny, distance + 1, jumpCount + 1 });
				}
			}
		}
		if (answer == INF) {
			answer = -1;
		}
		System.out.println(answer);
	}
	
	private static boolean inRange(int x, int y) {
		if (0 <= x && x < h && 0 <= y && y < w) {
			return true;
		}
		return false;
	}
}