import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long[][] triangle = new long[n + 1][n + 1];
		for (int i = 1; i <= n; ++i) {
			triangle[i][1] = 1;
			triangle[i][i] = 1;
		}
		if (k == 1 || k == n) {
			System.out.println(1);
			return;
		}
		for (int i = 3; i <= n; ++i) {
			for (int j = 2; j < n; ++j) {
				triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
			}
		}
		System.out.println(triangle[n][k]);
	}
}