import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static class Node {
        int y, x, cnt;
        Node(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[][] map = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            String[] cur = br.readLine().split("");
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(cur[j]);
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 1));
        while(!q.isEmpty()) {
            Node cur = q.poll();
            for(int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                if(ny >= 0 && nx >= 0 && ny < n && nx < m && map[ny][nx] != 0) {
                    if(map[ny][nx] == 1 || map[ny][nx] > cur.cnt + 1) {
                        map[ny][nx] = cur.cnt + 1;
                        q.add(new Node(ny, nx, cur.cnt + 1));
                    }
                }
            }
        }
        
        bw.write(String.valueOf(map[n-1][m-1]));
        bw.close();
    }
}