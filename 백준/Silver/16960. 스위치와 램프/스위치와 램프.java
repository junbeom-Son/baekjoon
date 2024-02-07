import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		List<List<Integer>> switches = new ArrayList<>(N + 1);
		Map<Integer, Integer> lamps = new HashMap<>();
		for (int i = 0; i <= N; ++i) {
			switches.add(new ArrayList<>());
		}
		
		for (int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int count = Integer.parseInt(st.nextToken());
			for (int j = 0; j < count; ++j) {
				int lamp = Integer.parseInt(st.nextToken());
				switches.get(i).add(lamp);
				lamps.put(lamp, lamps.getOrDefault(lamp, 0) + 1);
			}
		}
		br.close();
		
		boolean canTurnOn = false;
		for (int i = 1; i <= N; ++i) {
			// turn off
			for (int lamp : switches.get(i)) {
				lamps.put(lamp, lamps.get(lamp) - 1);
				if (lamps.get(lamp) == 0) {
					lamps.remove(lamp);
				}
			}
			
			// check
			if (lamps.size() == M) {
				canTurnOn = true;
				break;
			}
			
			// recover
			for (int lamp : switches.get(i)) {
				lamps.put(lamp, lamps.getOrDefault(lamp, 0) + 1);
			}
		}
		
		System.out.println(canTurnOn ? "1" : "0");
	}
}