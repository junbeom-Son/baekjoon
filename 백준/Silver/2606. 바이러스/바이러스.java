import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] group;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		group = new int[N + 1];
		for (int i = 1; i <= N; ++i) {
			group[i] = i;
		}
		StringTokenizer st;
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			a = find(a);
			b = find(b);
			if (a < b) {
				group[b] = a;
			} else {
				group[a] = b;
			}
		}
		br.close();
		int answer = 0;
		for (int i = 2; i <= N; ++i) {
			if (find(i) == 1) {
				++answer;
			}
		}
		System.out.println(answer);
	}

	private static int find(int number) {
		if (number != group[number]) {
			group[number] = find(group[number]);
		}
		return group[number];
	}
}
