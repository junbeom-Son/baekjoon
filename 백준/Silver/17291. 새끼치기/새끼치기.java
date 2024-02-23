import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();
		int[] birth = new int[N + 5];
		int count = 0;
		birth[1] = 1;
		count = 1;
		for (int i = 2; i <= N; ++i) {
			birth[i] = count;
			count *= 2;
			if (i % 2 == 0) {
				if (i > 3) {
					count -= birth[i - 3];
				}
				if (i > 5) {
					count -= birth[i - 4];
				}
			}
			
		}
		System.out.println(count);
	}
}