import java.util.*;

class Solution {
    public static int[][] d;
    public static int k, maxCnt = 0;
    public static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        this.k = k;
        this.d = dungeons;
        this.visited = new boolean[d.length];
        if(d.length == 1) {
            if(k >= d[0][0]) {
                return 1;
            } else {
                return 0;
            }
        }
        
        dfs(k, 0, 0);
        return maxCnt;
    }
    
    // curK: 현재 남은 피로도
    // cnt: 현재 던전 방문 횟수
    public void dfs(int curK, int cnt, int depth) {
        if(depth == d.length) {
            // 모든 던전 순회했다면 out
            // System.out.println("----");
            maxCnt = Math.max(cnt, maxCnt);
            return;
        }
        
        for(int i = 0; i < d.length; i++) {
            if(visited[i] == false) {
                visited[i] = true;
                if(curK - d[i][0] >= 0) {
                    // System.out.println(i+" "+(cnt + 1));
                    dfs(curK - d[i][1], cnt + 1, depth + 1);
                } else {
                    // System.out.println(i+" "+cnt);
                    dfs(curK, cnt, depth + 1);
                }
                visited[i] = false;
            }
        }
    }
}