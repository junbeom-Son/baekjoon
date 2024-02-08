import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		String number = br.readLine();
		br.close();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < n; ++i) {
			while (!stack.isEmpty() && k > 0 && stack.peek() < number.charAt(i)) {
				stack.pop();
				--k;
			}
			stack.add(number.charAt(i));
		}
		StringBuilder answer = new StringBuilder();
		while (!stack.isEmpty()) {
			answer.append(stack.pop());
		}
		answer = answer.reverse();
		answer.setLength(answer.length() - k);
		System.out.println(answer);
	}
}