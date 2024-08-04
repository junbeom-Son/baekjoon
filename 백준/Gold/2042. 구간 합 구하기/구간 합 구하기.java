import java.util.*;
import java.io.*;
public class Main {

    static void init(long[] a, long[] tree, int node, int start, int end) {
        if (start == end) {
            tree[node] = a[start];
        } else {
            init(a, tree, node * 2, start, (start + end) / 2);
            init(a, tree, node * 2 + 1, (start + end) / 2 + 1, end);
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }
    }

    // start, end : node의 커버 범위
    // left, right: 탐색을 해야 하는 범위
    static long query(long[] tree, int node, int start, int end, int left, int right) {
        if (end < left || right < start) { // 전혀 겹치지 않는 경우
            return 0;
        }
        if (left <= start && end <= right) { // left와 right가 start, end를 모두 감싸는 경우
            return tree[node];
        }
        long leftSum = query(tree, node * 2, start, (start + end) / 2, left, right);
        long rightSum = query(tree, node * 2 + 1, (start + end) / 2 + 1, end, left, right);
        return leftSum + rightSum;
    }

    static void updateTree(long[] tree, int node, int start, int end, int index, long diff) {
        if (index < start || end < index) {
            return;
        }
        tree[node] += diff;
        if (start != end) { // 하나의 index만 update하기 때문에, 리프노드가 아니면 리프노드까지 업데이트 진행
            updateTree(tree, node * 2, start, (start + end) / 2, index, diff);
            updateTree(tree, node * 2 + 1, (start + end) / 2 + 1, end, index, diff);
        }
    }

    static void update(long[] a, long[] tree, int N, int index, long value) {
        long diff = value - a[index];
        a[index] = value;
        updateTree(tree, 1, 0, N - 1, index, diff);
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long[] a = new long[N];
        for (int i = 0; i < N; i++) {
            a[i] = Long.parseLong(br.readLine());
        }
        int height = (int) Math.ceil(Math.log(N) / Math.log(2));
        int treeSize = (1 << height + 1);
        long[] tree = new long[treeSize];
        init(a, tree, 1, 0, N - 1);
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < M + K; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int command = Integer.parseInt(st.nextToken());
            if (command == 1) {
                int number1 = Integer.parseInt(st.nextToken());
                long number2 = Long.parseLong(st.nextToken());
                update(a, tree, N, number1 - 1, number2);
            } else {
                int number1 = Integer.parseInt(st.nextToken());
                int number2 = Integer.parseInt(st.nextToken());
                answer.append(query(tree, 1, 0, N - 1, number1 - 1, number2 - 1)).append("\n");
            }
        }
        br.close();
        System.out.print(answer);
    }
}