import java.util.*;
import java.lang.*;
import java.io.*;

// 09:07
class Main {
    static int[][] map;
    static boolean isDone;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 현재 3*3 공간에 1~9는 하나씩만 존재
        // 2. 현재 행에 1~9는 하나씩만 존재
        // 3. 현재 열에 1~9는 하나씩만 존재

        map = new int[9][9];
        isDone = false;
        for(int i = 0; i < 9; i++) {
            String[] st = br.readLine().split("");
            for(int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st[j]);
            }
        }

        dfs(0);
    }
    public static void dfs(int depth) {
        if(isDone == true) {
            return;
        }
        if(depth == 81) {
            isDone = true;
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
            return;
        }

        int y = depth / 9;
        int x = depth % 9;

        if(map[y][x] != 0) {
            dfs(depth + 1);
            return;
        }

        for(int i = 1; i <= 9; i++) {
            if(checkBlock(y, x, i) && checkRow(y, x, i) && checkCol(y, x, i)) {
                map[y][x] = i;
                dfs(depth + 1);
                map[y][x] = 0;
            }
        }
    }
    public static boolean checkBlock(int y, int x, int num) {
        // 1. 현재 3*3 공간에 1~9는 하나씩만 존재하는지 검사
        int blockY = y/3*3;
        int blockX = x/3*3;
        // System.out.println(blockY+" ~ "+(blockY+3));
        // System.out.println(blockX+" ~ "+(blockX+3));
        boolean[] check = new boolean[10]; // 1 ~ 9
        check[num] = true;
        for(int i = blockY; i < blockY + 3; i++) {
            for(int j = blockX; j < blockX + 3; j++) {
                int cur = map[i][j];
                if(cur != 0 && check[cur] == true) {
                    return false;
                } else {
                    check[cur] = true;
                }
            }
        }
        return true;
    }
    public static boolean checkRow(int y, int x, int num) {
        boolean[] check = new boolean[10]; // 1 ~ 9
        check[num] = true;
        for(int i = 0; i < 9; i++) {
            int cur = map[y][i];
            if(cur != 0 && check[cur] == true) {
                return false;
            } else {
                check[cur] = true;
            }
        }
        return true;
    }
    public static boolean checkCol(int y, int x, int num) {
        boolean[] check = new boolean[10]; // 1 ~ 9
        check[num] = true;
        for(int i = 0; i < 9; i++) {
            int cur = map[i][x];
            if(cur != 0 && check[cur] == true) {
                return false;
            } else {
                check[cur] = true;
            }
        }
        return true;
    }
}