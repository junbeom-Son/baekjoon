import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	br.close();
    	int r = Integer.parseInt(st.nextToken());
    	int c = Integer.parseInt(st.nextToken());
    	long answer = r;
    	final int MOD = 998244353;
    	for (int i = 2; i <= c; ++i) {
    		answer *= (r - 1);
    		answer %= MOD;
    	}
    	System.out.println(answer);
    }
}