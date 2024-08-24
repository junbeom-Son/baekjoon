import java.io.*;
import java.util.*;

public class KMP {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] T = br.readLine().toCharArray();
		char[] P = br.readLine().toCharArray();
		br.close();
		List<Integer> answers = kmp(T, P);
		StringBuilder answer = new StringBuilder();
		answer.append(answers.size()).append("\n");
		for (int index : answers) {
			answer.append(index).append("\n");
		}
		System.out.print(answer);
	}
	
	private static int[] getPi(char[] P) {
		int[] pi = new int[P.length];
		int j = 0;
		for (int i = 1; i < pi.length; ++i) {
			while (j > 0 && pi[i] != pi[j]) {
				j = pi[j - 1];
			}
			if (P[i] == P[j]) {
				pi[i] = ++j;
			}
		}
		
		return pi;
	}
	
	private static List<Integer> kmp(char[] T, char[] P) {
		List<Integer> answers = new ArrayList<>();
		int[] pi = getPi(P);
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
				} else{
					++j;
				}
			}
		}
		return answers;
	}
}
