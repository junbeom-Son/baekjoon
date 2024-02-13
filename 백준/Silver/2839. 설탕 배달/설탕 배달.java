import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();
		int[][] counts = new int[3][N + 1];
		for (int i = 0; i < 3; ++i) {
			Arrays.fill(counts[i], Integer.MAX_VALUE - 10);
		}
		counts[0][0] = 0;
		int[] sugar = new int[] { 0, 3, 5 };
		for (int i = 1; i < 3; ++i) {
			for (int j = 0; j <= N; ++j) {
				if (j < sugar[i]) {
					counts[i][j] = counts[i - 1][j];
				} else {
					counts[i][j] = Math.min(counts[i][j], Math.min(counts[i - 1][j], counts[i][j - sugar[i]] + 1));
				}
			}
		}
		System.out.println(counts[2][N] == Integer.MAX_VALUE - 10 ? -1 : counts[2][N]);
	}
}