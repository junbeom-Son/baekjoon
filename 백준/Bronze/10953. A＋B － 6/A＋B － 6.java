import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder answer = new StringBuilder(); 
		for (int i = 0; i < T; ++i) {
			st  = new StringTokenizer(br.readLine(), ",");
			answer.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())).append("\n");
		}
		br.close();
		System.out.print(answer);
	}
}