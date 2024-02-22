import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] players;
	static int[] order = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		players = new int[N][9];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 9; ++j) {
				players[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int score = 0;
		do {
			score = Math.max(score, getScore());
		} while (nextPermutation());
		System.out.println(score);
	}
	
	private static int getScore() {
		int score = 0;
		int turn = 0;
		int[] curOrder = new int[9];
		for (int i = 0; i < 3; ++i) {
			curOrder[i] = order[i];
		}
		curOrder[3] = 0;
		for (int i = 3; i < 8; ++i) {
			curOrder[i + 1] = order[i];
		}
		int[] left;
		for (int inning = 0; inning < N; ++inning) {
			left = new int[4];
			int out = 0;
			while (out < 3) {
				int hitter = curOrder[turn];
				left[0] = 1;
				turn = (turn + 1) % 9;
				int power = players[inning][hitter];
				if (power == 0) {
					++out;
					continue;
				}
				for (int i = 3; i >= 0; --i) {
					if (left[i] == 0) {
						continue;
					}
					left[i] = 0;
					if (i + power >= 4) {
						++score;
					} else {
						left[i + power] = 1;
					}
				}
			}
		}
		return score;
	}
	
	private static boolean nextPermutation() {
		int i = order.length - 1;
		while (i > 0 && order[i - 1] >= order[i]) --i;
		
		if (i == 0) return false;
		
		int j = order.length - 1;
		while (order[i - 1] >= order[j]) --j;
		
		swap(i - 1, j);
		
		int k = order.length - 1;
		while (i < k) swap(i++, k--);
		
		return true;
	}
	
	private static void swap(int i, int j) {
		int tmp = order[i];
		order[i] = order[j];
		order[j] = tmp;
	}
}