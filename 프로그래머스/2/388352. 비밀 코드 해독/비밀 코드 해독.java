class Solution {
    public static int[][] map;
    public static int[] cntArr;
    public static boolean[] cur;
    public static int n;
    public static int total = 0;
    public int solution(int n, int[][] q, int[] ans) {
        map = q.clone();
        cntArr = ans.clone();
        cur = new boolean[n+1];
        this.n = n;
        
        dfs(0, 1);
        return total;
    }
    
    public static void dfs(int depth, int start) {
        if(depth == 5) {
            boolean result = true;
            
            for(int i = 0; i < map.length; i++) {
                int goal = cntArr[i];
                for(int j = 0; j < 5; j++) {
                    if(cur[map[i][j]]) { // q의 배열 원소 하나와 일치할때마다 카운트 1 감소
                        goal--;
                    }
                }
                if(goal != 0) { // '시도 경우의 수'의 '일치하는 숫자 수'를 한번이라도 만족하지 못하면 false
                    result = false;
                    break;
                }
            }
            if(result) {
                total++;
                // for(int i = 1; i<=n; i++) {
                //     if(cur[i]) {
                //         System.out.print(i+" ");
                //     }
                // }
                // System.out.println();
            }
            return;
        }
        
        for(int i = start; i <= n-4+depth; i++) {
            cur[i] = true;
            dfs(depth+1, i+1);
            cur[i] = false;
        }
    }
}