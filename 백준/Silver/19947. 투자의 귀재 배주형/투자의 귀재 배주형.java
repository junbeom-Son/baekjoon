import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();
		int H = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int[] money = new int[Y + 1];
		money[0] = H;
		int[] years = new int[] { 1, 3, 5 };
		double[] interests = new double[] { 1.05, 1.2, 1.35 };
		for (int i = 1; i <= Y; ++i) {
			for (int j = 0; j < interests.length; ++j) {
				int year = years[j];
				if (year > i) {
					break;
				}
				double interest = interests[j];
				long principal = money[i - year];
				money[i] = Math.max(money[i], (int) (principal * interest));
			}
		}
		System.out.println(money[Y]);
	}
}