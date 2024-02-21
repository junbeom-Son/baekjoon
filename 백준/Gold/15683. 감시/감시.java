import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] office;
	static int[][] area;
	static List<int[]> CCTVs = new ArrayList<>();
	static int answer = Integer.MAX_VALUE;
	static int[][][] dx = {
		{{}},
		{{ -1 }, { 1 }, { 0 }, { 0 }},
		{{ -1, 1 }, { 0, 0 }},
		{{ -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 }},
		{{ -1, 0, 1 }, { 0, 1, 0 }, { 1, 0, -1}, {0, -1, 0 }},
		{{ -1, 1, 0, 0 }}
	};
	static int [][][] dy = {
		{{}},
		{{ 0 }, { 0 }, { -1 }, { 1 }},
		{{ 0, 0 }, { -1, 1 }},
		{{ 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }},
		{{ 0, 1, 0 }, { 1, 0, -1 }, { 0, -1, 0 }, { -1, 0, 1 }},
		{{ 0, 0, -1, 1 }}
	};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		office = new int[N][M];
		area = new int[N][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; ++j) {
				office[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (office[i][j] != 0) {
					area[i][j] = 10;
				}
				if (1 <= office[i][j] && office[i][j] <= 4) {
					CCTVs.add(new int[] { i, j });
				} else if (office[i][j] == 5) {
					watch(office[i][j], 0, i, j, 1);
				}
			}
		}
		dfs(0);
		System.out.println(answer);
	}
	
	private static void dfs(int depth) {
		if (depth == CCTVs.size()) {
			int count = 0;
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < M; ++j) {
					if (area[i][j] == 0) {
						++count;
					}
				}
			}
			answer = Math.min(answer, count);
			return;
		}
		int x = CCTVs.get(depth)[0];
		int y = CCTVs.get(depth)[1];
		int number = office[x][y];
		for (int i = 0; i < dx[number].length; ++i) {
			watch(number, i, x, y, 1);
			dfs(depth + 1);
			watch(number, i, x, y, -1);
		}
	}
	
	private static void watch(int number, int direction, int x, int y, int value) {
		for (int i = 0; i < dx[number][direction].length; ++i) {
			int nx = x;
			int ny = y;
			while (true) {
				nx += dx[number][direction][i];
				ny += dy[number][direction][i];
				if (nx < 0 || N <= nx || ny < 0 || M <= ny || office[nx][ny] == 6) {
					break;
				}
				area[nx][ny] += value;
			}
		}
	}
}