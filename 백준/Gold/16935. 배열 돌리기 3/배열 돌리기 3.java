import java.io.*;
import java.util.*;

public class Main {
	static int N, M, R;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < R; ++i) {
			int command = Integer.parseInt(st.nextToken());
			switch (command) {
			case 1:
				f1();
				break;
			case 2:
				f2();
				break;
			case 3:
				f3();
				break;
			case 4:
				f4();
				break;
			case 5:
				f5();
				break;
			case 6:
				f6();
				break;
			}
		}
		br.close();
		StringBuilder answer = new StringBuilder();
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				answer.append(arr[i][j]).append(" ");
			}
			answer.append("\n");
		}
		System.out.println(answer);
	}
	
	private static void f1() {
		int[][] tmp = new int[N][M];
		for (int i = 0; i < N; ++i) {
			tmp[i] = arr[N - i - 1];
		}
		arr = tmp;
	}
	
	private static void f2() {
		int[][] tmp = new int[N][M];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				tmp[i][j] = arr[i][M - j - 1];
			}
		}
		arr = tmp;
	}
	
	private static void f3() {
		int number = N;
		N = M;
		M = number;
		int[][] tmp = new int[N][M];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				tmp[i][j] = arr[M - j - 1][i];
			}
		}
		arr = tmp;
	}
	
	private static void f4() {
		int number = N;
		N = M;
		M = number;
		int[][] tmp = new int[N][M];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				tmp[i][j] = arr[j][N - i - 1];
			}
		}
		arr = tmp;
	}
	
	private static void f5() {
		int[][] tmp = new int[N][M];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				int group = findGroup(i, j);
				switch (group) {
				case 1:
					tmp[i][j + M / 2] = arr[i][j];
					break;
				case 2:
					tmp[i + N / 2][j] = arr[i][j];
					break;
				case 3:
					tmp[i][j - M / 2] = arr[i][j];
					break;
				case 4:
					tmp[i - N / 2][j] = arr[i][j];
					break;
				}
			}
		}
		arr = tmp;
	}
	
	private static void f6() {
		int[][] tmp = new int[N][M];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				int group = findGroup(i, j);
				switch (group) {
				case 1:
					tmp[i + N / 2][j] = arr[i][j];
					break;
				case 2:
					tmp[i][j - M / 2] = arr[i][j];
					break;
				case 3:
					tmp[i - N / 2][j] = arr[i][j];
					break;
				case 4:
					tmp[i][j + M / 2] = arr[i][j];
					break;
				}
			}
		}
		arr = tmp;
	}
	
	private static int findGroup(int x, int y) {
		if (x < N / 2) {
			if (y < M / 2) {
				return 1;
			}
			return 2;
		}
		if (y < M / 2) {
			return 4;
		}
		return 3;
	}
}