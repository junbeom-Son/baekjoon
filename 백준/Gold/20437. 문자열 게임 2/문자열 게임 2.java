import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for (int t = 0; t < T; ++t) {
			int maxValue = -1;
			int minValue = Integer.MAX_VALUE;
			Map<Character, List<Integer>> indices = new HashMap<>();
			char[] W = br.readLine().toCharArray();
			for (int i = 0; i < W.length; ++i) {
				if (indices.get(W[i]) == null) {
					indices.put(W[i], new ArrayList<>());
				}
				indices.get(W[i]).add(i);
			}
			int K = Integer.parseInt(br.readLine());
			for (char key : indices.keySet()) {
				List<Integer> list = indices.get(key);
				for (int i = K - 1; i < list.size(); ++i) {
					int length = list.get(i) - list.get(i - K + 1) + 1;
					maxValue = Math.max(maxValue, length);
					minValue = Math.min(minValue, length);
				}
			}
			if (maxValue == -1) {
				answer.append("-1\n");
			} else {
				answer.append(minValue).append(" ").append(maxValue).append("\n");
			}
		}
		br.close();
		System.out.print(answer);
	}
}