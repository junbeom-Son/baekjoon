import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		br.close();
		int[] S = new int[N];
		for (int i = 0; i < N; ++i) {
			S[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0;
		for (int i = 0; i < N; ++i) {
			if (S[i] % 2 == 0) {
				start = i;
				break;
			}
		}
		if (start == 0 && S[0] % 2 != 0) {
			System.out.println(0);
			return;
		}
		int last = 0;
		List<List<Integer>> consecutiveCounts = new ArrayList<>();
		consecutiveCounts.add(new ArrayList<>());
		consecutiveCounts.add(new ArrayList<>());
		int count = 0;
		for (int i = start; i < N; ++i) {
			if (S[i] % 2 == last) {
				++count;
			} else {
				consecutiveCounts.get(last).add(count);
				count = 1;
				last = S[i] % 2;
			}
		}
		consecutiveCounts.get(last).add(count);
		consecutiveCounts.get(1).add(0);
		int answer = 0;
		for (int i = 0; i < consecutiveCounts.get(0).size(); ++i) {
			int length = 0;
			int delete = 0;
			for (int j = i; j < consecutiveCounts.get(0).size() && delete <= K; ++j) {
				length += consecutiveCounts.get(0).get(j);
				delete += consecutiveCounts.get(1).get(j);
			}
			answer = Math.max(answer, length);
		}
		System.out.println(answer);
	}
}