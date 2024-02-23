import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		br.close();
		for (int i = 0; i < N; ++i) {
			if (isConstructor(i, N)) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
	}
	
	private static boolean isConstructor(int number, int N) {
		int base = number;
		while (number > 0) {
			base += number % 10;
			number /= 10;
		}
		return base == N;
	}
}