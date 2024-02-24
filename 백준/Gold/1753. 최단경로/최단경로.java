import java.io.*;
import java.util.*;

public class Main {
	static int V, E, K;
	static List<List<int[]>> connected = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		for (int i = 0; i <= V; ++i) {
			connected.add(new ArrayList<>());
		}
		for (int i = 0; i < E; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			connected.get(u).add(new int[] { v, w });
		}
		br.close();
		int[] distances = new int[V + 1];
		Arrays.fill(distances, Integer.MAX_VALUE);
		distances[K] = 0;
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
		queue.add(new Edge(K, 0));
		while (!queue.isEmpty()) {
			Edge edge = queue.remove();
			if (distances[edge.node] < edge.distance) {
				continue;
			}
			for (int[] next : connected.get(edge.node)) {
				int nextNode = next[0];
				int nextDistance = next[1] + edge.distance;
				if (nextDistance < distances[nextNode]) {
					distances[nextNode] = nextDistance;
					queue.add(new Edge(nextNode, nextDistance));
				}
			}
		}
		StringBuilder answer = new StringBuilder();
		for (int i = 1; i <= V; ++i) {
			if (distances[i] == Integer.MAX_VALUE) {
				answer.append("INF\n");
			} else {
				answer.append(distances[i]).append("\n");
			}
		}
		System.out.print(answer);
	}
}

class Edge implements Comparable<Edge> {
	int node;
	int distance;
	
	public Edge(int node, int distance) {
		this.node = node;
		this.distance = distance;
	}

	@Override
	public int compareTo(Edge o) {
		return Integer.compare(this.distance, o.distance);
	}
}