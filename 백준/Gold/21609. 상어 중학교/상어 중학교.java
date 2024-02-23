import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] board;
	static int total = 0;
	static Group largestGroup = null;
	static int[] dx = new int[] { -1, 1, 0, 0 };
	static int[] dy = new int[] { 0, 0, -1, 1 };
	static boolean[][] visited;
	static int RAINBOW = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while (true) {
			visited = new boolean[N][N];
			Group largestGroup = findLargestGroup();
			if (largestGroup == null) {
				break;
			}
			total += largestGroup.blockCount * largestGroup.blockCount;
			eliminateBlocks(largestGroup);
			gravityWorks();
			rotate();
			gravityWorks();
		}
		
		System.out.println(total);
	}
	
	private static void rotate() {
		int[][] newBoard = new int[N][N];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				newBoard[i][j] = board[j][N - i - 1];
			}
		}
		board = newBoard;
	}
	
	private static void gravityWorks() {
		for (int j = 0; j < N; ++j) {
			for (int i = N - 2; i >= 0; --i) {
				if (board[i][j] < 0) { // 검은색이나 빈칸은 필요 x
					continue;
				}
				for (int k = i + 1; k < N; ++k) {
					if (board[k][j] == -2) {
						board[k][j] = board[k - 1][j];
						board[k - 1][j] = -2;
					} else {
						break;
					}
				}
			}
		}
	}
	
	private static void eliminateBlocks(Group largestGroup) {
		for (int[] position : largestGroup.elements) {
			board[position[0]][position[1]] = -2;
		}
	}
	
	private static Group findLargestGroup() {
		Group largestGroup = null;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (board[i][j] > 0) {
					Group group = generateGroup(i, j);
					if (group.blockCount <= 1) {
						continue;
					}
					if (largestGroup == null || (group.blockCount > largestGroup.blockCount)
							|| (group.blockCount == largestGroup.blockCount && group.rainbowCount >= largestGroup.rainbowCount)) {
						largestGroup = group;
					}
					initializeNotVisit();
				}
			}
		}
		return largestGroup;
	}
	
	private static void initializeNotVisit() {
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (board[i][j] == RAINBOW) {
					visited[i][j] = false;
				}
			}
		}
	}
	
	private static Group generateGroup(int x, int y) {
		Group group = new Group(x, y);
		int color = board[x][y];
		visited[x][y] = true;
		Queue<int[]> queue = new LinkedList<>();
		int rainbowCount = 0;
		queue.add(new int[] { x, y });
		while (!queue.isEmpty()) {
			int[] position = queue.remove();
			x = position[0];
			y = position[1];
			for (int i = 0; i < 4; ++i) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (inRange(nx, ny) && (board[nx][ny] == color || board[nx][ny] == RAINBOW) && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.add(new int[] { nx, ny });
					group.addBlock(nx, ny);
					if (board[nx][ny] == RAINBOW) {
						++rainbowCount;
					}
				}
			}
		}
		group.rainbowCount = rainbowCount;
		group.blockCount = group.elements.size();
		return group;
	}
	
	private static boolean inRange(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < N) {
			return true;
		}
		return false;
	}
}

class Group {
	int rx; // 대표 x
	int ry; // 대표 y
	List<int[]> elements = new ArrayList<>();
	int rainbowCount = 0;
	int blockCount = 0;
	Group(int rx, int ry) {
		this.rx = rx;
		this.ry = ry;
		addBlock(rx, ry);
	}
	
	void addBlock(int x, int y) {
		elements.add(new int[] { x, y });
	}
}