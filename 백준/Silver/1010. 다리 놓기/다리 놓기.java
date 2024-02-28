import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for (int test = 0; test < t; ++test) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] dp = new int[n + 1][m + 1];
			for (int i = 1; i <= m; ++i) {
				dp[1][i] = i;
			}
			for (int i = 1; i <= n; ++i) {
				dp[i][i] = 1;
			}
			for (int i = 2; i <= n; ++i) {
				for (int j = i + 1; j <= m; ++j) {
					dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
				}
			}
			answer.append(dp[n][m]).append("\n");
		}
		br.close();
		System.out.print(answer);
	}
}