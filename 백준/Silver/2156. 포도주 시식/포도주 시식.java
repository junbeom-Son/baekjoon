import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] wines = new int[n + 5];
		for (int i = 1; i <= n; ++i) {
			wines[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		int[] dp = new int[n + 5];
		dp[1] = wines[1];
		dp[2] = wines[1] + wines[2];
		for (int i = 3; i <= n; ++i) {
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 3] + wines[i - 1], dp[i - 2]) + wines[i]);
		}
		System.out.println(dp[n]);
	}
}
