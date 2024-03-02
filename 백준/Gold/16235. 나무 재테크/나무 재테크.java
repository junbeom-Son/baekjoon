import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] nutritionInfo, leftNutritions;
	static List<Tree> aliveTrees = new LinkedList<>();
	static List<Tree> nextRoundTrees = new LinkedList<>();
	static Queue<Tree> treesToBeDead = new LinkedList<>();
	static int[] dx = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		nutritionInfo = new int[N][N];
		leftNutritions = new int[N][N];
		for (int i = 0; i < N; ++i) {
			Arrays.fill(leftNutritions[i], 5);
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; ++j) {
				nutritionInfo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			aliveTrees.add(new Tree(Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())));
		}
		br.close();
		Collections.sort(aliveTrees);
		for (int i = 0; i < K; ++i) {
			springAndFall();
			summer();
			winter();
		}
		System.out.println(aliveTrees.size());
	}
	
	private static void springAndFall() {
		while (!aliveTrees.isEmpty()) {
			Tree tree = aliveTrees.remove(0);
			if (leftNutritions[tree.x][tree.y] < tree.age) {
				treesToBeDead.add(tree);
				continue;
			}
			leftNutritions[tree.x][tree.y] -= tree.age;
			++tree.age;
			nextRoundTrees.add(tree);
			if (tree.age % 5 == 0) {
				plantTree(tree);
			}
		}
		aliveTrees = nextRoundTrees;
		nextRoundTrees = new LinkedList<>();
	}
	
	private static void plantTree(Tree tree) {
		for (int i = 0; i < 8; ++i) {
			int nx = tree.x + dx[i];
			int ny = tree.y + dy[i];
			if (0 <= nx && nx < N && 0 <= ny && ny < N) {
				nextRoundTrees.add(0, new Tree(nx, ny, 1));
			}
		}
	}
	
	private static void summer() {
		while (!treesToBeDead.isEmpty()) {
			Tree tree = treesToBeDead.remove();
			leftNutritions[tree.x][tree.y] += (tree.age / 2);
		}
	}
	
	private static void winter() {
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				leftNutritions[i][j] += nutritionInfo[i][j];
			}
		}
	}
}

class Tree implements Comparable<Tree> {
	int x;
	int y;
	int age;
	
	public Tree(int x, int y, int age) {
		super();
		this.x = x;
		this.y = y;
		this.age = age;
	}



	@Override
	public int compareTo(Tree o) {
		return Integer.compare(this.age, o.age);
	}
}