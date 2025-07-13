import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	int[] inputs = new int[T];
    	for (int i = 0; i < T; ++i) {
    		inputs[i] = Integer.parseInt(br.readLine());
    	}
    	br.close();
    	StringBuilder output = new StringBuilder();
    	for (int input : inputs) {
    		output.append(isPalindrome(input)).append("\n");
    	}
    	System.out.println(output.toString());
    }
    
    private static int isPalindrome(int number) {
    	for (int i = 2; i <= 64; ++i) {
    		List<Integer> convertedNumber = convertType(number, i);
    		if (isPalindrome(convertedNumber)) {
    			return 1;
    		}
    	}
    	return 0;
    }
    
    private static boolean isPalindrome(List<Integer> number) {
    	int size = number.size();
    	for (int i = 0; i < size / 2; ++i) {
    		if (number.get(i) != number.get(size - i - 1)) {
    			return false;
    		}
    	}
    	return true;
    }
    
    private static List<Integer> convertType(int number, int type) {
    	List<Integer> convertedValue = new ArrayList<>();
    	while (number > 0) {
    		convertedValue.add(number % type);
    		number /= type;
    	}
    	return convertedValue;
    }
}