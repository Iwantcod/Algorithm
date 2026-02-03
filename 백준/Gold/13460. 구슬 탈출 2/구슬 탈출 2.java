import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static String[][] map;
    static int answer;
    static int gy, gx;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] st = br.readLine().split(" ");
        n = Integer.parseInt(st[0]);
        m = Integer.parseInt(st[1]);
        map = new String[n][m];
        answer = -1;

        // 각 구슬의 좌표값
        int ry = 0, rx = 0, by = 0, bx = 0;
        for(int i = 0; i < n; i++) {
            String[] cur = br.readLine().split("");
            for(int j = 0; j < m; j++) {
                map[i][j] = (cur[j].equals("#")) ? "#" : ".";
                
                if(cur[j].equals("R")) {
                    ry = i;
                    rx = j;
                } else if(cur[j].equals("B")) {
                    by = i;
                    bx = j;
                } else if(cur[j].equals("O")) {
                    gy = i;
                    gx = j;
                    map[i][j] = "O";
                }
            }
        }
        dfs(ry, rx, by, bx, -1, 0);

        bw.write(String.valueOf(answer));
        bw.close();
    }
    public static void dfs(int ry, int rx, int by, int bx, int prevArrow, int moveCnt) {
        if(moveCnt > 10) {
            return;
        }
        if(by == gy && bx == gx) {
            return;
        }
        if(ry == gy && rx == gx) {
            if(answer == -1) {
                answer = moveCnt;
            } else {
                answer = Math.min(answer, moveCnt);
            }
            
            return;
        }

        for(int i = 0; i < 4; i++) {
            int benArrow = -1;
            if(prevArrow >= 0) {
                if(prevArrow <= 1) {
                    benArrow = (prevArrow == 0) ? 1 : 0;
                } else {
                    benArrow = (prevArrow == 2) ? 3 : 2;
                }
            }
            if(i == prevArrow || i == benArrow) continue;
            boolean isRedFirst = chooseFirst(ry, rx, by, bx, i);
            int[] nextBlueAddr;
            int[] nextRedAddr;
            // System.out.println("moveCnt: "+moveCnt);
            int nextRy = ry;
            int nextRx = rx;
            int nextBy = by;
            int nextBx = bx;
            if(isRedFirst) {
                nextRedAddr = move(ry, rx, by, bx, i);
                nextRy = nextRedAddr[0];
                nextRx = nextRedAddr[1];
                nextBlueAddr = move(by, bx, nextRy, nextRx, i);
                nextBy = nextBlueAddr[0];
                nextBx = nextBlueAddr[1];
            } else {
                nextBlueAddr = move(by, bx, ry, rx, i);
                nextBy = nextBlueAddr[0];
                nextBx = nextBlueAddr[1];
                nextRedAddr = move(ry, rx, nextBy, nextBx, i);
                nextRy = nextRedAddr[0];
                nextRx = nextRedAddr[1];
            }
            dfs(nextRy, nextRx, nextBy, nextBx, i, moveCnt + 1);
        }
    }
    public static int[] move(int y, int x, int anotherY, int anotherX, int arrow) {
        // 기울어짐에 따른 구슬 이동
        // 기울어진 방향 기준으로 더 앞에 있는 구슬먼저 이동
        while(true) {
            int ny = y + dy[arrow];
            int nx = x + dx[arrow];
            if(ny >= 0 && ny < n && nx >= 0 && nx < m) {
                if(map[ny][nx].equals("O")) {
                    return new int[]{ny, nx};
                }
                // 구슬의 충돌 여부 검증
                if(map[ny][nx].equals("#") || (ny == anotherY && nx == anotherX)) {
                    return new int[]{y, x};
                }
                y = ny;
                x = nx;
            } else {
                return new int[]{y, x};
            }
        }
    }
    // 이동 우선순위 결정(true: red, false: blue)
    public static boolean chooseFirst(int ry, int rx, int by, int bx, int arrow) {
        switch(arrow) {
            case 0:
                return ry < by;
            case 1:
                return ry > by;
            case 2:
                return rx < bx;
            case 3:
                return rx > bx;
        }
        return true;
    }
}