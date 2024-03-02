import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] caves;
	static int[] dx = new int[] { -1, 1, 0, 0 };
	static int[] dy = new int[] { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder answer = new StringBuilder();
		int round = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0) {
				break;
			}
			answer.append("Problem ").append(round++).append(": ");
			caves = new int[N][N];
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; ++j) {
					caves[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			answer.append(getMinCost()).append("\n");
		}
		System.out.print(answer);
	}
	
	private static int getMinCost() {
		PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
			return Integer.compare(a[2], b[2]);
		});
		queue.add(new int[] { 0, 0, caves[0][0] });
		caves[0][0] = -1;
		int minCost = 0;
		while (!queue.isEmpty()) {
			int[] position = queue.remove();
			int x = position[0];
			int y = position[1];
			int cost = position[2];
			for (int i = 0; i < 4; ++i) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < N && caves[nx][ny] != -1) {
					if (nx == N - 1 && ny == N - 1) {
						return minCost = cost + caves[nx][ny];
					}
					queue.add(new int[] { nx, ny, cost + caves[nx][ny] });
					caves[nx][ny] = -1;
				}
			}
		}
		return minCost;
	}
}