import java.io.*;
import java.util.*;

public class Main {
	
	private static int[] numbers;
	private static int[] tree;
	
	private static void update(int node) {
		int leftChild = tree[node * 2];
		int rightChild = tree[node * 2 + 1];
		if (numbers[leftChild] < numbers[rightChild]) {
			tree[node] = leftChild;
		} else if (numbers[leftChild] > numbers[rightChild]) {
			tree[node] = rightChild;
		} else {
			if (leftChild < rightChild) {
				tree[node] = leftChild;
			} else {
				tree[node] = rightChild;
			}
		}
	}
	
	private static void init(int node, int start, int end) {
		if (start == end) {
			tree[node] = start;
			return;
		}
		init(node * 2, start, (start + end) / 2);
		init(node * 2 + 1, (start + end) / 2 + 1, end);
		update(node);
	}
	
	private static void changeValue(int node, int start, int end, int index) {
		if (index < start || index > end) {
			return;
		}
		if (start == end) {
			return;
		}
		changeValue(node * 2, start, (start + end) / 2, index);
		changeValue(node * 2 + 1, (start + end) / 2 + 1, end, index);
		update(node);
	}
	
	private static int getMinValueIndex(int node, int start, int end, int left, int right, int curMinIndex) {
		if (left > end || right < start) {
			return curMinIndex;
		}
		if (left <= start && end <= right) {
			return tree[node];
		}
		int leftMinIndex = getMinValueIndex(node * 2, start, (start + end) / 2, left, right, curMinIndex);
		int rightMinIndex = getMinValueIndex(node * 2 + 1, (start + end) / 2 + 1, end, left, right, curMinIndex);
		if (numbers[leftMinIndex] < numbers[curMinIndex]) {
			curMinIndex = leftMinIndex;
		}
		if (numbers[rightMinIndex] < numbers[curMinIndex]) {
			curMinIndex = rightMinIndex;
		}
		return curMinIndex;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		numbers = new int[N];
		for (int i = 0; i < N; ++i) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		int height = (int) Math.ceil(Math.log(N) / Math.log(2));
		int treeSize = (1 << (height + 1));
		tree = new int[treeSize];
		init(1, 0, N - 1);
		int M = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int command = Integer.parseInt(st.nextToken());
			int index = Integer.parseInt(st.nextToken());
			if (command == 1) { // change value
				int value = Integer.parseInt(st.nextToken());
				numbers[index - 1] = value;
				changeValue(1, 0, N - 1, index - 1);
			} else { // find minValue
				int index2 = Integer.parseInt(st.nextToken());
				answer.append(getMinValueIndex(1, 0, N - 1, index - 1, index2 - 1, index - 1) + 1)
				.append("\n");
			}
		}
		br.close();
		System.out.print(answer);
	}
}