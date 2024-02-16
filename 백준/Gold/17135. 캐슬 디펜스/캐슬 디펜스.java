import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M, D;
	static int[][] field;
	static int[] castle;
	static List<Integer> dx = new ArrayList<>();
	static List<Integer> dy = new ArrayList<>(); 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		field = new int[N][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; ++j) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		castle = new int[M];
		for (int j = M - 3; j < M; ++j) {
			castle[j] = 1;
		}
		for (int i = 1; i <= D; ++i) {
			for (int row = 1, col = i - 1; row < i; ++row, --col) {
				dx.add(-row);
				dy.add(-col);
			}
			dx.add(-i);
			dy.add(0);
			for (int row = i - 1, col = 1; row >= 1; --row, ++col) {
				dx.add(-row);
				dy.add(col);
			}
		}
		
		int answer = 0;
		do {
			int[][] copiedField = new int[N][M];
			for (int i = 0; i < N; ++i) {
				copiedField[i] = Arrays.copyOf(field[i], M);
			}
			
			int killed = 0;
			for (int i = 0; i < N; ++i) {
				killed += kill(copiedField);
				for (int j = N - 1; j > i; --j) {
					copiedField[j] = copiedField[j - 1];
				}
				copiedField[i] = new int[M];
			}
			answer = Math.max(answer, killed);
		} while (nextPermutation());
		
		System.out.println(answer);
	}
	
	private static int kill(int[][] copiedField) {
		int count = 0;
		boolean[] killed = new boolean[M];
		boolean[][] killPosition = new boolean[N][M];
		Set<int[]> set = new HashSet<>();
		for (int next = 0; next < dx.size(); ++next) {
			for (int j = 0; j < M; ++j) {
				if (castle[j] == 0 || killed[j]) {
					continue;
				}
				int x = N + dx.get(next);
				int y = j + dy.get(next);
				if (0 <= x && x < N && 0 <= y && y < M && copiedField[x][y] == 1) {
					if (!killPosition[x][y]) {
						++count;
						killPosition[x][y] = true;
						set.add(new int[] { x, y });
					}
					killed[j] = true;
				}
			}
			if (count == 3) {
				break;
			}
		}
		for (int[] position : set) {
			copiedField[position[0]][position[1]] = 0;
		}
		return count;
	}
	
	private static boolean nextPermutation() {
		int i = M - 1;
		while (i > 0 && castle[i - 1] >= castle[i]) --i;
		
		if (i == 0) return false;
		
		int j = M - 1;
		while (castle[i - 1] >= castle[j]) --j;
		
		swap(i - 1, j);
		
		int k = M - 1;
		while (i < k) swap(i++, k--);
		
		return true;
	}
	
	private static void swap(int i, int j) {
		int tmp = castle[i];
		castle[i] = castle[j];
		castle[j] = tmp;
	}
}