import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] storages = new int[N];
		Set<Integer> uniqueStorage = new HashSet<>();
		for (int i = 0; i < N; ++i) {
			storages[i] = Integer.parseInt(br.readLine());
			uniqueStorage.add(storages[i]);
		}
		int answer = 1;
		for (int target : uniqueStorage) {
			int count = 1;
			int lastStorage = -1;
			for (int i = 0; i < N; ++i) {
				if (storages[i] == target) {
					continue;
				}
				if (lastStorage != storages[i]) {
					answer = Math.max(answer, count);
					count = 1;
					lastStorage = storages[i];
				} else {
					++count;
				}
			}
			answer = Math.max(answer, count);
		}
		System.out.println(answer);
		br.close();
	}
}