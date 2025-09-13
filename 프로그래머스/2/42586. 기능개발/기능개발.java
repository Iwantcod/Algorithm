// 13:10 시작
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int day = (int)Math.ceil((double)(100 - progresses[0]) / speeds[0]);
        if(progresses.length == 1) {
            return new int[]{day};
        }
        int cnt = 1;
        List<Integer> list = new ArrayList<>();
        
        for(int i = 1; i < progresses.length; i++) {
            int last = 100 - progresses[i] - (speeds[i] * day);
            if(last > 0) {
                list.add(cnt);
                day += (int)Math.ceil((double)last / speeds[i]);
                cnt = 1;
            } else {
                cnt++;
            }
        }
        list.add(cnt);
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}