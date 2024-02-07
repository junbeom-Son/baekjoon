import java.io.*;
import java.util.*;

public class Main {
	static int N, M, H, JX, JY;
	static int[][] locations;
	static int answer = 0;
	static boolean[] visited;
	static int milkCount = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		locations = new int[10][2];
		visited = new boolean[10];
		int locationIndex = 0;
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; ++j) {
				int number = Integer.parseInt(st.nextToken());
				if (number == 0) {
					continue;
				}
				if (number == 1) {
					JX = i;
					JY = j;
				} else {
					locations[locationIndex][0] = i;
					locations[locationIndex++][1] = j;
					++milkCount;
				}
			}
		}
		
		for (int i = 0; i < milkCount; ++i) {
			int distance = Math.abs(JX - locations[i][0]) + Math.abs(JY - locations[i][1]);
			if (distance <= M) {
				visited[i] = true;
				visitMilk(0, M - distance, i);
				visited[i] = false;
			}
		}
		System.out.println(answer);
		br.close();
	}
	
	static void visitMilk(int depth, int leftHP, int number) {
		if (depth == milkCount) {
			return;
		}
		leftHP += H;
		int homeDistance = Math.abs(JX - locations[number][0]) + Math.abs(JY - locations[number][1]);
		if (homeDistance <= leftHP) {
			answer = Math.max(answer, depth + 1);
		}
		
		for (int i = 0; i < milkCount; ++i) {
			if (visited[i]) {
				continue;
			}
			int distance = Math.abs(locations[number][0] - locations[i][0]) + Math.abs(locations[number][1] - locations[i][1]);
			if (distance <= leftHP) {
				visited[i] = true;
				visitMilk(depth + 1, leftHP - distance, i);
				visited[i] = false;
			}
		}
	}
}