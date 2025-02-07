import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static List<List<Integer>> friends = new ArrayList<>();
    private static int[] parents;
    private static List<List<Integer>> children = new ArrayList<>();
    private static int[][] counts; // 각 node가 얼리 어답터일 때와 아닐 때의 최소 개수 저장

    public static void main(String[] args) throws Exception {
        initialize();
        getMinCount(1);

        System.out.println(Math.min(counts[0][1], counts[1][1]));
    }

    private static void getMinCount(int node) {
        if (children.get(node).isEmpty()) { // 리프노드
            return;
        }
        for (int child : children.get(node)) {
            getMinCount(child);
            counts[0][node] += Math.min(counts[0][child], counts[1][child]);
            counts[1][node] += counts[0][child];
        }
    }

    private static void initialize() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parents = new int[N + 1];
        counts = new int[2][N + 1];

        for (int i = 0; i <= N; ++i) {
            friends.add(new ArrayList<>());
            children.add(new ArrayList<>());
            counts[0][i] = 1;
        }
        StringTokenizer st;
        for (int i = 1; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            int number1 = Integer.parseInt(st.nextToken());
            int number2 = Integer.parseInt(st.nextToken());
            friends.get(number1).add(number2);
            friends.get(number2).add(number1);
        }
        setParents();
    }

    private static void setParents() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while (!queue.isEmpty()) {
            int number = queue.poll();
            for (int child : friends.get(number)) {
                if (parents[number] == child) { // 부모라는 뜻
                    continue;
                }
                parents[child] = number;
                queue.add(child);
                children.get(number).add(child);
            }
        }
    }
}