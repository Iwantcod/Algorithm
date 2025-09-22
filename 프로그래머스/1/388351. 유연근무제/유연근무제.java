// 15:31 시작

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        for(int i = 0; i < schedules.length; i++) {
            int min = schedules[i] % 100;
            int hour = schedules[i] / 100;
            min += 10;
            if(min >= 60) {
                hour++;
                min -= 60;
            }
            schedules[i] = (hour * 100) + min;
        }
        
        int day = startday - 1;
        int result = schedules.length;
        for(int i = 0; i < 7; i++) {
            if(day == 5) {
                i++;
                day = 0;
                continue;
            } else if(day == 6) {
                day = 0;
                continue;
            }
            for(int j = 0; j < timelogs.length; j++) {
                if(timelogs[j][i] > schedules[j]) {
                    // System.out.println(timelogs[j][i]+" "+schedules[j]);
                    schedules[j] = Integer.MAX_VALUE;
                    // System.out.println("위반: "+j+" "+i);
                    result--;
                }
            }
            day++;
        }

        return result;
    }
}