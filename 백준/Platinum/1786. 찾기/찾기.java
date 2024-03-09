import java.io.*;
import java.util.*;

public class Main {
	static List<Integer> answers = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] T = br.readLine().toCharArray();
		char[] P = br.readLine().toCharArray();
		br.close();
		int[] pi = getPi(P);
		kmp(T, P, pi);
		StringBuilder answer = new StringBuilder();
		answer.append(answers.size()).append("\n");
		for (int index : answers) {
			answer.append(index).append("\n");
		}
		System.out.print(answer);
	}
	
	private static int[] getPi(char[] p) {
		int[] pi = new int[p.length];
		int j = 0;
		for (int i = 1; i < pi.length; ++i) {
			while (j > 0 && p[i] != p[j]) {
				j = pi[j - 1];
			}
			if (p[i] == p[j]) {
				pi[i] = ++j;
			}
		}
		return pi;
	}
	
	private static void kmp(char[] T, char[] P, int[] pi) {
		int n = T.length;
		int m = P.length;
		int j = 0;
		for (int i = 0; i < n; ++i) {
			while (j > 0 && T[i] != P[j]) {
				j = pi[j - 1];
			}
			if (T[i] == P[j]) {
				if (j == m - 1) {
					answers.add(i + 1 - j);
					j = pi[j];
				} else {
					++j;
				}
			}
		}
	}
}