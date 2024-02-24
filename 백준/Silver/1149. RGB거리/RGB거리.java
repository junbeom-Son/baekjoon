import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] costs = new int[N][3];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; ++j) {
				costs[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		int[][] dp = new int[N][3];
		for (int i = 0; i < 3; ++i) {
			dp[0][i] = costs[0][i];
		}
		
		for (int i = 1; i < N; ++i) {
			for (int j = 0; j < 3; ++j) {
				dp[i][j] = costs[i][j] + Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]);
			}
		}
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < 3; ++i) {
			answer = Math.min(answer, dp[N - 1][i]);
		}
		System.out.println(answer);
	}
}