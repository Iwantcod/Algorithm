import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static class Shark {
        int y, x;
        int speed, arrow, size;
        Shark(int y, int x, int speed, int arrow, int size) {
            this.y = y;
            this.x = x;
            this.speed = speed;
            this.arrow = arrow;
            this.size = size;
        }
    }

    static int[] dy = {-1, 1, 0, 0}; // 상 하 우 좌
    static int[] dx = {0, 0, 1 , -1};
    static Map<String, Shark> map = new HashMap<>();
    static List<Shark> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] sp = br.readLine().split(" ");
        int r = Integer.parseInt(sp[0]);
        int c = Integer.parseInt(sp[1]);
        int m = Integer.parseInt(sp[2]);

        // 초기값 세팅
        for(int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            int y = Integer.parseInt(s[0]);
            int x = Integer.parseInt(s[1]);
            int speed = Integer.parseInt(s[2]);
            int arrow = Integer.parseInt(s[3]) - 1; // dy, dx 활용 편의를 위해 0 ~ 3의 값으로 치환
            int size = Integer.parseInt(s[4]);
            list.add(new Shark(y, x, speed, arrow, size));
        }

        int sum = 0;
        for(int status = 1; status <= c; status++) {
            // 상어 포획
            int min = Integer.MAX_VALUE;
            Shark target = null;
            for(Shark cur : list) {
                if(cur.x == status && cur.y < min && cur.size != -1) {
                    min = cur.y;
                    target = cur;
                }
            }
            if(target != null) {
                // System.out.println("+ "+target.size);
                sum += target.size;
                target.size = -1;
            }

            // 상어 이동
            for(Shark cur : list) {
                if(cur.size == -1) continue;
                int ny = cur.y + (dy[cur.arrow] * cur.speed);
                int nx = cur.x + (dx[cur.arrow] * cur.speed);
                while(ny < 1 || ny > r) {
                    if(ny < 1) {
                        ny = 1 + (1 - ny);
                        cur.arrow = 1;
                    }
                    if(ny > r) {
                        ny = r - (ny - r);
                        cur.arrow = 0;
                    }
                }
                while(nx < 1 || nx > c) {
                    if(nx < 1) {
                        nx = 1 + (1 - nx);
                        cur.arrow = 2;
                    }
                    if(nx > c) {
                        nx = c - (nx - c);
                        cur.arrow = 3;
                    }
                }
                cur.y = ny;
                cur.x = nx;
                // System.out.println("size: "+cur.size+" address: "+cur.y+" "+cur.x+" arrow: "+cur.arrow);
            }
            // System.out.println();

            for(int i = 0; i < list.size(); i++) {
                Shark cur = list.get(i);
                if(cur.size == -1) continue;
                String address = "" + cur.y + " " + cur.x;
                if(map.containsKey(address)) {
                    Shark prev = map.get(address);
                    if(cur.size > prev.size) {
                        map.replace(address, cur);
                        prev.size = -1;
                    } else {
                        cur.size = -1;
                    }
                } else {
                    map.put(address, cur);
                }
            }
            
            map.clear();
            
        }

        bw.write(String.valueOf(sum));
        bw.close();
    }
}