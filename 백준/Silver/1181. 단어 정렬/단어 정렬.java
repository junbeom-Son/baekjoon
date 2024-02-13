import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<String> pq = new PriorityQueue<>((s1, s2) -> {
			if (s1.length() == s2.length()) {
				return s1.compareTo(s2);
			}
			return s1.length() - s2.length();
		});
		Set<String> set = new HashSet<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; ++i) {
			set.add(br.readLine());
		}
		br.close();
		for (String input : set) {
			pq.offer(input);
		}
		StringBuilder answer = new StringBuilder();
		while (!pq.isEmpty()) {
			answer.append(pq.poll()).append("\n");
		}
		System.out.print(answer);
	}
}