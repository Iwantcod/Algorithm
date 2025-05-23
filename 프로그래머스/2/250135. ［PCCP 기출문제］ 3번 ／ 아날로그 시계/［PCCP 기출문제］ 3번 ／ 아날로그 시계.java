import java.util.*;

class Solution {
    public static int cnt = 0;
    public static int sec;
    // 초당 이동: 초침은 3600씩 이동, 분침은 60씩 이동, 시침은 1씩 이동
    public static int[] min = new int[2]; // [0]: 분 숫자, [1]: 시계에서 초 단위의 위치 표시를 위한 좌표값 0 ~ 216000(60^3)
    public static int[] hour = new int[2]; // [0]: 시 숫자, [1]: 시계에서 초 단위의 위치 표시를 위한 좌표값 0 ~ 216000
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        sec = s1*3600; // 초침 좌표. 1분: 216000, 1초: 3600
        min[0] = m1;
        min[1] = m1*3600 + s1*60; // 분침 좌표. 1시간: 216000, 1분: 3600, 1초: 60
        hour[0] = h1;
        hour[1] = (h1%12)*18000 + m1*300 + s1*5; // 시침 좌표. 12시간: 216000, 1시간: 18000, 1분: 300, 1초: 5
        
        if(sec == min[1] && min[1] == hour[1]) {
            // 연산 시작 전 '시작 시간'의 분침 및 시침과의 일치 여부 검증
            cnt++;
        }
        
        int range = (s2 >= sec/3600) ? s2-sec/3600 : (s2+60)-sec/3600;
        for(int i = 0; i < range; i++) {
            timeup();
        }
        
        range = (m2 >= min[0]) ? m2-min[0] : (m2+60)-min[0];
        for(int i = 0; i < range*60; i++) {
            timeup();
        }
        
        range = h2 - hour[0];
        for(int i = 0; i < range*60*60; i++) {
            timeup();
        }
        return cnt;
    }
    
    // 현재 침 위치 파악 -> 시간 1초 증가 -> 초침이 다른 침과 위치가 같거나 지나갔음을 검증
    public static void timeup() {
        boolean smallerThanMin = sec < min[1];
        boolean smallerThanHour = sec < hour[1];
        sec += 3600;
        min[1] += 60;
        hour[1] += 5;
        
        if(sec == min[1] && min[1] == hour[1]) {
            // 두 침을 동시에 만난 경우
            cnt++;
        } else {
            // 분침 만난 경우
            if(smallerThanMin && sec >= min[1]) {
                cnt++;
            }
            // 시침 만난 경우
            if(smallerThanHour && sec >= hour[1]) {
                cnt++;
            }
        }
        if(sec == 216000) {
            sec = 0;
            min[0]++;
        }
        if(min[1] == 216000) {
            min[1] = 0;
            min[0] = 0;
            hour[0]++;
        }
        if(hour[1] == 216000) {
            hour[1] = 0;
        }
        
        
    }
}