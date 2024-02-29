import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] costs;
	static boolean[] visited;
	static int minDistance = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		costs = new int[N][N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; ++j) {
				costs[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		
		visited = new boolean[N];
		dfs(0, 0, 0);
		System.out.println(minDistance);
	}
	
	private static void dfs(int depth, int curCity, int distance) {
		if (depth == N - 1) {
			if (costs[curCity][0] == 0) {
				return;
			}
			minDistance = Math.min(minDistance, distance + costs[curCity][0]);
			return;
		}
		
		for (int i = 1; i < N; ++i) {
			if (visited[i] || costs[curCity][i] == 0 || costs[curCity][i] + distance >= minDistance) {
				continue;
			}
			visited[i] = true;
			dfs(depth + 1, i, costs[curCity][i] + distance);
			visited[i] = false;
		}
	}
}