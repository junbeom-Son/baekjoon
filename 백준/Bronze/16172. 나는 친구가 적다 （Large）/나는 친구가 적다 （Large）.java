import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String messedS = br.readLine();
		char[] K = br.readLine().toCharArray();
		br.close();
		char[] S = removeNumbers(messedS);
		System.out.println(kmp(S, K) ? "1" : "0");
	}
	
	private static boolean kmp(char[] S, char[] K) {
		int[] pi = getPI(K);
		int n = S.length;
		int m = K.length;
		int j = 0;
		for (int i = 0; i < n; ++i) {
			while (j > 0 && S[i] != K[j]) {
				j = pi[j - 1];
			}
			if (S[i] == K[j]) {
				if (j == m - 1) {
					return true;
				}
				++j;
			}
		}
		
		return false;
	}
	
	private static int[] getPI(char[] K) {
		int[] pi = new int[K.length];
		int j = 0;
		for (int i = 1; i < K.length; ++i) {
			while (j > 0 && K[i] != K[j]) {
				j = pi[j - 1];
			}
			if (K[i] == K[j]) {
				pi[i] = ++j;
			}
		}
		
		return pi;
	}
	
	private static char[] removeNumbers(String messedS) {
		StringBuilder S = new StringBuilder();
		for (int i = 0; i < messedS.length(); ++i) {
			if (!Character.isDigit(messedS.charAt(i))) {
				S.append(messedS.charAt(i));
			}
		}
		return S.toString().toCharArray();
	}
}