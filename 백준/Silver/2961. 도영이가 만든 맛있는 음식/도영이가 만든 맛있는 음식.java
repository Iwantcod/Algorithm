import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static int n, min = Integer.MAX_VALUE;
    public static int[] sAry;
    public static int[] bAry;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        sAry = new int[n];
        bAry = new int[n];
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            String[] st = br.readLine().split(" ");
            int s = Integer.parseInt(st[0]);
            int b = Integer.parseInt(st[1]);
            sAry[i] = s;
            bAry[i] = b;
        }
        dfs(0, 1, 0);
        bw.write(String.valueOf(min));
        bw.close();
    }
    public static void dfs(int depth, int calS, int sumB) {
        // System.out.println("calS: "+calS+" sumB: "+sumB);

        int tmp = calS - sumB;
        if(tmp < 0) tmp *= -1;
        if(min > tmp && sumB > 0) {
            min = tmp;
            // System.out.println("update: "+tmp);
        }
        if(depth == n) {  
            return;
        }
        for(int i = 0; i < n; i++) {
            if(visited[i] == false) {
                visited[i] = true;
                dfs(depth + 1, calS * sAry[i], sumB + bAry[i]);
                visited[i] = false;
            }
        }
    }
}