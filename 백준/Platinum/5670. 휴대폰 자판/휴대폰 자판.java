import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		while (true) {
			String countInput = br.readLine();
			if (countInput == null || countInput.equals("")) {
				break;
			}
			int n = Integer.parseInt(countInput);
			String[] words = new String[n];
			for (int i = 0; i < n; ++i) {
				words[i] = br.readLine();
			}
			Dictionary root = new Dictionary(true);
			// 사전 초기화
			for (String word: words) {
				Dictionary last = root;
				for (int i = 0; i < word.length() - 1; ++i) {
					if (last.dictionary.get(word.charAt(i)) == null) {
						last.dictionary.put(word.charAt(i), new Dictionary(false));
					}
					last = last.dictionary.get(word.charAt(i));
				}
				if (last.dictionary.get(word.charAt(word.length() - 1)) == null) {
					last.dictionary.put(word.charAt(word.length() - 1), new Dictionary(true));
				}
				last = last.dictionary.get(word.charAt(word.length() - 1));
				last.isFinal = true;
			}
			
			int typeCount = 0;
			for (String word : words) {
				Dictionary last = root;
				for (char c : word.toCharArray()) {
					if (last.dictionary.size() > 1 || last.isFinal) {
						++typeCount;
					}
					last = last.dictionary.get(c);
				}
			}
			answer.append(String.format("%.2f", (double)typeCount / words.length)).append("\n");
		}
		br.close();
		System.out.print(answer);
	}
}

class Dictionary {
	boolean isFinal;
	Map<Character, Dictionary> dictionary = new HashMap<>();
	
	Dictionary(boolean isFinal) {
		this.isFinal = isFinal;
	}
}