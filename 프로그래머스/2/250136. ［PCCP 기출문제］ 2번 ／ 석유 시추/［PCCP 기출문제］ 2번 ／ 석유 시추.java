import java.util.*;

class Solution {
    public static int[][] land; // 각 매장 영역을 식별자로 표시
    public static int[] info; // 각 매장 영역의 크기 정보(매장 영역 식별: 인덱스 번호)
    public static int areaNum; // 매장 영역 식별에 사용될 식별자
    public static Queue<int[]> q = new LinkedList<>();
    public int solution(int[][] land) {
        areaNum = 2;
        this.land = land.clone();
        info = new int[land.length * land[0].length / 2 + 3];
        
        if(land.length == 1){
            return 1;
        } else if(land[0].length == 1) {
            int cnt = 0;
            for(int i = 0; i < land.length; i++) {
                if(land[i][0] == 1) {
                    cnt++;
                }
            }
            return cnt;
        }
        
        // 방문하지 않은 영역을 bfs하여 각 영역의 크기와 범위(범위 식별자)를 map[][]에 기록
        for(int i = 0; i < land.length; i++) {
            for(int j = 0; j < land[0].length; j++) {
                if(land[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }
        
        int answer = 0;
        
        for(int i = 0; i < land[0].length; i++) {
            boolean[] visitedArea = new boolean[info.length];
            int curResult = 0;
            for(int j = 0; j < land.length; j++) {
                if(land[j][i] > 0 && !visitedArea[land[j][i]]) {
                    visitedArea[land[j][i]] = true;
                    curResult += info[land[j][i]];
                }
            }
            if(curResult > answer) {
                answer = curResult;
            }
        }
        
        return answer;
    }
    
    public static void bfs(int i, int j) {
        int cnt = 0; // 해당 영역의 크기
        q.add(new int[]{i, j});
        land[i][j] = areaNum; // 영역 식별자로 areaNum 변수 사용
        cnt++;
        
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[0] > 0) {
                if(land[cur[0]-1][cur[1]] == 1) {
                    q.add(new int[]{cur[0]-1, cur[1]});
                    land[cur[0]-1][cur[1]] = areaNum;
                    cnt++;
                }
                
            }
            if(cur[0] < land.length - 1) {
                if(land[cur[0]+1][cur[1]] == 1) {
                    q.add(new int[]{cur[0]+1, cur[1]});
                    land[cur[0]+1][cur[1]] = areaNum;
                    cnt++;
                }
            }
            if(cur[1] > 0) {
                if(land[cur[0]][cur[1]-1] == 1) {
                    q.add(new int[]{cur[0], cur[1]-1});
                    land[cur[0]][cur[1]-1] = areaNum;
                    cnt++;
                }
                
            }
            if(cur[1] < land[0].length - 1) {
                if(land[cur[0]][cur[1]+1] == 1) {
                    q.add(new int[]{cur[0], cur[1]+1});
                    land[cur[0]][cur[1]+1] = areaNum;
                    cnt++;
                }
                
            }
        }
    
        info[areaNum] = cnt; // 영역 크기를 info[]에 기록
        areaNum++; // 다음 영역 식별자로 사용하기 위해 areaNum 1 증가
    }
}