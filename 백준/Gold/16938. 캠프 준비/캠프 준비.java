import java.io.*;
import java.util.*;

public class Main {
	static int N, L, R, X;
	static int[] levels;
	static int answer = 0;
	static List<Integer> numbers = new LinkedList<>();
	static boolean[] included;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		br.close();
		levels = new int[N];
		for (int i = 0; i < N; ++i) {
			levels[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(levels);
		included = new boolean[N];
		getAnswer(0);
		System.out.println(answer);
	}
	
	private static void getAnswer(int depth) {
		if (depth == N) {
			int sum = 0;
			int minValue = Integer.MAX_VALUE;
			int maxValue = Integer.MIN_VALUE;
			int count = 0;
			for (int i = 0; i < N; ++i) {
				if (included[i]) {
					minValue = Math.min(minValue, levels[i]);
					maxValue = Math.max(maxValue, levels[i]);
					sum += levels[i];
					++count;
				}
			}
			if (maxValue - minValue >= X && count >= 2 && L <= sum && sum <= R) {
				++answer;
			}
			return;
		}
		included[depth] = true;
		getAnswer(depth + 1);
		included[depth] = false;
		getAnswer(depth + 1);
	}
}