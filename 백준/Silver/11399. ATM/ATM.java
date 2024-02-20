import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();
		int[] people = new int[N];
		for (int i = 0; i < N; ++i) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(people);
		int answer = 0;
		for (int i = 1; i < N; ++i) {
			people[i] += people[i - 1];
		}
		for (int person : people) {
			answer += person;
		}
		System.out.println(answer);
	}
}