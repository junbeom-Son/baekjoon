import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; ++tc) {
			int n = Integer.parseInt(br.readLine());
			int[] x = new int[n + 1];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= n; ++i) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			int[] dp = new int[n + 1];
			for (int i = 1; i <= n; ++i) {
				dp[i] = Math.max(dp[i - 1], 0) + x[i];
			}
			int maxValue = Integer.MIN_VALUE;
			for (int i = 1; i <= n; ++i) {
				maxValue = Math.max(maxValue, dp[i]);
			}
			answer.append(maxValue).append("\n");
		}
		br.close();
		System.out.println(answer);
	}
}