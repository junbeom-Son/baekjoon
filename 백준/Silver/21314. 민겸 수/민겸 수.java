import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		char[] minKyeom = br.readLine().toCharArray(); 
		br.close();
		int lastKIndex = -1;
		for (int i = 0; i < minKyeom.length; ++i) {
			if (minKyeom[i] == 'K') {
				answer.append("5");
				int zeroCount = i - (lastKIndex + 1);
				for (int j = 0; j < zeroCount; ++j) {
					answer.append("0");
				}
				lastKIndex = i;
			}
		}
		if (lastKIndex != minKyeom.length - 1) {
			answer.append("1");
			int oneCount = minKyeom.length - (lastKIndex + 1) - 1;
			for (int j = 0; j < oneCount; ++j) {
				answer.append("1");
			}
		}
		answer.append("\n");
		boolean lastK = true;
		for (char c : minKyeom) {
			if (c == 'M') {
				if (lastK) {
					answer.append("1");
				} else {
					answer.append("0");
				}
				lastK = false;
			} else {
				lastK = true;
				answer.append("5");
			}
		}
		System.out.println(answer);
	}
}
