import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	int[] limits = new int[M + 1];
    	st = new StringTokenizer(br.readLine());
    	for (int i = 1; i <= M; ++i) {
    		limits[i] = Integer.parseInt(st.nextToken());
    	}
    	List<Set<Integer>> studentsInSubjects = new ArrayList<>();
    	List<List<Integer>> completed = new ArrayList<>();
    	for (int i = 0; i < N; ++i) {
    		completed.add(new ArrayList<>());
    	}
    	for (int i = 0; i <= M; ++i) {
    		studentsInSubjects.add(new HashSet<>());
    	}
    	for (int round = 0; round < 2; ++round) {
    		for (int i = 0; i < N; ++i) {
    			st = new StringTokenizer(br.readLine(), " ");
    			while (st.hasMoreTokens()) {
    				int subject = Integer.parseInt(st.nextToken());
    				if (subject == -1) {
    					break;
    				}
    				studentsInSubjects.get(subject).add(i);
    			}
    		}
    		for (int i = 1; i <= M; ++i) {
				if (limits[i] < studentsInSubjects.get(i).size()) {
					continue;
				}
				for (int student : studentsInSubjects.get(i)) {
					completed.get(student).add(i);
				}
				limits[i] -= studentsInSubjects.get(i).size();
				studentsInSubjects.get(i).clear();
			}
    	}
    	br.close();
    	StringBuilder output = new StringBuilder();
    	for (int i = 0; i < N; ++i) {
    		List<Integer> completedSubjects = completed.get(i);
    		if (completedSubjects.isEmpty()) {
    			output.append("망했어요\n");
    			continue;
    		}
    		Collections.sort(completedSubjects);
    		for (int subject : completedSubjects) {
    			output.append(subject).append(" ");
    		}
    		output.append("\n");
    	}
    	System.out.println(output.toString());
    }
}