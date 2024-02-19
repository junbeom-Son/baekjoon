import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static List<Set<Integer>> inBounds = new ArrayList<>();
	static List<Set<Integer>> outBounds = new ArrayList<>();
	static List<Set<Integer>> children = new ArrayList<>();
	static List<Set<Integer>> parents = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i <= N; ++i) {
			inBounds.add(new HashSet<>());
			outBounds.add(new HashSet<>());
			children.add(new HashSet<>());
			parents.add(new HashSet<>());
		}
		
		int[][] comparisons = new int[M][2];
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			comparisons[i][0] = Integer.parseInt(st.nextToken());
			comparisons[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < M; ++i) {
			int a = comparisons[i][0];
			int b = comparisons[i][1];
			inBounds.get(b).add(a);
			outBounds.get(a).add(b);
			children.get(b).add(a);
			parents.get(a).add(b);
		}
		
		br.close();
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; ++i) {
			if (inBounds.get(i).isEmpty()) {
				queue.add(i);
			}
		}
		
		while (!queue.isEmpty()) {
			int node = queue.remove();
			for (int parent : outBounds.get(node)) {
				children.get(parent).addAll(children.get(node));
				inBounds.get(parent).remove(node);
				if (inBounds.get(parent).isEmpty()) {
					queue.add(parent);
				}
			}
		}
		
		for (int i = 0; i < M; ++i) {
			int a = comparisons[i][0];
			int b = comparisons[i][1];
			inBounds.get(b).add(a);
		}
		
		for (int i = 1; i <= N; ++i) {
			if (outBounds.get(i).isEmpty()) {
				queue.add(i);
			}
		}
		
		while (!queue.isEmpty()) {
			int node = queue.remove();
			for (int child : inBounds.get(node)) {
				parents.get(child).addAll(parents.get(node));
				outBounds.get(child).remove(node);
				if (outBounds.get(child).isEmpty()) {
					queue.add(child);
				}
			}
		}
		
		int answer = 0;
		for (int i = 1; i <= N; ++i) {
			int childrenNumber = children.get(i).size();
			int parentsNumber = parents.get(i).size();
			if (childrenNumber + parentsNumber == N - 1) {
				++answer;
			}
		}
		System.out.println(answer);
	}
}