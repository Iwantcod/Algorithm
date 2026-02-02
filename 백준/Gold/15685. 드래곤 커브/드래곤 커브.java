import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] info = new int[n][4];
        for(int i = 0; i < n; i++) {
            String[] sp = br.readLine().split(" ");
            for(int j = 0; j < 4; j++) {
                info[i][j] = Integer.parseInt(sp[j]);
            }
        }
        // 각 세대의 경로의 '방향 전환 정보' 리스트를 저장한다.
        // i 세대: (i-1) 세대 경로 + 좌회전 + (i-1) 세대 경로 반전

        // 좌 좌 우
        // (좌 좌 우) 좌 (좌 우 우)
        // 방향 전환 정보 사용법: 1칸 이동 후 방향 전환 정보 이용하여 방향 수정

        boolean[][] map = new boolean[101][101];
        Character left = 'L';
        Character right = 'R';
        List<List<Character>> curveList = new ArrayList<>();
        for(int i = 0; i < 2; i++) {
            // 0 ~ 1 세대 초기화
            curveList.add(new ArrayList<>());
        }
        curveList.get(1).add(left);

        for(int i = 2; i < 11; i++) {
            // 직전 세대의 경로 정보 복제
            List<Character> prevGen = curveList.get(i-1);
            List<Character> newGen = new ArrayList<>();
            for(Character c : prevGen) {
                newGen.add(c);
            }
            newGen.add(left);
            for(int j = prevGen.size() - 1; j >= 0; j--) {
                Character cur = (prevGen.get(j) == left) ? right : left;
                newGen.add(cur);
            }
            curveList.add(newGen);
        }

        // 방향: 우 상 좌 하
        int[] dy = {0, -1, 0, 1};
        int[] dx = {1, 0, -1, 0};
        for(int i = 0; i < info.length; i++) {
            int[] curInfo = info[i];
            int x = curInfo[0];
            int y = curInfo[1];
            int arrow = curInfo[2];
            List<Character> curve = curveList.get(curInfo[3]);

            map[y][x] = true;
            for(Character c : curve) {
                // 전환한 방향으로 1칸 전진
                y += dy[arrow];
                x += dx[arrow];
                // 방향 전환
                if(c == left) {
                    arrow = (arrow + 1 < 4) ? arrow+1 : 0;
                } else {
                    arrow = (arrow - 1 >= 0) ? arrow-1 : 3;
                }
                map[y][x] = true; // 기록
            }
            y += dy[arrow];
            x += dx[arrow];
            map[y][x] = true;
        }

        int answer = 0;
        int len = map.length;
        for(int i = 0; i < len - 1; i++) {
            for(int j = 0; j < len - 1; j++) {
                boolean a = map[i][j];
                boolean b = map[i][j+1];
                boolean c = map[i+1][j];
                boolean d = map[i+1][j+1];
                if(a && b && c && d) {
                    answer++;
                }
            }
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }
}