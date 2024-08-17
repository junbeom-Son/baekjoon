import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();
		int[] dp = new int[N + 1];
		for (int i = 2; i <= N; ++i) {
			int left = 1;
			int right = i - 1;
			while (left <= right) {
				int value = left * right + dp[left] + dp[right];
				dp[i] = Math.max(dp[i], value);
				++left;
				--right;
			}
		}
		System.out.println(dp[N]);
	}
}