import java.util.*;
import java.io.*;

public class Main {
	
	static char[] input;
	
	static int findIndex(int start, int end) {
		List<Integer> minCharIndices = new ArrayList<>();
		int count = 0;
		char minChar = input[start];
		int index = start;
		for (int i = start; i < end; ++i) {
			if (input[i] == minChar) {
				++count;
				minCharIndices.add(i);
			} else if (input[i] < minChar) {
				minChar = input[i];
				count = 1;
				index = i;
				minCharIndices.clear();
				minCharIndices.add(i);
			}
		}
		
		if (count == 1) {
			return index;
		}
		int endCount = input.length - start;
		for (int i = 1; i < minCharIndices.size(); ++i) {
			int start1 = index;
			int end1 = start;
			int start2 = minCharIndices.get(i);
			int end2 = start;
			int p1 = start1;
			int p2 = start2;
			
			count = 0;
			while (count < endCount) {
				if (p1 < end1) {
					end1 = start1 + 1;
					start1 = findIndex(start1 + 1, end + 1);
					p1 = start1;
				}
				if (p2 < end2) {
					end2 = start2 + 1;
					start2 = findIndex(start2 + 1, end + 1);
					p2 = start2;
				}
				if (input[p1] < input[p2]) {
					break;
				} else if (input[p2] < input[p1]) {
					index = minCharIndices.get(i);
					break;
				}
				--p1;
				--p2;
				++count;
			}
		}
		
		return index;
	}
	
	static void generateAnswer(StringBuilder answer, int start, int end) {
		for (int i = start; i >= end; --i) {
			answer.append(input[i]);
		}
	}
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine().toCharArray();
		br.close();
		int firstIndex = findIndex(0, input.length - 2);
		int secondIndex = findIndex(firstIndex + 1, input.length - 1);
		StringBuilder answer = new StringBuilder();
		generateAnswer(answer, firstIndex, 0);
		generateAnswer(answer, secondIndex, firstIndex + 1);
		generateAnswer(answer, input.length - 1, secondIndex + 1);
		System.out.println(answer);
	}
}