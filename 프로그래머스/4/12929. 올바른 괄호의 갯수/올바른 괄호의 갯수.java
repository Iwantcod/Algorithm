//13:05
import java.util.*;

class Solution {
    int len;
    int cnt;
    public int solution(int n) {
        this.len = n * 2;
        this.cnt = 0;
        
        dfs(0, 0);
        return cnt;
    }
    public void dfs(int depth, int v) {
        if(v < 0) return;
        
        if(depth == len) {
            if(v == 0) cnt++;
            return;
        }
        
        dfs(depth + 1, v + 1);
        dfs(depth + 1, v - 1);
    }
}