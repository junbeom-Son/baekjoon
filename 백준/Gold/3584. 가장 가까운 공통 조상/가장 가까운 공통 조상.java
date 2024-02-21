import java.io.*;
import java.util.*;

public class Main {
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder answer = new StringBuilder();
		for (int t = 0; t < T; ++t) {
			int N = Integer.parseInt(br.readLine());
			parents = new int[N + 1];
			for (int i = 0; i < N - 1; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				parents[child] = parent;
			}
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int levelA = getLevel(A);
			int levelB = getLevel(B);
			if (levelA < levelB) {
				B = balanceLevel(B, levelB - levelA);
			} else {
				A = balanceLevel(A, levelA - levelB);
			}
			while (A != B) {
				A = parents[A];
				B = parents[B];
			}
			answer.append(A).append("\n");
		}
		br.close();
		System.out.println(answer);
	}
	
	private static int balanceLevel(int node, int targetLevel) {
		for (int i = 0; i < targetLevel; ++i) {
			node = parents[node];
		}
		return node;
	}
	
	private static int getLevel(int node) {
		int level = 0;
		while (node > 0) {
			node = parents[node];
			++level;
		}
		return level;
	}
}