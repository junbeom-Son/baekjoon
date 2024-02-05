import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int m;
	static int[] group;
	static int[][] turns;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		group = new int[n];
		turns = new int[m + 1][2];
		for (int i = 1; i <= m; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			turns[i][0] = Integer.parseInt(st.nextToken());
			turns[i][1] = Integer.parseInt(st.nextToken());
		}
		br.close();
		for (int i = 0; i < n; ++i) {
			group[i] = i;
		}
		System.out.println(play());
	}
	
	private static int play() {
		for (int i = 1; i <= m; ++i) {
			int n1 = turns[i][0];
			int n2 = turns[i][1];
			n1 = findGroup(n1);
			n2 = findGroup(n2);
			if (n1 == n2) {
				return i;
			}
			if (n1 < n2) {
				group[n2] = n1;
			} else {
				group[n1] = n2;
			}
		}
		return 0;
	}
	
	private static int findGroup(int number) {
		if (group[number] != number) {
			group[number] = findGroup(group[number]);
		}
		return group[number];
	}
}