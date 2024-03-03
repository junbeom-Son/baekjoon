import java.io.*;
import java.util.*;

public class Main {
	static int N, M, k;
	static int[][] smellVanishTime;
	static int[][] smellNumber;
	static int[] directions;
	static Map<Integer, int[]> sharkPositions = new HashMap<>();
	static int[] dx = new int[] { 0, -1, 1, 0, 0 };
	static int[] dy = new int[] { 0, 0, 0, -1, 1 };
	static int[][][] priorityDirections;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		smellVanishTime = new int[N][N];
		smellNumber = new int[N][N];
		directions = new int[M + 1];
		priorityDirections = new int[M + 1][5][4];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; ++j) {
				int number = Integer.parseInt(st.nextToken());
				if (number != 0) {
					sharkPositions.put(number, new int[] { i, j });
					smellVanishTime[i][j] = k;
					smellNumber[i][j] = number;
				}
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= M; ++i) {
			directions[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= M; ++i) {
			for (int j = 1; j <= 4; ++j) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < 4; ++k) {
					priorityDirections[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		
		
		int time = 0;
		while (sharkPositions.size() > 1 && time <= 1000) {
			// 다음 어느 방향으로 갈지 정한다.
			for (int i = 1; i <= M; ++i) {
				if (!sharkPositions.containsKey(i)) {
					continue;
				}
				directions[i] = getNextDirection(i, time);
			}
			
			++time;
			// 실제 움직인다.
			for (int i = 1; i <= M; ++i) {
				if (!sharkPositions.containsKey(i)) {
					continue;
				}
				int direction = directions[i];
				int nx = sharkPositions.get(i)[0] + dx[direction];
				int ny = sharkPositions.get(i)[1] + dy[direction];
				if (smellNumber[nx][ny] != i && smellVanishTime[nx][ny] > time) {
					sharkPositions.remove(i);
					continue;
				}
				sharkPositions.get(i)[0] = nx;
				sharkPositions.get(i)[1] = ny;
				smellVanishTime[nx][ny] = time + k;
				smellNumber[nx][ny] = i;
			}
			
		}
		if (time > 1000) {
			time = -1;
		}
		System.out.println(time);
	}
	
	private static int getNextDirection(int sharkNumber, int time) {
		int x = sharkPositions.get(sharkNumber)[0];
		int y = sharkPositions.get(sharkNumber)[1];
		int currentDirection = directions[sharkNumber];
		for (int i = 0; i < 4; ++i) {
			int direction = priorityDirections[sharkNumber][currentDirection][i];
			int nx = x + dx[direction];
			int ny = y + dy[direction];
			if (0 <= nx && nx < N && 0 <= ny && ny < N && smellVanishTime[nx][ny] <= time) {
				return direction;
			}
		}
		for (int i = 0; i < 4; ++i) {
			int direction = priorityDirections[sharkNumber][currentDirection][i];
			int nx = x + dx[direction];
			int ny = y + dy[direction];
			// 본인의 서식지
			if (0 <= nx && nx < N && 0 <= ny && ny < N && smellNumber[nx][ny] == sharkNumber) {
				return direction;
			}
		}
		return -1;
	}
}