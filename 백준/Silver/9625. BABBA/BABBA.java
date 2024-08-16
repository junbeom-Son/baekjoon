import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		br.close();
		int[][] counts = new int[K + 1][2];
		counts[0][0] = 1;
		for (int i = 1; i <= K; ++i) {
			counts[i][0] = counts[i - 1][1];
			counts[i][1] = counts[i - 1][0] + counts[i - 1][1];
		}
		System.out.println(counts[K][0] + " " + counts[K][1]);
	}
}