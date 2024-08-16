import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		int[] counts = new int[] { 3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1 };
		char base = 'A';
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		String B = br.readLine();
		br.close();
		List<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < A.length(); ++i) {
			numbers.add(counts[A.charAt(i) - base]);
			numbers.add(counts[B.charAt(i) - base]);
		}
		while (numbers.size() > 2) {
			List<Integer> tmp = new ArrayList<>();
			for (int i = 1; i < numbers.size(); ++i) {
				tmp.add((numbers.get(i - 1) + numbers.get(i)) % 10);
			}
			numbers = tmp;
		}
		
		System.out.println(new StringBuilder().append(numbers.get(0)).append(numbers.get(1)));
	}
}