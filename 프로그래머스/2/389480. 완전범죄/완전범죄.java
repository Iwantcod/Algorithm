import java.util.*;

class Solution {
    public int[][] info;
    public boolean[] visited;
    public Set<String> set = new HashSet<>();
    public int min = Integer.MAX_VALUE;
    public int originA;
    public int solution(int[][] info, int n, int m) {
        this.info = info;
        this.visited = new boolean[info.length];
        this.originA = n;
        
        dfs(0, n - info[0][0], m);
        dfs(0, n, m - info[0][1]);
        if(min == Integer.MAX_VALUE) {
            return -1;
        } else {
            return min;
        }
        
    }
    public void dfs(int start, int n, int m) {
        if(n <= 0 || m <= 0) {
            return;
        }
        if(originA - n > min) return;
        
        if(start + 1 == info.length) {
            // System.out.println(n+" "+m);
            min = Math.min(min, originA - n);
            return;
        }
        
        String key = ""+start+" "+n+" "+m;
        if(!set.contains(key)) {
            set.add(key);
            dfs(start + 1, n - info[start+1][0], m);
            dfs(start + 1, n, m - info[start+1][1]);   
        }
    }
}