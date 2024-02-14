import java.io.*;

public class Main {
	static char[][] video;
	static int N;
	static StringBuilder answer = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		video = new char[N][];
		for (int i = 0; i < N; ++i) {
			video[i] = br.readLine().toCharArray();
		}
		br.close();
		pressVideo(0, 0, N, N);
		System.out.println(answer);
	}
	
	private static void pressVideo(int x1, int y1, int x2, int y2) {
		if (isPressed(x1, y1, x2, y2)) {
			answer.append(video[x1][y1]);
			return;
		}
		answer.append("(");
		pressVideo(x1, y1, (x1 + x2) / 2, (y1 + y2) / 2);
		pressVideo(x1, (y1 + y2) / 2, (x1 + x2) / 2, y2);
		pressVideo((x1 + x2) / 2, y1, x2, (y1 + y2) / 2);
		pressVideo((x1 + x2) / 2, (y1 + y2) / 2, x2, y2);
		answer.append(")");
	}
	
	private static boolean isPressed(int x1, int y1, int x2, int y2) {
		char pixel = video[x1][y1];
		for (int i = x1; i < x2; ++i) {
			for (int j = y1; j < y2; ++j) {
				if (pixel != video[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}