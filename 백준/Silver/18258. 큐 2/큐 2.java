import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> queue = new ArrayDeque<>();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();
			if (st.hasMoreTokens()) {
				queue.add(Integer.parseInt(st.nextToken()));
			} else if (command.charAt(0) == 'p') {
				if (queue.isEmpty()) {
					answer.append("-1\n");
				} else {
					answer.append(queue.pop()).append("\n");
				}
			} else if (command.charAt(0) == 's') {
				answer.append(queue.size()).append("\n");
			} else if (command.charAt(0) == 'e') {
				answer.append(queue.isEmpty() ? "1\n" : "0\n");
			} else if (command.charAt(0) == 'f') {
				if (queue.isEmpty()) {
					answer.append("-1\n");
				} else {
					answer.append(queue.getFirst()).append("\n");
				}
			} else {
				if (queue.isEmpty()) {
					answer.append("-1\n");
				} else {
					answer.append(queue.getLast()).append("\n");
				}
			}
		}
		br.close();
		System.out.println(answer);
	}
}