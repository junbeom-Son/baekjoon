import java.io.*;
import java.util.*;

public class Main {
	
	static int L;
	static int C;
	static char[] characters;
	static char[] candidate;
	static Set<Character> vowels = new HashSet<>();
	static StringBuilder answer = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		br.close();
		characters = new char[C];
		candidate = new char[L];
		for (int i = 0; i < C; ++i) {
			characters[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(characters);
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		dfs(0, 0);
		System.out.print(answer);
	}
	
	private static void dfs(int depth, int index) {
		if (depth == L) {
			int vowel = 0;
			int consonant = 0;
			StringBuilder tmp = new StringBuilder();
			for (char c : candidate) {
				if (vowels.contains(c)) {
					++vowel;
				} else {
					++consonant;
				}
				tmp.append(c);
			}
			if (vowel >= 1 && consonant >= 2) {
				answer.append(tmp).append("\n");
			}
			return;
		}
		for (int i = index; i < C; ++i) {
			candidate[depth] = characters[i];
			dfs(depth + 1, i + 1);
		}
	}
}