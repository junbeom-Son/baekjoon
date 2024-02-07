import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Main {
	static int [][] map;
	static boolean[][] visited;
	static int n;
	static int m;
	static PriorityQueue<Edge> edges = new PriorityQueue<>();
	static int[] group;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int count = 0;
		int result = 0;
		map = new int[n][m];
		visited = new boolean[n][m];
		// 지도 정보 저장
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					count++;
					bfs(i, j, count);
				}
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] > 0) {
					findConnection(i, j, 0, map[i][j]);
					findConnection(i, j, 1, map[i][j]);
					findConnection(i, j, 2, map[i][j]);
					findConnection(i, j, 3, map[i][j]);
				}
			}
		}
		group = new int[count + 1];
		for(int i = 1; i <= count; i++) {
			group[i] = i;
		}
		
		
		for(int i = 0; i < count - 1;) {
			if(!edges.isEmpty()) {
				Edge edge = edges.poll();
				if(find(edge.v1) != find(edge.v2)) {
					union(group[edge.v1], group[edge.v2]);
					result += edge.cost;
					i++;
				}
			} else break;
		}
		boolean check = true;
		for(int i = 2; i <= count; i++) {
			if(find(1) != find(i)) {
				check = false;
				break;
			}
		}
		if(check) System.out.println(result);
		else System.out.println("-1");
	}
	
	static void union(int n1, int n2) {
		if(group[n1] < group[n2]) group[n2] = group[n1];
		else group[n1] = group[n2];
	}
	
	static int find(int n) {
		if(n != group[n]) {
			group[n] = find(group[n]);
		}
		return group[n];
	}
	
	static void findConnection(int h, int w, int direction, int islandNum) {
		int count = 0;
		if(direction == 0) { // 상
			for(int i = h - 1; i >= 0; i--, count++) {
				if(map[i][w] == islandNum) break;
				if(map[i][w] > 0) { // 다른 섬을 만났을 때
					if(count <= 1) break;
					else {
						edges.add(new Edge(islandNum, map[i][w], count));
						break;
					}
				}
			}
		} else if(direction == 1) { // 하
			for(int i = h + 1; i < n; i++, count++) {
				if(map[i][w] == islandNum) break;
				if(map[i][w] > 0) { // 다른 섬을 만났을 때
					if(count <= 1) break;
					else {
						edges.add(new Edge(islandNum, map[i][w], count));
						break;
					}
				}
			}
		} else if(direction == 2) { //좌
			for(int i = w - 1; i >= 0; i--, count++) {
				if(map[h][i] == islandNum) break;
				if(map[h][i] > 0) { // 다른 섬을 만났을 때
					if(count <= 1) break;
					else {
						edges.add(new Edge(islandNum, map[h][i], count));
						break;
					}
				}
			}
		} else { //우
			for(int i = w + 1; i < m; i++, count++) {
				if(map[h][i] == islandNum) break;
				if(map[h][i] > 0) { // 다른 섬을 만났을 때
					if(count <= 1) break;
					else {
						edges.add(new Edge(islandNum, map[h][i], count));
						break;
					}
				}
			}
		}
	}
	
	static void bfs(int h, int w, int num) {
		if(h < 0 || w < 0 || h == n || w == m) return;
		if(map[h][w] == 1 && !visited[h][w]) {
			visited[h][w] = true;
			map[h][w] = num;
			bfs(h - 1, w, num);
			bfs(h, w - 1, num);
			bfs(h + 1, w, num);
			bfs(h, w + 1, num);
		}
		
	}	
}

class Edge implements Comparable<Edge>{
	int v1, v2, cost;
	Edge(int v1, int v2, int cost){
		this.v1 = v1;
		this.v2 = v2;
		this.cost = cost;
	}
	@Override
	public int compareTo(Edge e) {
		return this.cost - e.cost;
	}
}