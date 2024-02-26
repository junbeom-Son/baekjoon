import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<List<Integer>> positions = new LinkedList<>();
		StringTokenizer st;
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			positions.add(new LinkedList<>());
			positions.get(i).add(Integer.parseInt(st.nextToken()));
			positions.get(i).add(Integer.parseInt(st.nextToken()));
		}
		br.close();
		resetPosition(positions);
		// 처음으로 y좌표가 증가 하는 순으로 설정 -> 마지막 좌표는 무조건 좌로 가는 것.
		int start = 0, end = 0;
		List<Peek> peeks = new ArrayList<>();
		for (int i = 1; i < N; ++i) {
			int y1 = positions.get(i - 1).get(1);
			int y2 = positions.get(i).get(1);
			if (y1 < 0 && 0 < y2) { // 봉우리 시작
				start = positions.get(i).get(0);
			} else if (y2 < 0 && 0 < y1) { // 봉우리 끝
				end = positions.get(i).get(0);
				if (start < end) {
					peeks.add(new Peek(start, end));
				} else {
					peeks.add(new Peek(end, start));
				}
			}
		}
		int notIncluded = 0;
		int notInclude = 0;
		peeks.sort((a, b) -> {
			return Integer.compare(a.start, b.start);
		});
		int maxFinished = Integer.MIN_VALUE;
		for (int i = 0; i < peeks.size(); ++i) {
			if (peeks.get(i).end > maxFinished) {
				++notIncluded;
				maxFinished = peeks.get(i).end;
			}
		}
		
		peeks.sort((a, b) -> {
			return Integer.compare(a.end, b.end);
		});
		int maxStarted = Integer.MIN_VALUE;
		for (int i = 0; i < peeks.size(); ++i) {
			if (peeks.get(i).start > maxStarted) {
				++notInclude;
				maxStarted = peeks.get(i).start;
			}
		}
		System.out.println(notIncluded + " " + notInclude);
	}

	private static void resetPosition(List<List<Integer>> positions) {
		while (true) {
			int y1 = positions.get(0).get(1);
			int y2 = positions.get(1).get(1);
			if (y1 < 0 && 0 < y2) {
				break;
			}
			positions.add(positions.remove(0));
		}
	}
}

class Peek {
	int start;
	int end;
	public Peek(int start, int end) {
		this.start = start;
		this.end = end;
	}
}