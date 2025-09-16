import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static class Fish {
        int moveCnt, y, x;
        Fish(int moveCnt, int y, int x) {
            this.moveCnt = moveCnt;
            this.y = y;
            this.x = x;
        }

        public boolean compare(Fish t) {
            if(this == t)
                return false;
            if(this.moveCnt < t.moveCnt) {
                return true;
            } else if(this.moveCnt == t.moveCnt) {
                if(this.y < t.y) {
                    return true;
                } else if(this.y == t.y) {
                    if(this.x < t.x) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
    
    static int n;
    static int[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[] fishNum;
    static int eatCnt = 0;
    static int level = 2;
    static Fish target;
    static int[] cur = new int[2]; // 현재 y, x
    static int result = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        fishNum = new int[7]; // 1 ~ 6

        for(int i = 0; i < n; i++) {
            String[] sp = br.readLine().split(" ");
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(sp[j]);
                if(map[i][j] == 9) {
                    cur[0] = i;
                    cur[1] = j;
                    map[i][j] = 0;
                } else if(map[i][j] > 0) {
                    fishNum[map[i][j]]++;
                }
                // System.out.print(map[i][j]+" ");
            }
            // System.out.println();
        }

        while(canEat()) {
            if(target != null && target.moveCnt == Integer.MAX_VALUE) {
                break;
            }
            bfs(cur[0], cur[1]);
            eat();    
        }

        bw.write(String.valueOf(result));
        bw.close();
    }
    // 먹을 수 있는 모든 물고기와의 거리를 탐색
    public static void bfs(int y, int x) {
        boolean[][] visited = new boolean[n][n];
        target = new Fish(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
        Queue<Fish> q = new LinkedList<>();
        q.add(new Fish(0, y, x));
        visited[y][x] = true;
        
        while(!q.isEmpty()) {
            Fish cur = q.poll();
            if(map[cur.y][cur.x] > 0 && map[cur.y][cur.x] != 9 && map[cur.y][cur.x] < level) {
                if(cur.compare(target)) {
                    target = cur;
                    continue;
                }
            }
            for(int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                if(ny >= 0 && nx >= 0 && ny < n && nx < n) {
                    if(!visited[ny][nx] && map[ny][nx] <= level) {
                        visited[ny][nx] = true;
                        q.add(new Fish(cur.moveCnt+1, ny, nx));
                    }
                }
            }
        }
        
    }

    // 선정된 물고기를 먹는 메소드
    public static void eat() {
        if(target.moveCnt == Integer.MAX_VALUE) return;
        // System.out.println("eat: "+target.y+" "+target.x+", move += "+target.moveCnt+", level = "+level);
        eatCnt++;
        cur[0] = target.y;
        cur[1] = target.x;
        
        result += target.moveCnt;
        int num = map[cur[0]][cur[1]];
        fishNum[num]--;
        map[cur[0]][cur[1]] = 0;
        if(level == eatCnt) {
            level++;
            eatCnt = 0;
        }
    }

    // 먹을 수 있는 물고기가 존재하는지 검사
    public static boolean canEat() {
        for(int i = 1; i < fishNum.length; i++) {
            if(i < level && fishNum[i] > 0)
                return true;
        }
        return false;
    }
}