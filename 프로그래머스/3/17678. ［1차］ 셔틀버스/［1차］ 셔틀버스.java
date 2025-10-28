import java.util.*;
// 10:00
class Solution {
    public String solution(int n, int t, int m, String[] timeStr) {
        int[] time = new int[timeStr.length];
        for(int i = 0; i < time.length; i++) {
            String[] cur = timeStr[i].split(":");
            time[i] = (Integer.parseInt(cur[0]) * 60) + Integer.parseInt(cur[1]);
        }
        Arrays.sort(time);
        
        int start = 540; // 09:00
        int seq = 0;
        for(int i = 0; i < n; i++) {
            int cnt = 0;
            int startSeq = seq;
            while(seq < time.length && time[seq] <= start && cnt < m) {
                cnt++;
                seq++;
            }
            
            if(i == n - 1) {
                if(cnt == m) {
                    int answerTime = time[startSeq + (m - 1)] - 1;
                    return getTimeStr(answerTime);
                }
            }
            
            start += t;
        }
        start -= t; // 마지막 출발 시간
        int answerTime = start;
        return getTimeStr(answerTime);
    }
    public String getTimeStr(int time) {
        int hour = time / 60;
        int min = time % 60;
        String hourStr = (hour < 10) ? "0"+hour : ""+hour;
        String minStr = (min < 10) ? "0"+min : ""+min;
        return hourStr+":"+minStr;
    }
}