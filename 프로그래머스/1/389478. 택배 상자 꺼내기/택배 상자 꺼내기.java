import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int[] layer = new int[n+1];
        List<Integer>[] arr = new ArrayList[w];
        for(int i = 0; i < w; i++) {
            arr[i] = new ArrayList<>();
        }
        
        int line = 0;
        boolean mode = true;
        for(int i = 1; i <= n; i++) {
            layer[i] = line;
            arr[line].add(i);
            if(mode) {
                line++;
                if(line == w) {
                    line--;
                    mode = !mode;
                }
            } else {
                line--;
                if(line < 0) {
                    line++;
                    mode = !mode;
                }
            }
        }
        
        int target = layer[num];
        int answer = 0;
        for(int i = 0; i < arr[target].size(); i++) {
            if(arr[target].get(i) >= num) {
                answer++;
            }
        }
        
        return answer;
    }
}