import java.io.*;
import java.util.*;

public class Main {
	static int[][] permutations;
	static int[][] copiedPermutations;
	static boolean possible;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		for (int t = 0; t < 4; ++t) {
			int[][] information = new int[6][3];
			permutations = new int[6][5];
			copiedPermutations = new int[6][5];
			possible = false;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 6; ++i) {
				for (int j = 0; j < 3; ++j) {
					information[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			boolean inputError = false;
			for (int i = 0; i < 6; ++i) {
				int count = 0;
				for (int j = 0; j < 3; ++j) {
					if (information[i][j] == 6) {
						inputError = true;
						break;
					}
					count += information[i][j];
				}
				if (count != 5) {
					inputError = true;
					break;
				}
			}
			
			if (inputError) {
				answer.append("0 ");
				continue;
			}
			
			for (int i = 0; i < 6; ++i) {
				// 이긴 것
				for (int j = 5 - information[i][0]; j < 5; ++j) {
					permutations[i][j] = 1;
				}
				
				// 진 것
				for (int j = 0; j < information[i][2]; ++j) {
					permutations[i][j] = -1;
				}
				copiedPermutations[i] = Arrays.copyOf(permutations[i], 5);
			}
			backTracking(0);
			answer.append(possible ? "1 " : "0 ");
		}
		System.out.println(answer);
		br.close();
	}
	
	private static void backTracking(int depth) {
		if (depth == 6) {
			possible = true;
			return;
		}
		copiedPermutations[depth] = Arrays.copyOf(permutations[depth], 5);
		do {
			if (depth == 0 || isPossiblePermutation(depth)) {
				backTracking(depth + 1);
			}
			if (possible) {
				return;
			}
		} while (nextPermutation(depth));
	}
	
	private static boolean isPossiblePermutation(int depth) {
		for (int i = 0; i < depth; ++i) {
			for (int j = i, opponent = i; j < depth; ++j, ++opponent) {
				if (opponent == i) {
					++opponent;
				}
				if (copiedPermutations[i][j] + copiedPermutations[opponent][i] != 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	private static boolean nextPermutation(int depth) {
		int length = 5;
		int i = length - 1;
		while (i > 0 && copiedPermutations[depth][i - 1] >= copiedPermutations[depth][i]) --i;
		if (i == 0) {
			return false;
		}
		
		int j = length - 1;
		while (copiedPermutations[depth][i - 1] >= copiedPermutations[depth][j]) --j;
		
		swap(depth, i - 1, j);
		
		int k = length - 1;
		while (i < k) swap(depth, i++, k--);
		
		return true;
	}
	
	private static void swap(int depth, int i, int j) {
		int tmp = copiedPermutations[depth][i];
		copiedPermutations[depth][i] = copiedPermutations[depth][j];
		copiedPermutations[depth][j] = tmp;
	}
}