package baekjoon_java.b_5639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    static class Node {
        int num;
        Node left, right;

        Node(int num) {
            this.num = num;
            this.left = null;
            this.right = null;
        }

        public void insert(Node node) {
            if(node.num < this.num) { // 만약 더 작은 값의 노드라면 왼쪽
                if(this.left == null) {
                    this.left = node;
                } else {
                    this.left.insert(node);
                }
            } else if(node.num > this.num) {
                if(this.right == null) {
                    this.right = node;
                } else {
                    this.right.insert(node);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));
        while(true) {
            String value = br.readLine();
            if(value == null || value.equals("")) break;
            root.insert(new Node(Integer.parseInt(value)));
        }
        preorder(root);
    }

    public static void preorder(Node n) {
        if(n == null) {
            return;
        }
        preorder(n.left);
        preorder(n.right);
        System.out.println(n.num);
    }
}
