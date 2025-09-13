// 13:10 시작
// 13:36 종료
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 첫번째 작업을 완료시킨 다음 이후의 작업을 계산
        // 작업을 완료하기 위해 소요된 기간(첫번째 작업 기준으로 초기화)
        int day = (int)Math.ceil((double)(100 - progresses[0]) / speeds[0]);
        if(progresses.length == 1) {
            return new int[]{day};
        }
        int cnt = 1; // 각 배포마다 배포되는 현재까지 완료된 작업의 개수. 첫번째 작업을 완료했다 가정하고 1로 초기화
        List<Integer> list = new ArrayList<>();
        
        // 두번째 작업부터 마지막 작업까지 순회
        for(int i = 1; i < progresses.length; i++) {
            // 현재 작업의 남은 작업량 계산
            int last = 100 - progresses[i] - (speeds[i] * day);
            if(last > 0) {
                // 작업을 완료할 수 없다면 이때까지 완료된 작업을 배포
                list.add(cnt);
                // 현재 작업을 완료하기 위해 필요한 추가 기간 계산 후 완료처리
                day += (int)Math.ceil((double)last / speeds[i]);
                cnt = 1; // 완료처리한 현재 작업을 카운팅
            } else {
                cnt++; // 작업을 완료할 수 있다면 카운팅
            }
        }
        list.add(cnt); // 루프가 종료된 이후 마지막 배포 수행
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}