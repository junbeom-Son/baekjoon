import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		double[] numbers = new double[N + 1];
		for (int i = 1; i <= N; ++i) {
			numbers[i] = Double.parseDouble(br.readLine());
		}
		br.close();
		double maxValue = 0;
		double curValue = 0;
		for (int i = 1; i <= N; ++i) {
			if (curValue < 1) {
				curValue = numbers[i];
			} else {
				curValue *= numbers[i];
			}
			maxValue = Math.max(maxValue, curValue);
		}
		System.out.println(String.format("%.3f", maxValue));
	}
}