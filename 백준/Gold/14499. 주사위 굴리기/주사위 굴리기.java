import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] rollDirections = new int[][] {
		{  },
		{ 1, 4, 3, 5 },
		{ 1, 5, 3, 4 },
		{ 0, 1, 2, 3 },
		{ 0, 3, 2, 1 }
		
	};
	static int[] dx = new int[] { 0, 0, 0, -1, 1 };
	static int[] dy = new int[] { 0, 1, -1, 0, 0 };
	static int[][] map;
	static int[] dice = new int[6];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		br.close();
		StringBuilder answer = new StringBuilder();
		for (int i = 0; i < K; ++i) {
			int command = Integer.parseInt(st.nextToken());
			int nextX = x + dx[command];
			int nextY = y + dy[command];
			if (nextX < 0 || N <= nextX || nextY < 0 || M <= nextY) {
				continue;
			}
			x = nextX;
			y = nextY;
			roll(command);
			if (map[x][y] == 0) {
				map[x][y] = dice[3];
			} else {
				dice[3] = map[x][y];
				map[x][y] = 0;
			}
			answer.append(dice[1]).append("\n");
		}
		System.out.print(answer);
	}
	
	private static void roll(int command) {
		int tmp = dice[rollDirections[command][0]];
		for (int i = 0; i < 3; ++i) {
			dice[rollDirections[command][i]] = dice[rollDirections[command][i + 1]];
		}
		dice[rollDirections[command][3]] = tmp;
	}
}