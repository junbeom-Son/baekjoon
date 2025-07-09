import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer input;
    	Map<Character, Integer> incorrectCounts = new HashMap<>();
    	int exitCondition = -1;
    	String correct = "right";
    	int score = 0;
    	int correctCount = 0;
    	while (true) {
    		input = new StringTokenizer(br.readLine(), " ");
    		int time = Integer.parseInt(input.nextToken());
    		if (time == exitCondition) {
    			break;
    		}
    		char question = input.nextToken().charAt(0);
    		String result = input.nextToken();
    		if (result.equals(correct)) {
    			int incorrectCount = incorrectCounts.getOrDefault(question, 0);
    			score += time;
    			score += incorrectCount * 20;
    			++correctCount;
    		} else {
    			incorrectCounts.put(question, incorrectCounts.getOrDefault(question, 0) + 1);
    		}
    	}
    	br.close();
    	System.out.println(correctCount + " " + score);
    }
}