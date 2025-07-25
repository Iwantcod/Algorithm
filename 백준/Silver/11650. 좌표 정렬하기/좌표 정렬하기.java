import java.util.*;
import java.lang.*;
import java.io.*;

class Node implements Comparable<Node> {
    int x, y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Node o) {
        if(o.x > this.x) {
            return -1;
        } else if(o.x < this.x) {
            return 1;
        } else {
            return this.y - o.y;
        }
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Node> q = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            q.add(new Node(Integer.parseInt(s[0]), Integer.parseInt(s[1])));
        }

        while(!q.isEmpty()) {
            Node cur = q.poll();
            bw.write(String.valueOf(cur.x) + " " + String.valueOf(cur.y) + "\n");
        }
        bw.close();
    }
}