import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		int[][] maxValues = new int[N][N];
		int[][] minValues = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			Arrays.fill(maxValues[i], Integer.MIN_VALUE);
			Arrays.fill(minValues[i], Integer.MAX_VALUE);
			for (int j = 0; j < N; ++j) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}
		
		
		maxValues[0][0] = map[0][0] - '0';
		minValues[0][0] = map[0][0] - '0';
		for (int i = 0; i < N; ++i) {
			for (int j = i % 2; j < N; j += 2) {
				if (i > 0 && j > 0) {
					maxValues[i][j] = Math.max(maxValues[i][j], getValue(maxValues[i - 1][j - 1], map[i][j] - '0', map[i - 1][j]));
					maxValues[i][j] = Math.max(maxValues[i][j], getValue(maxValues[i - 1][j - 1], map[i][j] - '0', map[i][j - 1]));
					minValues[i][j] = Math.min(minValues[i][j], getValue(minValues[i - 1][j - 1], map[i][j] - '0', map[i - 1][j]));
					minValues[i][j] = Math.min(minValues[i][j], getValue(minValues[i - 1][j - 1], map[i][j] - '0', map[i][j - 1]));
				}
				if (i > 1) {
					maxValues[i][j] = Math.max(maxValues[i][j], getValue(maxValues[i - 2][j], map[i][j] - '0', map[i - 1][j]));
					minValues[i][j] = Math.min(minValues[i][j], getValue(minValues[i - 2][j], map[i][j] - '0', map[i - 1][j]));
				}
				if (j > 1) {
					maxValues[i][j] = Math.max(maxValues[i][j], getValue(maxValues[i][j - 2], map[i][j] - '0', map[i][j - 1]));
					minValues[i][j] = Math.min(minValues[i][j], getValue(minValues[i][j - 2], map[i][j] - '0', map[i][j - 1]));
				}
			}
		}
		System.out.println(maxValues[N - 1][N - 1] + " " + minValues[N - 1][N - 1]);
	}
	
	private static int getValue(int value1, int value2, char operator) {
		if (operator == '+') {
			return value1 + value2;
		}
		if (operator == '-') {
			return value1 - value2;
		}
		if (operator == '*') {
			return value1 * value2;
		}
		return value1 / value2;
	}
}