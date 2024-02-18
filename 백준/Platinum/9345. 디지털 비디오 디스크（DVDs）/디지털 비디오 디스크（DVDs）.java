import java.util.*;
import java.io.*;

public class Main {
	static int[] MAX_DVDs;
	static int[] MIN_DVDs;
	static int N, K, STANDARD;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder answer = new StringBuilder();
		for (int tc = 0; tc < t; ++tc) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			int[][] commands = new int[K][3];
			initializeStandardIndex();
			MAX_DVDs = new int[STANDARD * 2];
			MIN_DVDs = new int[STANDARD * 2];
			Arrays.fill(MAX_DVDs, Integer.MIN_VALUE);
			Arrays.fill(MIN_DVDs, Integer.MAX_VALUE);
			for (int i = 0; i < N; ++i) {
				MAX_DVDs[i + STANDARD] = i;
				MIN_DVDs[i + STANDARD] = i;
			}
			initialize();
			for (int i = 0; i < K; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 3; ++j) {
					commands[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int[] command : commands) {
				int a = command[1] + STANDARD;
				int b = command[2] + STANDARD;
				if (command[0] == 1) { // 찾기
					answer.append(isRightOrder(a, b) ? "YES\n" : "NO\n");
				} else { // 인덱스만 변경하기
					int tmp = MAX_DVDs[a];
					MAX_DVDs[a] = MAX_DVDs[b];
					MIN_DVDs[a] = MIN_DVDs[b];
					MAX_DVDs[b] = tmp;
					MIN_DVDs[b] = tmp;
					update(a / 2);
					update(b / 2);
				}
			}
		}
		br.close();
		System.out.print(answer);
	}
	
	private static boolean isRightOrder(int a, int b) {
		int start = a;
		int end = b;
		int minValue = MIN_DVDs[start];
		int maxValue = MAX_DVDs[start];
		
		while (start <= end) {
			minValue = Math.min(minValue, MIN_DVDs[start]);
			minValue = Math.min(minValue, MIN_DVDs[end]);
			
			maxValue = Math.max(maxValue, MAX_DVDs[start]);
			maxValue = Math.max(maxValue, MAX_DVDs[end]);
			
			start = (start + 1) / 2;
			end = (end - 1) / 2;
		}
		return minValue == (a - STANDARD) && maxValue == (b - STANDARD);
	}
	
	private static void update(int number) {
		while (number > 0) {
			MIN_DVDs[number] = Math.min(MIN_DVDs[number * 2], MIN_DVDs[number * 2 + 1]);
			MAX_DVDs[number] = Math.max(MAX_DVDs[number * 2], MAX_DVDs[number * 2 + 1]);
			number >>= 1;
		}
	}
	
	private static void initialize() {
		for (int i = STANDARD - 1; i > 0; --i) {
			MIN_DVDs[i] = Math.min(MIN_DVDs[i * 2], MIN_DVDs[i * 2 + 1]);
			MAX_DVDs[i] = Math.max(MAX_DVDs[i * 2], MAX_DVDs[i * 2 + 1]);
		}
	}
	
	private static void initializeStandardIndex() {
		STANDARD = 2;
		while (STANDARD < N) {
			STANDARD *= 2;
		}
	}
}