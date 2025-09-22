import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[][][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1][3]; // 가로, 세로, 대각선 파이프 끝이 배치될 수 있는 경우의 수
        for(int i = 0; i < n; i++) {
            String[] sp = br.readLine().split(" ");
            for(int j = 0; j < n; j++) {
                if(sp[j].equals("1")) {
                    map[i][j][0] = -1;
                    map[i][j][1] = -1;
                    map[i][j][2] = -1;
                }
            }
        }
        
        map[0][1][0] = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 1; j < n; j++) {
                if(map[i][j][0] == -1) continue;
                for(int k = 0; k < 3; k++) {
                    int cur = map[i][j][k];
                    switch(k) {
                        case 0:
                            if(checkRight(i, j)) map[i][j+1][0] += cur;
                            if(check4(i, j)) map[i+1][j+1][2] += cur;
                            break;
                        case 1:
                            if(checkDown(i, j)) map[i+1][j][1] += cur;
                            if(check4(i, j)) map[i+1][j+1][2] += cur;
                            break;
                        case 2:
                            if(checkRight(i, j)) map[i][j+1][0] += cur;
                            if(checkDown(i, j)) map[i+1][j][1] += cur;
                            if(check4(i, j)) map[i+1][j+1][2] += cur;
                    }
                }
            }
        }

        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < n; j++) {
        //         System.out.print(map[i][j][0] + map[i][j][1] + map[i][j][2]+" ");
        //     }
        //     System.out.println();
        // }
        
        int result = map[n-1][n-1][0] + map[n-1][n-1][1] + map[n-1][n-1][2];
        if(result < 0) result = 0;
        bw.write(String.valueOf(result));
        bw.close();
    }
    public static boolean check4(int y, int x) {
        return checkRight(y, x) && checkDown(y, x) && (map[y+1][x+1][0] != -1);
    }
    public static boolean checkRight(int y, int x) {
        return map[y][x+1][0] != -1;
    }
    public static boolean checkDown(int y, int x) {
        return map[y+1][x][0] != -1;
    }
}