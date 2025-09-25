import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int n;
    static long[][] map;
    static int[][] cnt;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        map = new long[n][n];
        cnt = new int[n][n];
        
        for(int i = 0; i < n; i++) {
            String[] sp = br.readLine().split(" ");
            for(int j = 0; j < n; j++) {
                map[i][j] = Long.parseLong(sp[j]);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                max = Math.max(max, dfs(i, j));
            }
        }
        bw.write(String.valueOf(max));
        bw.close();
    }
    public static int dfs(int y, int x) {
        if(cnt[y][x] != 0) {
            // 해당 좌표에서 갈 수 있는 최대 거리값이 이미 있다면 즉시 return
            return cnt[y][x];
        }

        cnt[y][x] = 1; // 해당 좌표 초기값 1로 초기화
        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny >= 0 && nx >= 0 && ny < n && nx < n && map[ny][nx] > map[y][x]) {
                // 자기 자신의 값과 상하좌우 방문하며 얻은 최대값 + 1 중 더 큰 값으로 자신을 갱신
                cnt[y][x] = Math.max(cnt[y][x], dfs(ny, nx) + 1);
            }
        }

        // 더 이상 방문할 곳이 없는 경우 자기 자신을 그대로 반환
        return cnt[y][x];
    }

    // 틀렸던 코드: 시간초과
    // public static void bfs(int y, int x) {
    //     Queue<Node> q = new LinkedList<>();
    //     q.add(new Node(y, x, cnt[y][x]));
    //     while(!q.isEmpty()) {
    //         Node cur = q.poll();
    //         for(int i = 0; i < 4; i++) {
    //             int ny = cur.y + dy[i];
    //             int nx = cur.x + dx[i];
    //             if(ny >= 0 && nx >= 0 && ny < n && nx < n) {
    //                 if(map[ny][nx] > map[cur.y][cur.x] && cnt[cur.y][cur.x] + 1 > cnt[ny][nx]) {
    //                     cnt[ny][nx] = Math.max(cnt[ny][nx], cnt[cur.y][cur.x] + 1);
    //                     if(cnt[ny][nx] > max) max = cnt[ny][nx];
    //                     q.add(new Node(ny, nx, cnt[ny][nx]));
    //                 }
    //             }
    //         }
    //     }
    // }
}