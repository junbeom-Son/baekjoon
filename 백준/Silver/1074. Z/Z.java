import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int R;
	static int C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		System.out.println(findLocation(0, 0, 0, 1 << N));
	}
	
	static long findLocation(long firstValue, int firstR, int firstC, int length) {
		long size = length * length;
		if (R == firstR && C == firstC) {
			return firstValue;
		}
		if (onUpperSide(firstR, length)) {
			if (onLeftSide(firstC, length)) {
				return findLocation(firstValue, firstR, firstC, length / 2);
			}
			return findLocation(firstValue + size / 4, firstR, (firstC + firstC + length) / 2, length / 2);
		}
		if (onLeftSide(firstC, length)) {
			return findLocation(firstValue + (2 * size / 4), (firstR + firstR + length) / 2, firstC, length / 2);
		}
		return findLocation(firstValue + (3 * size / 4), (firstR + firstR + length) / 2, (firstC + firstC + length) / 2, length / 2);
	}
	
	static boolean onUpperSide(int firstR, int length) {
		return R < (firstR + firstR + length) / 2;
	}
	
	static boolean onLeftSide(int firstC, int length) {
		return C < (firstC + firstC + length) / 2;
	}
}