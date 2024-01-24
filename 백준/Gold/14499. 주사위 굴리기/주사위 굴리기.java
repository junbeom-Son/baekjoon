import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder answer = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] commands = Arrays.stream(br.readLine().split(" "))
				.mapToInt(s -> Integer.parseInt(s))
				.toArray();
		br.close();
		
		int[][] rotations = new int[][] {
			{},
			{ 0, 1, 2, 3 },
			{ 3, 2, 1, 0 },
			{ 1, 5, 3, 4 },
			{ 1, 4, 3, 5 }
		};
		int[] dx = { 0, 0, 0, -1, 1 };
		int[] dy = { 0, 1, -1, 0, 0 };
		int[] dice = new int[6];
		for (int command : commands) {
			int nextX = x + dx[command];
			int nextY = y + dy[command];
			if (nextX < 0 || n <= nextX || nextY < 0 || m <= nextY) {
				continue;
			}
			int tmp = dice[rotations[command][0]];
			for (int i = 0; i < 3; ++i) {
				dice[rotations[command][i]] = dice[rotations[command][i + 1]];
			}
			dice[rotations[command][3]] = tmp;
			x = nextX;
			y = nextY;
			if (map[x][y] == 0) {
				map[x][y] = dice[3];
			} else {
				dice[3] = map[x][y];
				map[x][y] = 0;
			}
			answer.append(dice[1]).append('\n');
		}
		System.out.println(answer);
	}
}