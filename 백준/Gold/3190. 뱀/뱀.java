import java.io.*;
import java.util.*;

public class Main {
	static int dx[] = { 0, 1, 0, -1 }; // 우, 하, 좌, 상
	static int dy[] = { 1, 0, -1, 0 };
	static Map<Character, Integer> turnAround = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		boolean[][] gameMap = new boolean[n + 1][n + 1];
		boolean[][] appleMap = new boolean[n + 1][n + 1];
		turnAround.put('D', 1);
		turnAround.put('L', -1);
		for (int i = 0; i < k; ++i) {
			String[] input = br.readLine().split(" ");
			appleMap[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = true;
		}
		int l = Integer.parseInt(br.readLine());
		int[] commandTimes = new int[l];
		char[] commandDirections = new char[l];
		for (int i = 0; i < l; ++i) {
			String[] input = br.readLine().split(" ");
			commandTimes[i] = Integer.parseInt(input[0]);
			commandDirections[i] = input[1].charAt(0);
		}
		gameMap[1][1] = true;
		Deque<int[]> deque = new ArrayDeque<>();
		deque.add(new int[] {1, 1});
		int commandIndex = 0;
		int time = 0;
		int direction = 0;
		while (!deque.isEmpty()) {
			int[] positions = deque.getLast();
			int x = positions[0];
			int y = positions[1];
			++time;
			int nextX = x + dx[direction];
			int nextY = y + dy[direction];
			if (nextX <= 0 || n < nextX || nextY <= 0 || n < nextY || gameMap[nextX][nextY]) {
				break;
			}
			
			// 전진
			gameMap[nextX][nextY] = true;
			deque.add(new int[] { nextX, nextY });
			
			// 사과가 없으면 꼬리 부분 맵에서 삭제
			if (!appleMap[nextX][nextY]) {
				int[] tailPosition = deque.pollFirst();
				gameMap[tailPosition[0]][tailPosition[1]] = false;
			}  else {
				appleMap[nextX][nextY] = false;
			}
			
			if (commandIndex < l && time == commandTimes[commandIndex]) {
				direction += turnAround.get(commandDirections[commandIndex]);
				// 방향 조절
				direction = direction < 0 ? direction + 4 : direction;
				direction = direction == 4 ? 0 : direction;
				++commandIndex;
			}
		}
		System.out.println(time);
		br.close();
	}
}