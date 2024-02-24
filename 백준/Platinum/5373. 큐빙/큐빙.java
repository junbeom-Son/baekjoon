import java.io.*;
import java.util.*;

public class Main {
	static char[] colors;
	static Map<Character, Integer> planeToIndex = new HashMap<>();
	static Map<Character, Integer> directionToIndex = new HashMap<>();
	static int[][][] rotateOrders;
	static int[][][] dx;
	static int[][][] dy;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		initialize();
		StringBuilder answer = new StringBuilder();
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String[] commands = new String[n];
			for (int i = 0; i < n; ++i) {
				commands[i] = st.nextToken();
			}
			answer.append(getAnswer(commands));
		}
		br.close();
		System.out.println(answer);
	}
	
	private static String getAnswer(String[] commands) {
		StringBuilder answer = new StringBuilder();
		char[][][] cube = getInitialCube();
		for (String command : commands) {
			char plane = command.charAt(0);
			char direction = command.charAt(1);
			rotate(planeToIndex.get(plane),directionToIndex.get(direction), cube);
		}
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				answer.append(cube[0][i][j]);
			}
			answer.append("\n");
		}
		return answer.toString();
	}
	
	private static void rotate(int plane, int direction, char[][][] cube) {
		int[] rotateOrder = rotateOrders[plane][direction];
		char[] last = new char[3];
		char[] cur = new char[3];
		for (int i = 0; i < 3; ++i) {
			int x = dx[plane][rotateOrder[0]][i];
			int y = dy[plane][rotateOrder[0]][i];
			last[i] = cube[rotateOrder[0]][x][y];
		}
		for (int i = 1; i <= 4; ++i) {
			int number = rotateOrder[i];
			for (int j = 0; j < 3; ++j) {
				int x = dx[plane][number][j];
				int y = dy[plane][number][j];
				cur[j] = cube[number][x][y];
				cube[number][x][y] = last[j];
			}
			last = Arrays.copyOf(cur, 3);
		}
		cube[plane] = planeRotate(plane, direction, cube[plane]);
	}
	
	private static char[][] planeRotate(int plane, int direction, char[][] curPlane) {
		char[][] newPlane = new char[3][3];
		if (direction == 0) {
			for (int i = 0; i < 3; ++i) {
				for (int j = 0; j < 3; ++j) {
					newPlane[i][j] = curPlane[3 - j - 1][i];
				}
			}
		} else {
			for (int i = 0; i < 3; ++i) {
				for (int j = 0; j < 3; ++j) {
					newPlane[i][j] = curPlane[j][3 - i - 1];
				}
			}
		}
		return newPlane;
	}
	
	private static char[][][] getInitialCube() {
		char[][][] cube = new char[6][3][3];
		for (int i = 0; i < 6; ++i) {
			for (int j = 0; j < 3; ++j) {
				Arrays.fill(cube[i][j], colors[i]);
			}
		}
		return cube;
	}
	
	private static void initialize() {
		colors = new char[] { 'w', 'y', 'r', 'o', 'g', 'b' };
		planeToIndex.put('U', 0);
		planeToIndex.put('D', 1);
		planeToIndex.put('F', 2);
		planeToIndex.put('B', 3);
		planeToIndex.put('L', 4);
		planeToIndex.put('R', 5);
		directionToIndex.put('+', 0);
		directionToIndex.put('-', 1);
		rotateOrders = new int[][][] {
			// 0: 시계 방향, 1: 반시계 방향
			{{4, 3, 5, 2, 4}, {5, 3, 4, 2, 5}},
			{{4, 2, 5, 3, 4}, {5, 2, 4, 3, 5}},
			{{4, 0, 5, 1, 4}, {5, 0, 4, 1, 5}},
			{{5, 0, 4, 1, 5}, {4, 0, 5, 1, 4}},
			{{3, 0, 2, 1, 3}, {2, 0, 3, 1, 2}},
			{{2, 0, 3, 1, 2}, {3, 0, 2, 1, 3}}
		};
		dx = new int[][][] {
			{{}, {}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
			{{}, {}, {2, 2, 2}, {2, 2, 2}, {2, 2, 2}, {2, 2, 2}},
			{{2, 2, 2}, {0, 0, 0}, {}, {}, {2, 1, 0}, {0, 1, 2}},
			{{0, 0, 0}, {2, 2, 2}, {}, {}, {2, 1, 0}, {0, 1, 2}},
			{{0, 1, 2}, {0, 1, 2}, {0, 1, 2}, {2, 1, 0}, {}, {}},
			{{2, 1, 0}, {2, 1, 0}, {2, 1, 0}, {0, 1, 2}, {}, {}}
		};
		dy = new int[][][] {
			{{}, {}, {0, 1, 2}, {0, 1, 2}, {0, 1, 2}, {0, 1, 2}},
			{{}, {}, {0, 1, 2}, {0, 1, 2}, {0, 1, 2}, {0, 1, 2}},
			{{0, 1, 2}, {2, 1, 0}, {}, {}, {2, 2, 2}, {0, 0, 0}},
			{{0, 1, 2}, {2, 1, 0}, {}, {}, {0, 0, 0}, {2, 2, 2}},
			{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {2, 2, 2}, {}, {}},
			{{2, 2, 2}, {2, 2, 2}, {2, 2, 2}, {0, 0, 0}, {}, {}}
		};
	}
}