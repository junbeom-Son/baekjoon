import java.io.*;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[] included;
	static int[] numbers;
	static int answer = 0;
	static int N;
	static int[] A;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();
		A = new int[N];
		numbers = new int[N];
		included = new boolean[N];
		for (int i = 0; i < N; ++i) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		selectNumbers(0);
		System.out.println(answer);
	}
	
	private static void selectNumbers(int depth) {
		if (depth == N) {
			int sum = 0;
			for (int i = 0; i < N - 1; ++i) {
				sum += Math.abs(numbers[i] - numbers[i + 1]);
			}
			answer = Math.max(answer, sum);
			return;
		}
		for (int i = 0; i < N; ++i) {
			if (!included[i]) {
				included[i] = true;
				numbers[depth] = A[i];
				selectNumbers(depth + 1);
				included[i] = false;
			}
		}
	}
}