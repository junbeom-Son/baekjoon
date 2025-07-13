import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int testCase = Integer.parseInt(br.readLine());
    	StringBuilder output = new StringBuilder();
    	for (int i = 0; i < testCase; ++i) {
    		int x = Integer.parseInt(br.readLine());
    		StringTokenizer input = new StringTokenizer(br.readLine(), " ");
    		int length = 0;
    		for (int j = 0; j < x; ++j) {
    			length += Integer.parseInt(input.nextToken());
    		}
    		length <<= 1;
    		input = new StringTokenizer(br.readLine(), " ");
    		int[] heights = new int[x];
    		for (int j = 0; j < x; ++j) {
    			heights[j] = Integer.parseInt(input.nextToken());
    		}
    		int currentHeight = 0;
    		for (int j = 0; j < x; ++j) {
    			length += Math.abs(currentHeight - heights[j]);
    			currentHeight = heights[j];
    		}
    		length += heights[x - 1];
    		output.append(length).append("\n");
    	}
    	br.close();
    	System.out.println(output.toString());
    }
}