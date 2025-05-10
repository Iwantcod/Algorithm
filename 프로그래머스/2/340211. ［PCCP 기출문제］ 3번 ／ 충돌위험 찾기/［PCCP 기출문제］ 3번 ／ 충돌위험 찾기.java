import java.util.*;
class Solution {
    public int solution(int[][] points, int[][] routes) {
        // 각 시간대 별로 '모든 로봇 위치' 정보를 가지는 리스트를 원소로 가지는 리스트 선언
        List<List<int[]>> node = new ArrayList<>();
        
        // 이론상 존재할 수 있는 모든 시간대의 로봇 위치값을 저장
        for(int i = 0; i < 1000000; i++) {
            List<int[]> list = new ArrayList<>();
            // list.add(new int[]{0, 0}); // 모든 시간대 리스트에 대해 리스트 선언하고 초기값을 넣어둔다.
            node.add(list);
        }
        
        for(int[] robot : routes) {
            int time = 0;
            
            for(int i = 0; i < robot.length - 1; i++) {
                int r = points[robot[i] - 1][0];
                int c = points[robot[i] - 1][1];
                
                if(i == 0) {
                    int[] now = new int[]{r, c};
                    node.get(time++).add(now);
                }
                
                int next_r = points[robot[i+1] - 1][0];
                int next_c = points[robot[i+1] - 1][1];
                
                if(next_r < r) { // 세로 이동 먼저 계산
                    int size = r - next_r;
                    for(int j = 0; j < size; j++) {
                        int[] rc = new int[]{--r, c};
                        node.get(time++).add(rc);
                    }
                } else if(next_r > r) {
                    int size = next_r - r;
                    for(int j = 0; j < size; j++) {
                        int[] rc = new int[]{++r, c};
                        node.get(time++).add(rc);
                    }
                }
                
                if(next_c < c) { // 가로 이동 계산
                    int size = c - next_c;
                    for(int j = 0; j < size; j++) {
                        int[] rc = new int[]{r, --c};
                        node.get(time++).add(rc);
                    }
                } else if(next_c > c) {
                    int size = next_c - c;
                    for(int j = 0; j < size; j++) {
                        int[] rc = new int[]{r, ++c};
                        node.get(time++).add(rc);
                    }
                }
            }
        }
        
        int cnt = 0;
        
        for(List<int[]> list : node) {
            HashMap<String, Integer> map = new HashMap<>();
            for(int[] p : list) {
                String key = p[0]+"-"+p[1];
                
                // map.getOrDefault(): 첫번째 인자를 키로 가지는 값을 검색 -> 존재하지 않으면 0 반환
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            
            for(String key : map.keySet()) {
                if(map.get(key) != 1) {
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}