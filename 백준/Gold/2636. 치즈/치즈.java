import java.util.*;
import java.io.*;

public class Main {
	
	static int[] dx = new int[] { -1, 1, 0, 0 };
	static int[] dy = new int[] { 0, 0, -1, 1 };
    static int[][] cheese;
    static int n;
    static int m;
    static boolean[][] checked;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	cheese = new int[n][m];
    	for (int i = 0; i < n; ++i) {
    		st = new StringTokenizer(br.readLine(), " ");
    		for (int j = 0; j < m; ++j) {
    			cheese[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
		br.close();
		int count = 0;
		for (int i = 1; i < n - 1; ++i) {
    		for (int j = 1; j < m - 1; ++j) {
    			if (cheese[i][j] == 1) {
    				++count;
    			}
    		}
    	}
		int answer = count;
		int time = 0;
		while (count > 0) {
			List<int[]> toBeDeleted = findToBeDeleted();
			answer = count;
			for (int[] position : toBeDeleted) {
				cheese[position[0]][position[1]] = 0;
				--count;
			}
			++time;
		}
		System.out.println(time);
		System.out.println(answer);
	}
    
    static List<int[]> findToBeDeleted() {
    	List<int[]> deleted = new ArrayList<>();
    	checked = new boolean[n][m];
		Queue<int[]> airQueue = new LinkedList<>();
		airQueue.add(new int[] { 0, 0 });
		checked[0][0] = true;
		while (!airQueue.isEmpty()) {
			int[] position = airQueue.remove();
			for (int d = 0; d < 4; ++d) {
				int x = position[0] + dx[d];
				int y = position[1] + dy[d];
				if (!(0 <= x && x < n && 0 <= y && y < m) || checked[x][y]) {
					continue;
				}
				checked[x][y] = true;
				if (cheese[x][y] == 0) {
					airQueue.add(new int[] { x, y });
				} else {
					deleted.add(new int[] { x, y });
				}
			}
		}
		return deleted;
    }
}