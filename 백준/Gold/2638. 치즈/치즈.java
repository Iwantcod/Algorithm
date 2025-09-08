import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static int[][] map;
    public static int n, m;
    // 상 하 좌 우
    public static int[] dy = {1, -1, 0, 0};
    public static int[] dx = {0, 0, -1, 1};
    public static boolean[][] visited;
    public static ArrayList<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] sp = br.readLine().split(" ");
        n = Integer.parseInt(sp[0]);
        m = Integer.parseInt(sp[1]);
        map = new int[n][m];
        for(int i = 0; i < n; i++) {
            String[] info = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(info[j]);
                if(map[i][j] == 1) {
                    list.add(new int[]{i, j});
                }
            }
        }
        int result = 0;
        while(list.size() > 0) {
            result++;
            visited = new boolean[n][m];
            dfs(0,0);
            melting();
        }

        bw.write(String.valueOf(result));
        bw.close();
    }

    public static void dfs(int y, int x) {
        visited[y][x] = true;
        map[y][x] = -1;
        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if(visited[ny][nx] || map[ny][nx] == 1) continue;
            dfs(ny, nx);
        }
    }

    public static void melting() {
        for(int i = 0; i < list.size(); i++) {
            int[] cur = list.get(i);
            int y = cur[0];
            int x = cur[1];

            int cnt = 0;
            for(int j = 0; j < 4; j++) {
                int ny = y + dy[j];
                int nx = x + dx[j];
                if(map[ny][nx] == -1) cnt++;
            }
            if(cnt >= 2) {
                map[y][x] = 0; // melting 연산 도중 상태가 변하지 않도록 -1이 아닌 0으로 변경
                list.remove(i);
                i--; // arraylist는 삭제 시 뒤의 원소들이 땡겨진다. 삭제 직후의 원소를 올바르게 조회하기 위해 i-- 수행
            }
        }
    }
}