import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] maze = new char[N][M];
		int[][] counts = new int[N][M];
		for (int i = 0; i < N; ++i) {
			maze[i] = br.readLine().toCharArray();
		}
		br.close();
		for (int i = 0; i < N; ++i) {
			Arrays.fill(counts[i], Integer.MAX_VALUE);
		}
		counts[0][0] = 1;
		int[] dx = new int[] { -1, 1, 0, 0 };
		int[] dy = new int[] { 0, 0, -1, 1 };
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { 0, 0 });
		while (!queue.isEmpty()) {
			int[] position = queue.remove();
			int x = position[0];
			int y = position[1];
			for (int i = 0; i < 4; ++i) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < M && maze[nx][ny] == '1' && counts[nx][ny] > counts[x][y] + 1) {
					counts[nx][ny] = counts[x][y] + 1;
					queue.add(new int[] { nx, ny });
				}
			}
		}
		System.out.println(counts[N - 1][M - 1]);
	}
}
