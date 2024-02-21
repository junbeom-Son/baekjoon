import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static List<Set<Integer>> friends = new ArrayList<>();
	static Set<Integer> included = new HashSet<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; ++i) {
			friends.add(new HashSet<>());
		}
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			friends.get(a).add(b);
			friends.get(b).add(a);
		}
		br.close();
		int answer = 0;
		for (int i = 0; i < N; ++i) {
			included.add(i);
			if (isABCDE(0, i)) {
				answer = 1;
				break;
			}
			included.remove(i);
		}
		System.out.println(answer);
	}
	
	private static boolean isABCDE(int depth, int number) {
		if (depth == 4) {
			return true;
		}
		for (int friend : friends.get(number)) {
			if (!included.contains(friend)) {
				included.add(friend);
				if (isABCDE(depth + 1, friend)) {
					return true;
				}
				included.remove(friend);
			}
		}
		return false;
	}
}