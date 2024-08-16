import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();
		long[][] lengths = new long[N + 1][2];
		lengths[1][0] = 1;
		lengths[1][1] = 1;
		for (int i = 2; i <= N; ++i) {
			int order = i % 2;
			lengths[i][order] = lengths[i - 1][order];
			lengths[i][(order + 1) % 2] = lengths[i - 1][0] + lengths[i - 1][1];
		}
		System.out.println((lengths[N][0] + lengths[N][1]) * 2);
	}
}