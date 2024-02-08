import java.io.*;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st;
		for (int i = 0; i < 3; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			StringTokenizer timeSt = new StringTokenizer(st.nextToken(), ":");
			int h1 = Integer.parseInt(timeSt.nextToken());
			int m1 = Integer.parseInt(timeSt.nextToken());
			int s1 = Integer.parseInt(timeSt.nextToken());
			timeSt = new StringTokenizer(st.nextToken(), ":");
			int h2 = Integer.parseInt(timeSt.nextToken());
			int m2 = Integer.parseInt(timeSt.nextToken());
			int s2 = Integer.parseInt(timeSt.nextToken());
			int count = 0;
			if (h1 > h2 || (h1 == h2 && m1 > m2) || (h1 == h2 && m1 == m2 && s1 > s2)) {
				count = getCount(h1, m1, s1, 23, 59, 59);
				h1 = 0;
				m1 = 0;
				s1 = 0;
			}
			count += getCount(h1, m1, s1, h2, m2, s2);
			answer.append(count).append("\n");
		}
		br.close();
		System.out.println(answer);
	}
	
	private static int getCount(int h1, int m1, int s1, int h2, int m2, int s2) {
		int count = 0;
		int time2 = h2 * 10000 + m2 * 100 + s2;
		for (; h1 < 24; ++h1) {
			for (; m1 < 60; ++m1) {
				for (; s1 < 60; ++s1) {
					int time1 = h1 * 10000 + m1 * 100 + s1; 
					if (time1 > time2) {
						break;
					}
					if (time1 % 3 == 0) {
						++count;
					}
				}
				s1 = 0;
			}
			m1 = 0;
		}
		return count;
	}
}