import java.io.*;
import java.util.*;

public class Main {

    private static int[] numbers;
    private static int[] tree;

    private static void init(int node, int start, int end) {
        if (start == end) {
            tree[node] = numbers[start];
        } else {
            init(node * 2, start, (start + end) / 2);
            init(node * 2 + 1, (start + end) / 2 + 1, end);
            tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
        }
    }

    private static void update(int index, int node, int value, int start, int end) {
        if (index < start || index > end) {
            return;
        }
        if (start == end) {
            tree[node] = value;
            return;
        }
        update(index, node * 2, value, start, (start + end) / 2);
        update(index, node * 2 + 1, value, (start + end) / 2 + 1, end);
        tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
    }

    private static int getMin(int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return Integer.MAX_VALUE;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        int leftMin = getMin(node * 2, start, (start + end) / 2, left, right);
        int rightMin = getMin(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
        return Math.min(leftMin, rightMin);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int height = (int) Math.ceil(Math.log(N) / Math.log(2));
        int treeSize = (1 << (height + 1));
        numbers = new int[N];
        tree = new int[treeSize];
        Arrays.fill(tree, Integer.MAX_VALUE);
        for (int i = 0; i < N; ++i) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        init(1, 0, N - 1);
        int M = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int command = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());
            if (command == 1) {
                int value = Integer.parseInt(st.nextToken());
                update(index - 1, 1, value, 0, N - 1);
            } else {
                int index2 = Integer.parseInt(st.nextToken());
                answer.append(getMin(1, 0, N - 1, index - 1, index2 - 1)).append("\n");
            }
        }
        br.close();
        System.out.print(answer);
    }
}