import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder answer = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int length = 2;
		while (length < N) {
			length <<= 1;
		}
		
		int[] minTree = new int[length * 2];
		int[] maxTree = new int[length * 2];
		Arrays.fill(minTree, 2000000000);
		for (int i = 0; i < N; ++i) {
			minTree[i + length] = Integer.parseInt(br.readLine());
			maxTree[i + length] = minTree[i + length];
		}
		for (int i = length - 1; i > 0; --i) {
			minTree[i] = Math.min(minTree[i * 2], minTree[i * 2 + 1]);
			maxTree[i] = Math.max(maxTree[i * 2], maxTree[i * 2 + 1]);
		}
		
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken()) + length - 1;
			int end = Integer.parseInt(st.nextToken()) + length - 1;
			int minValue = Integer.MAX_VALUE;
			int maxValue = Integer.MIN_VALUE;
			while (start <= end) {
				if (start % 2 == 1) {
					minValue = Math.min(minValue, minTree[start]);
					maxValue = Math.max(maxValue, maxTree[start]);
				}
				if (end % 2 == 0) {
					minValue = Math.min(minValue, minTree[end]);
					maxValue = Math.max(maxValue, maxTree[end]);
				}
				start = (start + 1) / 2;
				end = (end - 1) / 2;
			}
			answer.append(minValue).append(" ").append(maxValue).append("\n");
		}
		br.close();
		System.out.println(answer);
	}
}