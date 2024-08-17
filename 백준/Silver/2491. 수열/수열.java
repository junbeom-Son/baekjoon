import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();
		int[] numbers = new int[N];
		for (int i = 0; i < N; ++i) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		int prevNumber = 100;
		int length = 0;
		int maxLength = 0;
		for (int number : numbers) {
			if (number >= prevNumber) {
				++length;
			} else {
				maxLength = Math.max(maxLength, length);
				length = 1;
			}
			prevNumber = number;
		}
		maxLength = Math.max(maxLength, length);
		length = 0;
		prevNumber = -1;
		for (int number : numbers) {
			if (number <= prevNumber) {
				++length;
			} else {
				maxLength = Math.max(maxLength, length);
				length = 1;
			}
			prevNumber = number;
		}
		maxLength = Math.max(maxLength, length);
		System.out.println(maxLength);
	}
}