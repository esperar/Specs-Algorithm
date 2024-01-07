package baekjoon_java.b_1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static Node head = new Node('A', null, null);

    static class Node {
        char value;
        Node left;
        Node right;


        public Node(char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            insertNode(head, root, left, right);
        }

        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);

    }

    static void insertNode(Node node, char root, char left, char right) {
        if(node.value == root) {
            node.left = (left == '.' ? null : new Node(left, null, null));
            node.right = (right == '.' ? null : new Node(right, null, null));
        } else {
            if(node.left != null) insertNode(node.left, root, left, right);
            if(node.right != null) insertNode(node.right, root, left, right);
        }
    }

    static void preOrder(Node node) {
        if(node == null) return;
        System.out.print(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }


    static void inOrder(Node node) {
        if(node == null) return;
        inOrder(node.left);
        System.out.print(node.value);
        inOrder(node.right);
    }

    static void postOrder(Node node) {
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value);
    }
}
