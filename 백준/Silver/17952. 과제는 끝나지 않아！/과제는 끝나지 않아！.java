import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Work> works = new Stack<>();
		StringTokenizer st;
		Work currentWork = null;
		int totalScore = 0;
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int type = Integer.parseInt(st.nextToken());
			if (type == 0) {
				if (currentWork != null) {
					--currentWork.leftTime;
					if (currentWork.leftTime == 0) {
						totalScore += currentWork.score;
						currentWork = null;
						if (!works.isEmpty()) {
							currentWork = works.pop();
						}
					}
				}
			} else {
				int score = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				if (time == 1) {
					totalScore += score;
					continue;
				}
				
				if (currentWork != null) {
					works.add(currentWork);
				}
				
				currentWork = new Work(score, time - 1);
			}
		}
		br.close();
		System.out.println(totalScore);
	}

}

class Work {
	int score;
	int leftTime;
	public Work(int score, int leftTime) {
		this.score = score;
		this.leftTime = leftTime;
	}
}