import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();
		int[] prices = new int[N];
		for (int i = 0; i < prices.length; ++i) {
			prices[i] = Integer.parseInt(st.nextToken());
		}
		int maxProfit = 0;
		int minPrice = Integer.MAX_VALUE;
		for (int price : prices) {
			minPrice = Math.min(minPrice, price);
			maxProfit = Math.max(maxProfit, price - minPrice);
		}
		System.out.println(maxProfit);
	}
}