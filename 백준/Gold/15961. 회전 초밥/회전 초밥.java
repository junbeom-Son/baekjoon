import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int d;
	static int c;
	static int k;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int[] costs = new int[N + k - 1];
		for (int i = 0; i < N; ++i) {
			costs[i + k - 1] = Integer.parseInt(br.readLine());
		}
		br.close();
		for (int i = 1; i < k; ++i) {
			costs[k - i - 1] = costs[N + k - 1 - i];
		}
		
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < k - 1; ++i) {
			map.put(costs[i], map.getOrDefault(costs[i], 0) + 1);
		}
		
		int answer = 0;
		
		for (int i = k - 1; i < N + k - 1; ++i) {
			map.put(costs[i], map.getOrDefault(costs[i], 0) + 1);
			map.put(c, map.getOrDefault(c, 0) + 1);
			answer = Math.max(answer, map.size());
			map.put(c, map.get(c) - 1);
			map.put(costs[i - k + 1], map.get(costs[i - k + 1]) - 1);
			if (map.get(costs[i - k + 1]) == 0) {
				map.remove(costs[i - k + 1]);
			}
		}
		System.out.println(answer);
	}
	
	
}