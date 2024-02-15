import java.io.*;
import java.util.*;

public class Solution {

	static char[][] gameMap;
	static int H;
	static int W;
	static int N;
	static int x;
	static int y;
	static Map<Character, Character> turns = new HashMap<>();
	static Map<Character, int[]> directions = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;
		initialize();
		for (int tc = 1; tc <= t; ++tc) {
			answer.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			x = -1;
			y = -1;
			gameMap = new char[H][W];
			for (int i = 0; i < H; ++i) {
				gameMap[i] = br.readLine().toCharArray();
			}
			for (int i = 0; i < H; ++i) {
				for (int j = 0; j < W; ++j) {
					if (directions.containsKey(gameMap[i][j])) {
						x = i;
						y = j;
						break;
					}
				}
				if (x != -1) {
					break;
				}
			}
			N = Integer.parseInt(br.readLine());
			for (char command : br.readLine().toCharArray()) {
				act(command);
			}
			for (char[] row : gameMap) {
				for (char col : row) {
					answer.append(col);
				}
				answer.append("\n");
			}
		}
		System.out.print(answer);
		br.close();
	}
	
	private static void act(char command) {
		// 전차 이동 관련
		if (turns.containsKey(command)) {
			char direction = turns.get(command);
			gameMap[x][y] = direction;
			int nx = x + directions.get(direction)[0];
			int ny = y + directions.get(direction)[1];
			// 범위 밖이면 이동은 x
			if (!inRange(nx, H) || !inRange(ny, W)) {
				return;
			}
			if (gameMap[nx][ny] == '.') {
				gameMap[nx][ny] = gameMap[x][y];
				gameMap[x][y] = '.';
				x = nx;
				y = ny;
			}
			return;
		}
		
		// 포탄처리
		if (command == 'S') {
			int dx = directions.get(gameMap[x][y])[0];
			int dy = directions.get(gameMap[x][y])[1];
			int nx = x + dx;
			int ny = y + dy;
			while (inRange(nx, H) && inRange(ny, W) && (gameMap[nx][ny] == '.' || gameMap[nx][ny] == '-')) {
				nx += dx;
				ny += dy;
			}
			
			// 중간에 벽을 만났다면
			if (inRange(nx, H) && inRange(ny, W)) {
				if (gameMap[nx][ny] == '*') {
					gameMap[nx][ny] = '.';
				}
			}
			
			return;
		}
	}
	
	private static boolean inRange(int p, int limit) {
		if (0 <= p && p < limit) {
			return true;
		}
		return false;
	}
	
	private static void initialize() {
		turns.put('U', '^');
		turns.put('D', 'v');
		turns.put('L', '<');
		turns.put('R', '>');
		directions.put('^', new int[] { -1, 0 });
		directions.put('v', new int[] { 1, 0 });
		directions.put('<', new int[] { 0, -1 });
		directions.put('>', new int[] { 0, 1 });
	}
}