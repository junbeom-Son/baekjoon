import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] originalMap, copiedMap;
	static List<int[]> virusPositions = new LinkedList<>();
	static Deque<int[]> selectedWallPositions = new ArrayDeque<>();
	static int maxSafeArea = 0;
	static int[] dx = new int[] { -1, 1, 0, 0 };
	static int[] dy = new int[] { 0, 0, -1, 1 };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		originalMap = new int[N][M];
		copiedMap = new int[N][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; ++j) {
				originalMap[i][j] = Integer.parseInt(st.nextToken());
				if (originalMap[i][j] == 2) {
					virusPositions.add(new int[] { i, j });
				}
			}
		}
		br.close();
		
		selectWalls(0, 0);
		System.out.println(maxSafeArea);
	}
	
	private	static void selectWalls(int depth, int index) {
		if (depth == 3) {
			spreadVirus();
			int count = 0;
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < M; ++j) {
					if (copiedMap[i][j] == 0) {
						++count;
					}
				}
			}
			maxSafeArea = Math.max(maxSafeArea, count);
			return;
		}
		for (int i = index; i < N * M; ++i) {
			int row = i / M;
			int col = i % M;
			if (originalMap[row][col] == 0) {
				selectedWallPositions.add(new int[] { row, col });
				selectWalls(depth + 1, i + 1);
				selectedWallPositions.removeLast();
			}
		}
	}
	
	private static void spreadVirus() {
		for (int i = 0; i < N; ++i) {
			copiedMap[i] = Arrays.copyOf(originalMap[i], M);
		}
		Queue<int[]> virusQueue = new LinkedList<>();
		for (int[] virusPosition : virusPositions) {
			virusQueue.add(virusPosition);
		}
		for (int[] wallPosition : selectedWallPositions) {
			copiedMap[wallPosition[0]][wallPosition[1]] = 1;
		}
		
		while (!virusQueue.isEmpty()) {
			int[] position = virusQueue.remove();
			int x = position[0];
			int y = position[1];
			for (int i = 0; i < 4; ++i) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < M && copiedMap[nx][ny] == 0) {
					copiedMap[nx][ny] = 2;
					virusQueue.add(new int[] { nx, ny });
				}
			}
		}
	}
}