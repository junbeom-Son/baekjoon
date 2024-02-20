import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static char[][] area;
	static boolean[][] visited;
	static int[] dx = new int[] { -1, 1, 0, 0 };
	static int[] dy = new int[] { 0, 0, -1, 1 };
	static Map<Character, Integer> map = new HashMap<>();
	public static void main(String args[]) throws IOException {
		StringBuilder answer = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		area = new char[N][N];
		map.put('R', 0);
		map.put('G', 1);
		map.put('B', 2);
		for (int i = 0; i < N; ++i) {
			area[i] = br.readLine().toCharArray();
		}
		visited = new boolean[N][N];
		int count = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (!visited[i][j]) {
					countArea(i, j);
					visited[i][j] = true;
					++count;
				}
			}
		}
		answer.append(count).append(" ");
		
		count = 0;
		visited = new boolean[N][N];
		map.put('G', 0);
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (!visited[i][j]) {
					countArea(i, j);
					visited[i][j] = true;
					++count;
				}
			}
		}
		
		answer.append(count);
		System.out.println(answer);
		br.close();
	}
	
	private static void countArea(int x, int y) {
		int color = map.get(area[x][y]);
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y });
		while (!queue.isEmpty()) {
			int[] position = queue.remove();
			x = position[0];
			y = position[1];
			for (int i = 0; i < 4; ++i) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				if (0 <= nextX && nextX < N && 0 <= nextY && nextY < N && !visited[nextX][nextY] && map.get(area[nextX][nextY]) == color) {
					visited[nextX][nextY] = true;
					queue.add(new int[] { nextX, nextY });
				}
			}
		}
	}
}