import java.util.*;
import java.lang.*;
import java.io.*;
// 16:05 시작

class Main {
    static char[][] map;
    static int[] target = new int[2];
    static boolean connectM;
    static boolean connectZ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sp = br.readLine().split(" ");
        int r = Integer.parseInt(sp[0]);
        int c = Integer.parseInt(sp[1]);
        map = new char[r+1][c+1];
        boolean[] arrow = new boolean[4]; // 채워야 할 방향 정보 저장: 상 하 좌 우

        // map 초기화
        for(int i = 1; i <= r; i++) {
            String cur = br.readLine();
            for(int j = 1; j <= c; j++) {
                map[i][j] = cur.charAt(j-1);
            }
        }

        // 채워야 할 공간의 방향 조사
        for(int i = 1; i <= r; i++) {
            for(int j = 1; j <= c; j++) {
                if(map[i][j] == '.' || map[i][j] == 'M' || map[i][j] == 'Z') continue;
                switch(map[i][j]) {
                    case '|':
                        checkUp(i, j);
                        checkDown(i, j);
                        break;
                    case '-':
                        checkLeft(i, j);
                        checkRight(i, j);
                        break;
                    case '+':
                        checkUp(i, j);
                        checkDown(i, j);
                        checkLeft(i, j);
                        checkRight(i, j);
                        break;
                    case '1':
                        checkDown(i, j);
                        checkRight(i, j);
                        break;
                    case '2':
                        checkUp(i, j);
                        checkRight(i, j);
                        break;
                    case '3':
                        checkUp(i, j);
                        checkLeft(i, j);
                        break;
                    case '4':
                        checkDown(i, j);
                        checkLeft(i, j);
                        break;
                }
            }
        }
        
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        for(int i = 0; i < 4; i++) {
            int ny = target[0] + dy[i];
            int nx = target[1] + dx[i];
            if(ny > 0 && nx > 0 && ny <= r && nx <= c) {
                if(map[ny][nx] == '.') {
                    continue;
                }

                char cur = map[ny][nx];
                switch(i) {
                    case 0:
                        if(cur == '+' || cur == '|' || cur == '1' || cur == '4' || (!connectM && cur == 'M') || (!connectZ && cur == 'Z')) {
                            arrow[0] = true;
                        }
                        break;
                    case 1:
                        if(cur == '+' || cur == '|' || cur == '2' || cur == '3' || (!connectM && cur == 'M') || (!connectZ && cur == 'Z')) {
                            arrow[1] = true;
                        }
                        break;
                    case 2:
                        if(cur == '+' || cur == '-' || cur == '1' || cur == '2' || (!connectM && cur == 'M') || (!connectZ && cur == 'Z')) {
                            arrow[2] = true;
                        }
                        break;
                    case 3:
                        if(cur == '+' || cur == '-' || cur == '3' || cur == '4' || (!connectM && cur == 'M') || (!connectZ && cur == 'Z')) {
                            arrow[3] = true;
                        }
                        break;
                }
            }
        }


        char result;
        // 채워야 할 방향 정보를 이용하여 원래 있었던 파이프 모양 구하기
        if(arrow[0] && arrow[1] && arrow[2] && arrow[3]) {
            result = '+';
        } else if(arrow[0] && arrow[1]) {
            result = '|';
        } else if(arrow[2] && arrow[3]) {
            result = '-';
        } else if(arrow[1] && arrow[3]) {
            result = '1';
        } else if(arrow[0] && arrow[3]) {
            result = '2';
        } else if(arrow[0] && arrow[2]) {
            result = '3';
        } else {
            result = '4';
        }

        bw.write(String.valueOf(target[0])+" "+String.valueOf(target[1])+" "+String.valueOf(result));
        bw.close();
    }
    public static void checkUp(int y, int x) {
        if(map[y-1][x] == '.'){
            target[0] = y-1; target[1] = x;
            // System.out.println(y+" "+x+": 위쪽 체크");
        } else if(map[y-1][x] == 'Z') {
            connectZ = true;
        } else if(map[y-1][x] == 'M') {
            connectM = true;
        }
    }
    public static void checkDown(int y, int x) {
        if(map[y+1][x] == '.'){
            target[0] = y+1; target[1] = x;
            // System.out.println(y+" "+x+": 아래 체크");
        } else if(map[y+1][x] == 'Z') {
            connectZ = true;
        } else if(map[y+1][x] == 'M') {
            connectM = true;
        }
    }
    public static void checkLeft(int y, int x) {
        if(map[y][x-1] == '.'){
            target[0] = y; target[1] = x-1;
            // System.out.println(y+" "+x+": 왼쪽 체크");
        } else if(map[y][x-1] == 'Z') {
            connectZ = true;
        } else if(map[y][x-1] == 'M') {
            connectM = true;
        }
    }
    public static void checkRight(int y, int x) {
        if(map[y][x+1] == '.'){
            target[0] = y; target[1] = x+1;
            // System.out.println(y+" "+x+": 오른쪽 체크");
        } else if(map[y][x+1] == 'Z') {
            connectZ = true;
        } else if(map[y][x+1] == 'M') {
            connectM = true;
        }
    }
}