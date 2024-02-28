import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] belongings = new int[N][2];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			belongings[i][0] = Integer.parseInt(st.nextToken());
			belongings[i][1] = Integer.parseInt(st.nextToken());
		}
		br.close();
		Arrays.sort(belongings, (x, y) -> {
			return Integer.compare(x[0], y[0]);
		});
		int[][] knapsack = new int[N + 1][K + 1];
		for (int i = 1; i <= N; ++i) {
			int weight = belongings[i - 1][0];
			int value = belongings[i - 1][1];
			for (int j = 1; j <= K; ++j) {
				knapsack[i][j] = knapsack[i - 1][j];
				if (j >= weight) {
					knapsack[i][j] = Math.max(knapsack[i][j], knapsack[i - 1][j - weight] + value);
				}
			}
		}
		System.out.println(knapsack[N][K]);
	}
}