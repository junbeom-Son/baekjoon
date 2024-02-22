import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Map<String, Integer> nameToNumber = new HashMap<>();
		Map<Integer, String> numberToName = new HashMap<>();
		for (int i = 1; i <= n; ++i) {
			String name = br.readLine();
			nameToNumber.put(name, i);
			numberToName.put(i, name);
		}
		StringBuilder answer = new StringBuilder();
		for (int i = 0; i < m; ++i) {
			String query = br.readLine();
			try {
				int number = Integer.parseInt(query);
				answer.append(numberToName.get(number));
			} catch (NumberFormatException e) {
				answer.append(nameToNumber.get(query));
			}
			answer.append("\n");
		}
		br.close();
		System.out.print(answer);
	}
}