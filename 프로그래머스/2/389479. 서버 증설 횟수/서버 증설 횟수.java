class Solution {
    public int solution(int[] players, int m, int k) {
        int[] serverNum = new int[24];
        int cnt = 0;
        
        for(int i = 0; i < players.length; i++) {
            int curUserNum = players[i];
            int curServerNum = serverNum[i];
            int neededServerNum = curUserNum/m - curServerNum;
            
            if(neededServerNum > 0) {
                cnt += neededServerNum;
                for(int j = 0; j < k; j++) {
                    if(i+j < players.length) {
                        serverNum[i+j] += neededServerNum;   
                    }
                }
            }
        }
        return cnt;
    }
}