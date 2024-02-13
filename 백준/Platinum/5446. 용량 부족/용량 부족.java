import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for (int t = 0; t < tc; ++t) {
			answer.append(solution(br)).append("\n");
		}
		System.out.print(answer);
		br.close();
	}
	
	private static int solution(BufferedReader br) throws IOException {
		int count = 0;
		Node root = new Node();
		int N1 = Integer.parseInt(br.readLine());
		String[] targetFiles = new String[N1];
		for (int i = 0; i < N1; ++i) {
			targetFiles[i] = br.readLine();
		}
		int N2 = Integer.parseInt(br.readLine());
		if (N2 == 0) {
			return 1;
		}
		String[] notDeleteFiles = new String[N2];
		for (int i = 0; i < N2; ++i) {
			notDeleteFiles[i] = br.readLine();
		}
		
		for (String targetFile : targetFiles) {
			Node cursor = root;
			for (char c : targetFile.toCharArray()) {
				if (cursor.next.get(c) == null) {
					cursor.next.put(c, new Node());
				}
				cursor = cursor.next.get(c);
			}
		}
		
		for (String notDeleteFile : notDeleteFiles) {
			Node cursor = root;
			for (char c : notDeleteFile.toCharArray()) {
				if (cursor.next.get(c) == null) {
					break;
				}
				cursor = cursor.next.get(c);
				cursor.canDelete = false;
			}
		}
		
		for (String targetFile : targetFiles) {
			Node cursor = root;
			for (char c : targetFile.toCharArray()) {
				Node nextCursor = cursor.next.get(c);
				if (nextCursor == null) {
					cursor = null;
					break;
				}
				if (nextCursor.canDelete) {
					++count;
					cursor.next.remove(c);
					cursor = null;
					break;
				}
				cursor = nextCursor;
			}
			if (cursor != null) {
				++count;
			}
		}
		return count;
	}
}

class Node {
	boolean isFinal = false;
	boolean canDelete = true;
	Map<Character, Node> next = new HashMap<>();
}