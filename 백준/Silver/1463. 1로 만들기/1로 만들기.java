import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		br.close();
		int[] numbers = new int[] { 2, 3 };
		int[] counts = new int[X + 1];
		for (int i = X -1; i > 0; --i) {
			counts[i] = counts[i + 1] + 1;
			for (int number : numbers) {
				if (i * number <= X) {
					counts[i] = Math.min(counts[i], counts[i * number] + 1);
				}
			}
		}
		System.out.println(counts[1]);
	}
}