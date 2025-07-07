import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int[] numbers = new int[N + 2];
    	numbers[0] = -1;
    	numbers[N + 1] = Integer.MAX_VALUE;
    	for (int i = 1; i <= N; ++i) {
    		numbers[i] = Integer.parseInt(br.readLine());
    	}
    	br.close();
    	
    	Arrays.sort(numbers);
    	int answer = 0;
    	for (int i = 1; i <= N - 2; ++i) {
    		for (int j = i + 1; j <= N - 1; ++j) {
    			int diff = numbers[j] - numbers[i];
    			int left = numbers[j] + diff;
    			int right = left + diff;
    			int leftMinIndex = getCeilIndex(numbers, left);
    			int rightMaxIndex = getFloorIndex(numbers, right);
    			if (rightMaxIndex == N + 1) {
    				--rightMaxIndex;
    			}
    			if (leftMinIndex == 0) {
    				++leftMinIndex;
    			}
    			if (leftMinIndex > rightMaxIndex) {
    				continue;
    			}
    			answer += (rightMaxIndex - leftMinIndex) + 1;
    		}
    	}
    	System.out.println(answer);
    }
    
    private static int getCeilIndex(int[] numbers, int number) {
    	int left = 0;
    	int right = numbers.length - 1;
    	int index = 0;
    	while (left <= right) {
    		int mid = (left + right) / 2;
    		int midNumber = numbers[mid];
    		if (midNumber >= number) {
    			index = mid;
    			right = mid - 1;
    		} else {
    			left = mid + 1;
    		}
    	}
    	return index;
    }
    
    private static int getFloorIndex(int[] numbers, int number) {
    	int left = 0;
    	int right = numbers.length - 1;
    	int index = 0;
    	while (left <= right) {
    		int mid = (left + right) / 2;
    		int midNumber = numbers[mid];
    		if (midNumber <= number) {
    			index = mid;
    			left = mid + 1;
    		} else {
    			right = mid - 1;
    		}
    	}
    	
    	return index;
    }
}