import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static class Node {
        int vy, vx, c; // 정점과 정점까지의 cost
        Node(int vy, int vx, int c) {
            this.vy = vy;
            this.vx = vx;
            this.c = c;
        }
    }
    
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int INF = Integer.MAX_VALUE;

        int problemCnt = 1;
        int n = Integer.parseInt(br.readLine());
        while(n != 0) {
            PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.c - n2.c);
            int[][] matrix = new int[n][n];
            int[][] cost = new int[n][n];
            
            for(int i = 0; i < n; i++) {
                Arrays.fill(cost[i], INF);
            }
            for(int i = 0; i < n; i++) {
                String[] sp = br.readLine().split(" ");
                for(int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(sp[j]);
                }
            }
            cost[0][0] = matrix[0][0];

            pq.add(new Node(0, 0, matrix[0][0]));
            while(!pq.isEmpty()) {
                Node cur = pq.poll();
                for(int i = 0; i < 4; i++) {
                    int ny = cur.vy + dy[i];
                    int nx = cur.vx + dx[i];
                    if(ny >= 0 && nx >= 0 && ny < n && nx < n) {
                        if(cost[ny][nx] > cur.c + matrix[ny][nx]) {
                            cost[ny][nx] = cur.c + matrix[ny][nx];
                            pq.add(new Node(ny, nx, cost[ny][nx]));
                        }
                    }
                }
            }
            bw.write("Problem "+String.valueOf(problemCnt)+": "+String.valueOf(cost[n-1][n-1])+"\n");
            problemCnt++;
            n = Integer.parseInt(br.readLine());
        }
        bw.close();
    }
}