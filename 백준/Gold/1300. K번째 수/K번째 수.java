import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int start = 1, end = k;
		int answer = 0;
		while(start <= end) {
			int mid = (start + end) / 2;
			int count = 0;
			for(int i = 1; i <= n; i++) {
				count += Math.min(mid / i, n);
			}
			if(count < k) {
				start = mid + 1;
			}
			else {
				end = mid - 1;
				answer = mid;
			}
		}
		System.out.println(answer);
		sc.close();
	}	
}