import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[][] firstExplosion = new long[N][N];
		long[][] counts = new long[N][N];
		long[][] dp = new long[N][N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; ++j) {
				firstExplosion[i][j] = Long.parseLong(st.nextToken());
			}
		}
		StringBuilder answer = new StringBuilder();
		if (M == 1) {
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					answer.append(-firstExplosion[i][j]).append(" ");
				}
				answer.append("\n");
			}
			System.out.println(answer);
			return;
		}
		int start = M / 2;
		for (int i = start; i < N - start; ++i) {
			for (int j = start; j < N - start; ++j) {
				int minI = Math.max(i - M, 0);
				int minJ = Math.max(j - M, 0);
				dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1];
				long bombInArea = dp[i][j] - dp[i][minJ] - dp[minI][j] + dp[minI][minJ];
				long count = -(firstExplosion[i - start][j - start] + bombInArea);
				counts[i][j] = count;
				dp[i][j] += count;
			}
		}
		br.close();
		
		
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				answer.append(counts[i][j]).append(" ");
			}
			answer.append("\n");
		}
		System.out.println(answer);
	}
}