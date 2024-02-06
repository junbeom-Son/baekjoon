import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		StringBuilder answer = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<Character> operators = new HashSet<>();
		operators.add('*');
		operators.add('+');
		operators.add('/');
		operators.add('-');
		for (int t = 1; t <= 10; ++t) {
			answer.append("#").append(t).append(" ");
			int n = Integer.parseInt(br.readLine());
			boolean possible = true;
			for (int i = 0; i < n; ++i) {
				String[] inputs = br.readLine().split(" ");
				if (inputs.length == 3) {
					possible = false;
				} else if (inputs.length == 2) {
					if (operators.contains(inputs[1].charAt(0))) {
						possible = false;
					}
				} else if (inputs.length == 4) {
					if (!operators.contains(inputs[1].charAt(0))) {
						possible = false;
					}
					for (int j = 2; j < 4; ++j) {
						if (operators.contains(inputs[j].charAt(0))) {
							possible = false;
						}
					}
				}
			}
			answer.append(possible ? "1\n" : "0\n");
		}
		br.close();
		System.out.println(answer);
	}
}