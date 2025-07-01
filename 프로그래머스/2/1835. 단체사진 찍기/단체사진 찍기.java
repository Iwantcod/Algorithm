import java.util.*;

class Solution {
    public static int[][] rule;
    public static int[] source = {0, 2, 5, 9, 12, 13, 17, 19}; // A, C, F, J, M, N, R, T를 의미
    public static boolean[] visited = new boolean[20]; // 0, 2, 5, 9, 12, 13, 17, 19 사용
    public static int[] result = new int[8];
    public static int cnt = 0;
    public static HashMap<Integer, Integer> map = new HashMap<>();
    
    public int solution(int n, String[] data) {
        // 각 규칙을 저장. 알파벳 2개: 아스키코드-62, 부호: 0(=), 1(<), 2(>), 간격
        rule = new int[n][4];
        
        for(int i = 0; i < n; i++) {
            rule[i][0] = (int)data[i].charAt(0) - 65;
            rule[i][1] = (int)data[i].charAt(2) - 65;
            char sign = data[i].charAt(3);
            if(sign == '=')
                rule[i][2] = 0;
            else if(sign == '<')
                rule[i][2] = 1;
            else if(sign == '>')
                rule[i][2] = 2;
            rule[i][3] = Integer.parseInt(data[i].substring(4, 5)) + 1;
            // System.out.println(rule[i][0]+" "+rule[i][1]+" "+rule[i][2]+" "+rule[i][3]);
        }
        
        dfs(0);
        int total = cnt;
        cnt = 0;
        return total;
    }
    
    public static void dfs(int depth) {
        if(depth == 8) {
            boolean isCorrect = true;
            // 각 규칙을 저장. 알파벳 2개: 아스키코드-62, 부호: 0(=), 1(<), 2(>), 간격
            for(int i = 0; i < result.length; i++) {
                map.put(result[i], i);
            }
            
            for(int j = 0; j < rule.length; j++) {
                int x = map.get(rule[j][0]);
                int y = map.get(rule[j][1]);
                int interval = rule[j][3]; // 목표 간격
                int cal = Math.abs(x - y); // 현재 계산된 두 알파벳의 간격
                switch(rule[j][2]) {
                    case 0:
                        if(cal != interval)
                            isCorrect = false;
                        break;
                    case 1:
                        if(cal >= interval)
                            isCorrect = false;
                        break;
                    case 2:
                        if(cal <= interval)
                            isCorrect = false;
                        break;
                }
            }
            if(isCorrect)
                cnt++;
            map.clear();
            return;
        }
        
        for(int i = 0; i < source.length; i++) {
            int cur = source[i];
            if(!visited[cur]) {
                visited[cur] = true;
                result[depth] = cur;
                dfs(depth + 1);
                
                visited[cur] = false;
            }
        }
    }
}