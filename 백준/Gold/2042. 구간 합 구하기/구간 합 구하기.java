import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// n개의 숫자 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder result = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int startIndex = getStartIndex(n);
		
		// 리프 노드 입력 및 세그먼트 트리 초기화
		long[] numbers = new long[startIndex * 2];
		for (int i = 0; i < n; ++i) {
		    numbers[i + startIndex] = Long.parseLong(br.readLine());
		}
		for (int i = startIndex - 1; i > 0; --i) {
		    numbers[i] = numbers[i * 2] + numbers[i * 2 + 1];
		}
		
		// 숫자를 변경하거나, 구간 합을 구하기
		for (int i = 0; i < m + k; ++i) {
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    long c = Long.parseLong(st.nextToken());
		    b = convertToStartIndex(startIndex, b);
		    if (a == 1) { // b 번째 숫자를 c로 변경하기
		        numbers[b] = c;
		        b /= 2;
		        while (b > 0) {
		            numbers[b] = numbers[b * 2] + numbers[b * 2 + 1];
		            b /= 2;
		        }
		    } else { // b 번째 부터 c 번째 숫자까지 구간 합 구하기
		        int start = b;
		        int end = convertToStartIndex(startIndex, (int) c);
		        long answer = 0L;
		        while (start <= end) {
		            if (start % 2 == 1) {
		                answer += numbers[start];
		            }
		            if (end % 2 == 0) {
		                answer += numbers[end];
		            }
		            start = (start + 1) / 2;
		            end = (end - 1) / 2;
		        }
		        result.append(answer).append('\n');
		    }
		}
		System.out.println(result);
		br.close();
	}
	
	private static int getStartIndex(int n) {
	    int startIndex = 2;
	    while (startIndex < n) {
	        startIndex *= 2;
	    }
	    return startIndex;
	}
	
	private static int convertToStartIndex(int startIndex, int index) {
	    return startIndex + index - 1;
	}
}