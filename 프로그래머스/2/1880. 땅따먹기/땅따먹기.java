class Solution {
    int solution(int[][] land) {
        for(int i = 1; i < land.length; i++) {
            for(int j = 0; j < 4; j++) {
                int max = 0;
                for(int k = 0; k < 4; k++) {
                    if(k == j) continue;
                    max = Math.max(land[i-1][k], max);
                }
                land[i][j] += max;
            }
        }

        int answer = 0;
        int n = land.length;
        for(int i = 0; i < 4; i++) {
            answer = Math.max(land[n-1][i], answer);
        }
        return answer;
    }
}