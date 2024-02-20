import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] treeInput = br.readLine().toCharArray();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();
		Node[] tree = new Node[N * 2];
		Node root = new Node(-1, -1, null);
		Node curNode = root;
		for (int i = 0; i < treeInput.length; ++i) {
			if (treeInput[i] == '0') {
				Node node = new Node(curNode.depth + 1, i, curNode);
				tree[i] = node;
				curNode = node;
			} else {
				curNode.outIndex = i;
				tree[i] = curNode;
				curNode = curNode.parent;
			}
		}
		int X = Integer.parseInt(st.nextToken()) - 1;
		int Y = Integer.parseInt(st.nextToken()) - 1;
		Node appleA = tree[X];
		Node appleB = tree[Y];
		if (appleA.depth < appleB.depth) {
			appleB = balanceTheTree(appleA.depth, appleB);
		} else {
			appleA = balanceTheTree(appleB.depth, appleA);
		}
		
		while (appleA != appleB) {
			appleA = appleA.parent;
			appleB = appleB.parent;
		}
		
		System.out.println((appleA.inIndex + 1) + " " + (appleB.outIndex + 1));
	}
	
	private static Node balanceTheTree(int targetDepth, Node node) {
		while (node.depth > targetDepth) {
			node = node.parent;
		}
		return node;
	}
}

class Node {
	int depth;
	int inIndex;
	int outIndex;
	Node parent;
	public Node(int depth, int inIndex, Node parent) {
		this.depth = depth;
		this.inIndex = inIndex;
		this.parent = parent;
	}
}