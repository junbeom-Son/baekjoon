import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		br.close();

		Queue<Integer> circle = new LinkedList<>();
		for (int i = 1; i <= n; ++i) {
			circle.offer(i);
		}
		
		String[] answers = new String[n];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < k - 1; ++j) {
				circle.offer(circle.poll());
			}
			answers[i] = String.valueOf(circle.poll());
		}
		StringBuilder answer = new StringBuilder();
		answer.append("<");
		answer.append(String.join(", ", answers));
		answer.append(">");
		System.out.println(answer);
	}
}