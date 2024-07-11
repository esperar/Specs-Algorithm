package other.트리_순회;

public class Solutions {
    public static void main(String[] args) {
        String[] result = new String[3];
        int[] nodes = {1, 2, 3, 4, 5, 6, 7};
        result[0] = preOrder(nodes, 0);
        result[1] = inorder(nodes, 0);
        result[2] = postOrder(nodes, 0);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length(); j++) {
                System.out.print(result[i].charAt(j));
            }
            System.out.println();
        }
    }

    static String preOrder(int[] nodes, int idx) {
        if(idx >= nodes.length) {
            return "";
        }

        return nodes[idx] + " " + preOrder(nodes, 2 * idx + 1) + preOrder(nodes, 2 * idx + 2);
    }

    static String inorder(int[] nodes, int idx) {
        if(idx >= nodes.length) {
            return "";
        }

        return inorder(nodes, 2 * idx + 1) + nodes[idx] + " " + inorder(nodes, 2 * idx + 2);
    }

    static String postOrder(int[] nodes, int idx) {
        if(idx >= nodes.length) {
            return "";
        }

        return postOrder(nodes, 2 * idx + 1) + postOrder(nodes, 2 * idx + 2) + nodes[idx] + " ";
    }
}
