import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] orchard = new int[n + 1][n + 1];
		int[][] prefixSum = new int[n + 1][n + 1];
		for (int i = 1; i <= n; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= n; ++j) {
				orchard[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= n; ++j) {
				prefixSum[i][j] = orchard[i][j] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
			}
		}
		int answer = -100000;
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= n; ++j) {
				int size = 0;
				while (i - size > 0 && j - size > 0) {
					answer = Math.max(answer, prefixSum[i][j] - prefixSum[i - size - 1][j] - prefixSum[i][j - size - 1] + prefixSum[i - size - 1][j - size - 1]);
					++size;
				}
			}
		}
		System.out.println(answer);
	}
}