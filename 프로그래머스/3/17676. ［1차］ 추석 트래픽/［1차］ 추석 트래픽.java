// 23:16
class Solution {
    public int solution(String[] lines) {
        // 2000*2000 = 4,000,000 => 작은 횟수이므로 n^2로 처리한다.
        
        // (기준 종료 시간 + 999) 의 값보다 시작 시간이 같거나 작은 '자신 이후의 시간대의 개수'를 센다.
        
        long[][] time = new long[lines.length][2];
        for(int i = 0; i < lines.length; i++) {
            String[] str = lines[i].substring(11, 23).split(":");
            long h = Long.parseLong(str[0]) * 1000 * 60 * 60;
            long m = Long.parseLong(str[1]) * 1000 * 60;
            long s = (long)(Double.parseDouble(str[2]) * 1000);
            long t = (long)(Double.parseDouble(lines[i].substring(24, lines[i].length() - 1)) * 1000);
            time[i][0] = (h+m+s) - t + 1;
            time[i][1] = h+m+s;
        }
        
        int answer = 0;
        for(int i = 0; i < time.length; i++) {
            int cnt = 1; // 자기 자신도 카운팅
            long st = time[i][1] + 999;
            for(int j = i + 1; j < time.length; j++) {
                if(time[j][0] <= st) {
                    cnt++;
                }
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }
}