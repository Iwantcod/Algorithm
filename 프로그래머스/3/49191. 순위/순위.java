class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] win = new boolean[n+1][n+1];
        for(int i = 0; i < results.length; i++) {
            int winner = results[i][0];
            int loser = results[i][1];
            win[winner][loser] = true;
        }
        
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                if(!win[i][k]) continue;
                for(int j = 1; j <= n; j++) {
                    if(win[k][j]) {
                        // i번 선수가 k번 선수를 이겼고, k번 선수가 j번 선수를 이긴 경우
                        // i번 선수가 j번 선수를 이긴 것으로 간주(승리 결과 전파)
                        win[i][j] = true;
                    }
                }
            }
        }
        
        int answer = 0;
        for(int i = 1; i <= n; i++) {
            int cnt = 0;
            for(int j = 1; j <= n; j++) {
                if(i == j) continue;
                if(win[i][j] || win[j][i]) {
                    cnt++;
                }
            }
            if(cnt == n-1) {
                answer++;
            }
        }
        
        return answer;
    }
}