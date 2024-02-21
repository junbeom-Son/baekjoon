import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] group;
	static Set<Integer> set1 = new HashSet<>();
	static Set<Integer> set2 = new HashSet<>();
	static int[] counts;
	static List<List<Integer>> neighbors = new ArrayList<>();
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		group = new int[N + 1];
		counts = new int[N + 1];
		for (int i = 1; i <= N; ++i) {
			group[i] = i;
			counts[i] = Integer.parseInt(st.nextToken());
			set1.add(i);
		}
		for (int i = 0; i <= N; ++i) {
			neighbors.add(new ArrayList<>());
		}
		for (int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int count = Integer.parseInt(st.nextToken());
			while (st.hasMoreTokens()) {
				neighbors.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}
		br.close();
		dfs(1);
		if (answer == Integer.MAX_VALUE) {
			answer = -1;
		}
		System.out.println(answer);
	}
	
	private static void dfs(int number) {
		if (number > N) {
			if (set1.isEmpty() || set2.isEmpty()) {
				return;
			}
			if (!isSameGroup(set1) || !isSameGroup(set2)) {
				return;
			}
			getDifference();
			return;
		}
		dfs(number + 1);
		set1.remove(number);
		set2.add(number);
		dfs(number + 1);
		set2.remove(number);
		set1.add(number);
	}
	
	private static boolean isSameGroup(Set<Integer> group) {
		int firstNode = -1;
		for (int node : group) {
			firstNode = node;
			break;
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.add(firstNode);
		Set<Integer> checkGroup = new HashSet<>();
		checkGroup.add(firstNode);
		while (!queue.isEmpty()) {
			int node = queue.remove();
			for (int neighbor : neighbors.get(node)) {
				if (group.contains(neighbor) && !checkGroup.contains(neighbor)) {
					checkGroup.add(neighbor);
					queue.add(neighbor);
				}
			}
		}
		return group.size() == checkGroup.size();
	}
	
	private static void getDifference() {
		int group1 = getTotal(set1);
		int group2 = getTotal(set2);
		
		answer = Math.min(answer, Math.abs(group1 - group2));
	}
	
	private static int getTotal(Set<Integer> group) {
		int total = 0;
		for (int area : group) {
			total += counts[area];
		}
		return total;
	}
}