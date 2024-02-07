import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		boolean[][] board = new boolean[100][100];
		for (int paper = 0; paper < n; ++paper) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int i = 0; i < 10; ++i) {
				for (int j = 0; j < 10; ++j) {
					board[i + x][j + y] = true;
				}
			}
		}
		int count = 0;
		for (int i = 0; i < 100; ++i) {
			for (int j = 0; j < 100; ++j) {
				if (board[i][j]) {
					++count;
				}
			}
		}
		System.out.println(count);
	}
}