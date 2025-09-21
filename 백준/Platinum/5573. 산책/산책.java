import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sp = br.readLine().split(" ");
        int h = Integer.parseInt(sp[0]);
        int w = Integer.parseInt(sp[1]);
        int n = Integer.parseInt(sp[2]);

        int[][] map = new int[h+1][w+1];
        int[][] cnt = new int[h+1][w+1];
        for(int i = 0; i < h; i++) {
            String[] s = br.readLine().split(" ");
            for(int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        cnt[0][0] = n-1;
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                int cur = cnt[i][j];
                if(cur == 1) {
                    // 기준 집의 변경 횟수가 1인 경우 해당 방향의 거리만 변경횟수 1 증가
                    if(map[i][j] == 0) {
                        cnt[i+1][j]++;
                    } else {
                        cnt[i][j+1]++;
                    }
                } else if(cur % 2 == 0) {
                    // 기준 집의 변경 횟수가 짝수인 경우 두 방향의 거리 모두 cur/2 만큼 증가
                    cnt[i+1][j] += cur/2;
                    cnt[i][j+1] += cur/2;
                } else {
                    // 기준 집의 변경 횟수 홀수인 경우 해당 방향의 거리는 (cur/2)+1, 아닌 거리는 cur/2 만큼 증가
                    if(map[i][j] == 0) {
                        cnt[i+1][j] += (cur/2) + 1;
                        cnt[i][j+1] += cur/2;
                    } else {
                        cnt[i+1][j] += cur/2;
                        cnt[i][j+1] += (cur/2) + 1;
                    }
                }
            }
        }

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                // System.out.print(cnt[i][j]+" ");
                if(cnt[i][j] % 2 != 0) {
                    map[i][j]--;
                    if(map[i][j] < 0) map[i][j] *= -1;
                }
            }
            // System.out.println();
        }

        int y = 0; int x = 0;
        while(y < h && x < w) {
            if(map[y][x] == 0) {
                y++;
            } else {
                x++;
            }
        }
        y++; x++;
        bw.write(String.valueOf(y)+" "+String.valueOf(x));
        bw.close();
    }
}