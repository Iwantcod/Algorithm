import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int result = 0;
    static int r, c;
    static String[][] map;
    static int[] dy = {-1, 0, 1}; // 우측 상단, 우측, 우측하단
    static int[] dx = {1, 1, 1}; // 우측 상단, 우측, 우측 하단
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sp = br.readLine().split(" ");
        r = Integer.parseInt(sp[0]);
        c = Integer.parseInt(sp[1]);

        map = new String[r][c];

        for(int i = 0; i < r; i++) {
            String[] s = br.readLine().split("");
            for(int j = 0; j < c; j++) {
                map[i][j] = String.valueOf(s[j]);
            }
        }

        // 3가지 방향 이동여부 검사 후 이동가능한 방향으로 이동
        // 이동했는데 건물을 만난경우 종료
        // 이동에 성공한 경우 계속해서 반복
        // 이동 성공 시 이동한 곳의 좌표를 방문여부 기록
        // 맨 좌측 열의 위에서부터 아래까지 모두 이 행위를 반복
        // "."인 곳만 방문. 이미 방문한 곳은 "-"로 표기

        for(int i = 0; i < r; i++) {
            if(move(i, 0)) result++;
        }

        bw.write(String.valueOf(result));
        bw.close();
        
    }
    public static boolean move(int y, int x) {
        map[y][x] = "-";
        
        for(int i = 0; i < 3; i++) {
            int ny = dy[i] + y;
            int nx = dx[i] + x;
            if(ny >= 0 && nx >= 0 && ny < r && nx < c) {
                if(map[ny][nx].equals(".")) {
                    if(nx == c-1) {
                        map[ny][nx] = "-";
                        return true;
                    }
                    if(move(ny, nx)) return true;
                }    
            }
        }
        return false;
    }
}