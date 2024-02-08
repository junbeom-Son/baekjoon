import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		int INF = 1000000000;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] arr = new int[n + 1][n + 1];
		for (int i = 0; i <= n; ++i) {
			Arrays.fill(arr[i], INF);
			arr[i][i] = 0;
		}
		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[a][b] = Math.min(arr[a][b], c);
		}
		br.close();
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= n; ++j) {
				if (i == j || arr[j][i] == INF) {
					continue;
				}
				for (int k = 1; k <= n; ++k) {
					arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
				}
			}
		}
		StringBuilder answer = new StringBuilder();
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= n; ++j) {
				if (arr[i][j] == INF) {
					arr[i][j] = 0;
				}
				answer.append(arr[i][j]).append(" ");
			}
			answer.append("\n");
		}
		System.out.print(answer);
	}
}