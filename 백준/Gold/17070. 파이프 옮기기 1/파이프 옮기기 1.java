import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] horizontal = new int[n][n];
		int[][] vertical = new int[n][n];
		int[][] diagonal = new int[n][n];
		int[][] map = new int[n][n];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		
		horizontal[0][1] = 1;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (map[i][j] == 1) continue;
				// 가로
				if (j > 0) {
					horizontal[i][j] += horizontal[i][j - 1] + diagonal[i][j - 1];
				}
				// 세로
				if (i > 0) {
					vertical[i][j] += vertical[i - 1][j] + diagonal[i - 1][j];
				}
				// 대각선
				if (i > 0 && j > 0) {
					if (map[i - 1][j] == 1 || map[i][j - 1] == 1) {
						continue;
					}
					diagonal[i][j] += diagonal[i - 1][j - 1] + horizontal[i - 1][j - 1] + vertical[i - 1][j - 1];
				}
			}
		}
		System.out.println(vertical[n - 1][n - 1] + horizontal[n - 1][n - 1] + diagonal[n - 1][n - 1]);
	}
}
