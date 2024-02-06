import java.util.*;
import java.io.*;

public class Main {
	
	static int[] groups;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int[] origins = new int[k];
		for (int i = 0; i < k; ++i) {
			origins[i] = Integer.parseInt(st.nextToken());
		}
		PriorityQueue<Edge> edges = new PriorityQueue<>();
		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edges.add(new Edge(u, v, w));
		}
		br.close();
		// 입력 종료
		
		groups = new int[n + 1];
		for (int i = 1; i <= n; ++i) {
			groups[i] = i;
		}
		
		for (int origin : origins) {
			groups[origin] = 0;
		}
		
		int count = k;
		int answer = 0;
		while (count < n) {
			Edge edge = edges.poll();
			int node1 = find(edge.node1);
			int node2 = find(edge.node2);
			if (node1 == node2) {
				continue;
			}
			if (node1 < node2) {
				groups[node2] = groups[node1];
			} else {
				groups[node1] = groups[node2];
			}
			++count;
			answer += edge.cost;
		}
		
		System.out.println(answer);
	}
	
	static int find(int number) {
		if (groups[number] != number) {
			groups[number] = find(groups[number]);
		}
		return groups[number];
	}
}

class Edge implements Comparable<Edge> {
	int node1;
	int node2;
	int cost;
	
	Edge(int node1, int node2, int cost) {
		this.node1 = node1;
		this.node2 = node2;
		this.cost = cost;
	}
	
	public int compareTo(Edge otherEdge) {
		return cost - otherEdge.cost;
	}
}