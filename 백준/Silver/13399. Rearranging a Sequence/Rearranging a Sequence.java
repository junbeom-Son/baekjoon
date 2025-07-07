import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer input = new StringTokenizer(br.readLine(), " ");
    	int n = Integer.parseInt(input.nextToken());
    	int m = Integer.parseInt(input.nextToken());
    	Deque<Integer> numbers = new ArrayDeque<>();
    	for (int i = 1; i <= n; ++i) {
    		numbers.addLast(i);
    	}
    	for (int i = 0; i < m; ++i) {
    		numbers.addFirst(Integer.parseInt(br.readLine()));
    	}
    	br.close();
    	
    	String result = getResult(numbers);
    	System.out.println(result);
    }
    
    private static String getResult(Deque<Integer> numbers) {
    	StringBuilder result = new StringBuilder();
    	Set<Integer> usedNumbers = new HashSet<>();
        while (!numbers.isEmpty()) {
        	int number = numbers.pollFirst();
        	if (!usedNumbers.contains(number)) {
        		result.append(number).append("\n");
        		usedNumbers.add(number);
        	}
    	}
    	return result.toString();
    }
}