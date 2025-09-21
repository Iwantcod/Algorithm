import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static class Node {
        int y, x;
        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;
    static List<Node> list = new LinkedList<>();
    static int[][] map;
    static int n, arrow = RIGHT, time = 0;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[] cur = {0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n]; // 현재 뱀의 몸이 차지하는 공간을 -1로 표시, 사과는 1로 표시, 나머지는 0
        map[0][0] = -1;
        list.add(new Node(0, 0));
        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k; i++) {
            // 사과 배치
            String[] indx = br.readLine().split(" ");
            map[Integer.parseInt(indx[0]) - 1][Integer.parseInt(indx[1]) - 1] = 1;
        }

        int l = Integer.parseInt(br.readLine());
        int prevCnt = 0;
        for(int i = 0; i < l; i++) {
            String[] command = br.readLine().split(" ");
            int curCnt = Integer.parseInt(command[0]);
            for(int j = 0; j < curCnt - prevCnt; j++) {
                if(move() == false) {
                    bw.write(String.valueOf(time));
                    bw.close();
                    return;
                }
            }
            changeArrow(command[1]);
            prevCnt = curCnt;
        }

        while(cur[0] >= 0 && cur[1] >= 0 && cur[0] < n && cur[1] < n) {
            if(move() == false) {
                break;
            }
        }
        bw.write(String.valueOf(time));
        bw.close();
    }
    public static boolean move() {
        time++;
        int ny = cur[0] + dy[arrow];
        int nx = cur[1] + dx[arrow];
        if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
            // System.out.println("move out: "+ny+" "+nx);
            return false;
        }
        int dest = map[ny][nx];
        if(dest == -1) {
            // System.out.println("move dup: "+ny+" "+nx);
            return false;
        } else {
            list.add(new Node(ny, nx));
            cur[0] = ny; cur[1] = nx;
            map[ny][nx] = -1;
            if(dest == 0) { // 이동한 칸에 사과 없는 경우 꼬리 이동
                Node tail = list.get(0);
                map[tail.y][tail.x] = 0;
                list.remove(0);
            }
            return true;
        }
    }
    public static void changeArrow(String c) {
        if(c.equals("L")) {
            if(arrow == UP) arrow = LEFT;
            else if(arrow == LEFT) arrow = DOWN;
            else if(arrow == DOWN) arrow = RIGHT;
            else arrow = UP;
        } else {
            if(arrow == UP) arrow = RIGHT;
            else if(arrow == RIGHT) arrow = DOWN;
            else if(arrow == DOWN) arrow = LEFT;
            else arrow = UP;
        }
    }
}