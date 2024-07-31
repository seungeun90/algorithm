import java.util.Arrays;
import java.util.Comparator;

class Solution {
        int[][] result ;
    int idx = 0;
    public int[][] solution(int[][] nodeinfo) {
        Node[] nodes = new Node[nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes[i] = new Node(nodeinfo[i][0],nodeinfo[i][1], (i+1),null,null );
        }

        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.y == o2.y) {
                    return o1.x - o2.x;
                }
                return o2.y - o1.y;
            }
        });

        Node root = nodes[0];
        for (int i = 1; i < nodes.length; i++) {
            insertNode(root, nodes[i]);
        }

        result = new int[2][nodeinfo.length];
        preorder(root);
        idx =0;
        postorder(root);

        return result;
    }

    private void postorder(Node root) {
        if(root!=null) {
            postorder(root.left);
            postorder(root.right);
            result[1][idx++] = root.value;
        }
    }

    private void preorder(Node root) {
        if(root!=null) {
            result[0][idx++] = root.value;
            preorder(root.left);
            preorder(root.right);
        }
    }

    private void insertNode(Node root, Node node) {
        if(root.x > node.x) {
            if(root.left == null) root.left = node;
            else insertNode(root.left, node);
        } else {
            if(root.right == null) root.right = node;
            else insertNode(root.right, node);
        }
    }

    static class Node{
        int x;
        int y;
        int value;
        Node left;
        Node right;
        public Node(int x, int y, int value, Node left, Node right) {
            this.x = x;
            this.y = y;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    
    }
}