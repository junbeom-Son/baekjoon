import java.io.*;
import java.util.*;

public class Main {
	static int R, C;
	static char[][] pipelines;
	static int answer = 0;
	static boolean[][] visited;
	static int[] nextRows = new int[] { -1, 0, 1 };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		pipelines = new char[R][];
		visited = new boolean[R][C];
		for (int i = 0; i < R; ++i) {
			pipelines[i] = br.readLine().toCharArray();
		}
		br.close();
		for (int i = 0; i < R; ++i) {
			createPipeline(i, 0);
		}
		System.out.println(answer);
	}
	
	private static boolean createPipeline(int row, int col) {
		if (col == C - 1) {
			++answer;
			return true;
		}
		boolean canReach = false;
		for (int d : nextRows) {
			int nextRow = d + row;
			if (0 <= nextRow && nextRow < R && pipelines[nextRow][col + 1] == '.' && !visited[nextRow][col + 1]) {
				visited[nextRow][col + 1] = true;
				canReach = createPipeline(nextRow, col + 1);
			}
			if (canReach) {
				break;
			}
		}
		return canReach;
	}
}