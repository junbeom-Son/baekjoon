import java.io.*;
import java.util.*;

public class Solution {

	static int M, A;
	static int[] order;
	static Cell[][] cells;
	static int[][] lastCharged;
	static int[][] userCommands;
	static int[] dx = new int[] { 0, 0, 1, 0, -1 };
	static int[] dy = new int[] { 0, -1, 0, 1, 0 };
	static AP[] APs;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder answer = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; ++tc) {
			answer.append("#").append(tc).append(" ");
			cells = new Cell[11][11];
			lastCharged = new int[11][11];
			for (int i = 1; i <= 10; ++i) {
				for (int j = 1; j <= 10; ++j) {
					cells[i][j] = new Cell();
				}
			}
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			userCommands = new int[2][M + 1];
			for (int i = 0; i < 2; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j <= M; ++j) {
					userCommands[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			PriorityQueue<AP> pq = new PriorityQueue<>();
			APs = new AP[A + 1];
			APs[0] = new AP(0, 0, 0, 0);
			for (int i = 0; i < A; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				pq.add(new AP(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			initializeCells(pq);
			answer.append(movePlayers()).append("\n");
		}
		br.close();
		System.out.print(answer);
	}
	
	private static int movePlayers() {
		int total = 0;
		int[][] players = new int[][] { { 1, 1 }, { 10, 10 } };
		for (int i = 0; i <= M; ++i) {
			
			// 이동
			for (int p = 0; p < 2; ++p) {
				int direction = userCommands[p][i];
				players[p][0] += dx[direction];
				players[p][1] += dy[direction];
			}
			
			// 이동 후 배터리 검사
			total += charge(players);
		}
		return total;
	}
	
	private static int charge(int[][] players) {
		int x1 = players[0][0];
		int y1 = players[0][1];
		int x2 = players[1][0];
		int y2 = players[1][1];
		// 2 개의 배터리가 같은 경우
		if (cells[x1][y1].battery1 == cells[x2][y2].battery1) {
			int battery1 = cells[x1][y1].battery1;
			int battery2 = cells[x1][y1].battery2;
			int candidate1 = cells[x1][y1].battery2;
			int candidate2 = cells[x2][y2].battery2;
			
			// 후보 2가 더 강한 경우
			if (APs[candidate1].p < APs[candidate2].p) {
				battery2 = cells[x2][y2].battery2;
			}
			int power1 = APs[battery1].p;
			int power2 = APs[battery2].p;
			return power1 + power2;
		}
		
		// 2 개의 배터리가 다른 경우
		return APs[cells[x1][y1].battery1].p + APs[cells[x2][y2].battery1].p;
	}
	
	private static void initializeCells(PriorityQueue<AP> pq) {
		int number = 1;
		while (!pq.isEmpty()) {
			AP ap = pq.poll();
			APs[number] = ap;
			int range = ap.c;
			
			PriorityQueue<AP> thisRound = new PriorityQueue<>();
			thisRound.add(ap);
			lastCharged[ap.x][ap.y] = number;
			for (int i = 0; i <= range; ++i) {
				PriorityQueue<AP> nextRound = new PriorityQueue<>();
				while (!thisRound.isEmpty()) {
					AP curAP = thisRound.poll();
					cells[curAP.x][curAP.y].add(number);
					for (int d = 1; d <= 4; ++d) {
						int nx = curAP.x + dx[d];
						int ny = curAP.y + dy[d];
						if (1 <= nx && nx <= 10 && 1 <= ny && ny <= 10 && lastCharged[nx][ny] < number) {
							nextRound.add(new AP(nx, ny, curAP.c, curAP.p));
							lastCharged[curAP.x][curAP.y] = number;
						}
					}
				}
				thisRound = nextRound;
			}
			++number;
		}
	}
}

class Cell {
	int battery1;
	int battery2;
	
	void add(int batteryNumber) {
		if (battery1 == 0) {
			battery1 = batteryNumber;
			return;
		}
		if (battery1 != batteryNumber && battery2 == 0) {
			battery2 = batteryNumber;
			return;
		}
	}
}

class AP implements Comparable<AP> {
	int x;
	int y;
	int c;
	int p;
	AP(int x, int y, int c, int p) {
		this.x = x;
		this.y = y;
		this.c = c;
		this.p = p;
	}
	
	public int compareTo(AP otherAP) {
		return otherAP.p - p;
	}
}