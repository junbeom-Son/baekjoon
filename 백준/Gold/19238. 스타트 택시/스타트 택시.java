import java.io.*;
import java.util.*;

public class Main {
	static int N, M, taxiX, taxiY;
	static Map<Integer, Client> clients = new HashMap<>();
	static int[][] map, distance, clientDepartures;
	static int[] dx = new int[] { -1, 1, 0, 0 };
	static int[] dy = new int[] { 0, 0, -1, 1 };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken());
		int fuel = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		distance = new int[N + 1][N + 1];
		clientDepartures = new int[N + 1][N + 1];
		for (int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		taxiX = Integer.parseInt(st.nextToken());
		taxiY = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= M; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			Client client = new Client(startX, startY, endX, endY);
			clients.put(i, client);
			clientDepartures[startX][startY] = i;
		}
		br.close();
		
		while (!clients.isEmpty()) {
			int clientNumber = findClosestClient();
			if (clientNumber == -1) {
				System.out.println("-1");
				return;
			}
			Client client = clients.get(clientNumber);
			fuel -= distance[client.startX][client.startY];
			taxiX = client.startX;
			taxiY = client.startY;
			clientDepartures[client.startX][client.startY] = 0;
			if (fuel < 0) { // 승객까지 도달하지 못하면 실패
				System.out.println("-1");
				return;
			}
			
			int distanceToDestination = driveToDestination(client);
			fuel -= distanceToDestination;
			if (distanceToDestination == -1 || fuel < 0) { // 목적지까지 갈 수 있는 방법이 없거나, 연료가 모자라면 실패
				System.out.println("-1");
				return;
			}
			
			fuel += distanceToDestination * 2;
			taxiX = client.endX;
			taxiY = client.endY;
			clients.remove(clientNumber);
		}
		System.out.println(fuel);
	}
	
	private static int driveToDestination(Client client) {
		initializeDistance();
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { taxiX, taxiY });
		while (!queue.isEmpty()) {
			int[] position = queue.remove();
			int x = position[0];
			int y = position[1];
			if (x == client.endX && y == client.endY) {
				return distance[x][y];
			}
			for (int i = 0; i < 4; ++i) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				if (inRange(nextX, nextY) && map[nextX][nextY] == 0 && distance[x][y] + 1 < distance[nextX][nextY]) {
					distance[nextX][nextY] = distance[x][y] + 1;
					queue.add(new int[] { nextX, nextY });
				}
			}
		}
		return -1;
	}
	
	private static int findClosestClient() {
		initializeDistance();
		if (clientDepartures[taxiX][taxiY] != 0) {
			return clientDepartures[taxiX][taxiY];
		}
		int number = -1;
		int minDistance = Integer.MAX_VALUE;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { taxiX, taxiY });
		int clientX = 10000;
		int clientY = 10000;
		
		while (!queue.isEmpty()) {
			int[] position = queue.remove();
			int x = position[0];
			int y = position[1];
			for (int i = 0; i < 4; ++i) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				if (inRange(nextX, nextY) && map[nextX][nextY] == 0 && distance[x][y] + 1 < distance[nextX][nextY] && distance[x][y] + 1 <= minDistance) {
					queue.add(new int[] { nextX, nextY });
					distance[nextX][nextY] = distance[x][y] + 1;
					if (clientDepartures[nextX][nextY] != 0) {
						if (distance[nextX][nextY] < minDistance || (distance[nextX][nextY] == minDistance && (nextX < clientX || (nextX == clientX && nextY < clientY)))) {
							minDistance = distance[nextX][nextY];
							number = clientDepartures[nextX][nextY];
							clientX = nextX;
							clientY = nextY;
						}
					}
				}
			}
		}
		return number;
	}
	
	private static boolean inRange(int x, int y) {
		if (0 < x && x <= N && 0 < y && y <= N) {
			return true;
		}
		return false;
	}
	
	private static void initializeDistance() {
		for (int i = 1; i <= N; ++i) {
			Arrays.fill(distance[i], Integer.MAX_VALUE);
		}
		distance[taxiX][taxiY] = 0;
	}
}

class Client {
	int startX;
	int startY;
	int endX;
	int endY;
	public Client(int startX, int startY, int endX, int endY) {
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
	}
}