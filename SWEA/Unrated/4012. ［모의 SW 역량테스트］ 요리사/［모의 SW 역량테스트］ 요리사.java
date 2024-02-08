import java.util.*;
import java.io.*;
 
public class Solution {
 
	static int[][] synergies;
	static int[] teams;
	static int N;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; ++t) {
        	answer.append("#").append(t).append(" ");
        	N = Integer.parseInt(br.readLine());
        	synergies = new int[N][N];
        	teams = new int[N];
        	for (int i = N / 2; i < N; ++i) {
        		teams[i] = 1;
        	}
        	for (int i = 0; i < N; ++i) {
        		st = new StringTokenizer(br.readLine(), " ");
        		for (int j = 0; j < N; ++j) {
        			synergies[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	answer.append(getMinDifference()).append("\n");
        }
        br.close();
        System.out.print(answer);
    }
    
    private static int getMinDifference() {
    	int minValue = Integer.MAX_VALUE;
    	do {
    		int[] teamScores = new int[2];
    		for (int i = 0; i < N; ++i) {
    			for (int j = 0; j < N; ++j) {
    				if (teams[i] == teams[j]) {
    					teamScores[teams[i]] += synergies[i][j];
    				}
    			}
    		}
    		minValue = Math.min(minValue, Math.abs(teamScores[0] - teamScores[1]));
    	} while (hasNextPermutation());
    	return minValue;
    }
    
    private static boolean hasNextPermutation() {
    	int i = N - 1;
    	while (i > 0 && teams[i - 1] >= teams[i]) --i;
    	
    	if (i == 0) return false;
    	
    	int j = N - 1;
    	while (teams[i - 1] >= teams[j]) --j;
    	
    	swap(i - 1, j);
    	
    	int k = N - 1;
    	while (i < k) swap(i++, k--);
    	
    	return true;
    }
    
    private static void swap(int i, int j) {
    	int temp = teams[i];
    	teams[i] = teams[j];
    	teams[j] = temp;
    }
}