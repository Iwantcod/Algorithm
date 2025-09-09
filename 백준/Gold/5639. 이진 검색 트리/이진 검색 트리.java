import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    private static class Node {
        int value;
        Node right, left;
        Node(int v) {
            this.value = v;
        }
    }

    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Node> list = new ArrayList<>();
        
        int idx = 0;
        String input = br.readLine();
        int n = Integer.parseInt(input);
        Node root = new Node(n);
        list.add(root);
        while(true) {
            input = br.readLine();
            if(input == null) break;
            
            n = Integer.parseInt(input);
            Node cur = new Node(n);
            list.add(cur);
            insert(root, cur);
        }
        orders(root);

        // for(int i = 0; i < list.size(); i++) {
        //     Node cur = list.get(i);
        //     System.out.println(cur.value+" "+((cur.left != null) ? cur.left.value : null)+" "+((cur.right != null) ? cur.right.value : null));
        // }

        bw.write(sb.toString());
        bw.close();
    }
    public static void insert(Node root, Node input) {
        if(input.value > root.value) {
            if(root.right == null)
                root.right = input;
            else
                insert(root.right, input);    
        } else {
            if(root.left == null)
                root.left = input;
            else
                insert(root.left, input);
        }
    }

    public static void orders(Node node) {
        if(node == null)
            return;
        orders(node.left);
        orders(node.right);
        sb.append(node.value).append("\n");
        
    }
}