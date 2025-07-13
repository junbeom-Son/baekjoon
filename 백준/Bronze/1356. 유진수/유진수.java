import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String input = br.readLine();
    	br.close();
    	int[] number = new int[input.length()];
    	for (int i = 0; i < input.length(); ++i) {
    		number[i] = input.charAt(i) - '0';
    	}
    	System.out.println(isValid(number) ? "YES" : "NO");
    }
    
    private static boolean isValid(int[] number) {
    	for (int i = 1; i < number.length; ++i) {
    		long left = calculate(0, i, number);
    		long right = calculate(i, number.length, number);
    		if (left == right) {
    			return true;
    		}
    	}
    	return false;
    }
    
    private static long calculate(int start, int end, int[] number) {
    	long value = 1;
    	for (int i = start; i < end; ++i) {
    		value *= number[i];
    	}
    	return value;
    }
}