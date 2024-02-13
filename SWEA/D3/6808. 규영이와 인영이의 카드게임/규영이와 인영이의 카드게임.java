import java.util.*;
import java.util.stream.IntStream;
import java.io.*;
 
public class Solution {
 
	static int N;
	static int CARD_COUNT = 9;
	static int[] GY = new int[9];
	static int[] IY = new int[9];
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; ++t) {
        	int gyWin = 0;
            int iyWin = 0;
        	answer.append("#").append(t).append(" ");
        	st = new StringTokenizer(br.readLine(), " ");
        	for (int i = 0; i < CARD_COUNT; ++i) {
        		GY[i] = Integer.parseInt(st.nextToken());
        	}
        	getIyCards();
        	do {
        		int gyScore = 0;
        		int iyScore = 0;
        		for (int i = 0; i < CARD_COUNT; ++i) {
        			int score = GY[i] + IY[i];
        			if (GY[i] > IY[i]) {
        				gyScore += score;
        			} else {
        				iyScore += score;
        			}
        		}
        		if (gyScore > iyScore) {
        			++gyWin;
        		} else if (gyScore < iyScore) {
        			++iyWin;
        		}
        	} while (nextPermutation());
        	answer.append(gyWin).append(" ").append(iyWin).append("\n");
        }
        br.close();
        System.out.print(answer);
    }
    
    private static boolean nextPermutation() {
    	// step1 : 교환 위치 찾기(꼭대기를 찾으면 꼭대기 이전이 교환 위치가 됨)
    	int i = CARD_COUNT - 1;
    	while (i > 0 && IY[i - 1] >= IY[i]) --i;
    	if (i == 0) return false;
    	
    	// step2 : 교환 위치(i - 1)에 넣을 값 뒤쪽부터 찾기(큰 값 중 최소 값)
    	int j = CARD_COUNT - 1;
    	while (IY[i - 1] >= IY[j]) --j;
    	
    	// step3 : 교환위치(i - 1)값과 찾은 위치(j)값 교환
    	swap(i - 1, j);
    	
    	// step4 : 꼭대기(i)위치부터 맨뒤까지 오름차순 정렬
    	int k = CARD_COUNT - 1;
    	while (i < k) swap(i++, k--);
    	
    	return true;
    }
    
    private static void swap(int i, int j) {
    	int tmp = IY[i];
    	IY[i] = IY[j];
    	IY[j] = tmp;
    }
    
    private static void getIyCards() {
    	Set<Integer> set = new HashSet<>(); 
    	IntStream.range(1, 19).forEach(set::add);
    	for (int number : GY) {
    		set.remove(number);
    	}
    	int i = 0;
    	for (int number : set) {
    		IY[i++] = number;
    	}
    	Arrays.sort(IY);
    }
}