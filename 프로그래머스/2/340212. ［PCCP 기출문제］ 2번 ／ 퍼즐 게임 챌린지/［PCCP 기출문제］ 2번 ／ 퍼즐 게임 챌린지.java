class Solution {
    public static long limit, defaultValue;
    public static int[] diffs;
    public static int[] times;
    public static int[] plusTime;
    public static int minLevel;
    public int solution(int[] diffs, int[] times, long limit) {
        // 퍼즐의 개수가 하나이면 1 반환(diffs[0]은 반드시 1이다)
        if(diffs.length == 1) {
            return 1;
        }
        this.diffs = diffs; // 난이도 배열
        this.times = times; // 소요 시간 배열
        this.defaultValue = times[0]; // 모든 소요 시간값의 총합을 저장할 값
        this.minLevel = diffs[0]; // 정답으로 반환할 최소 레벨(숙련도) 값
        this.limit = limit; // 제한 시간
        int startLevel = diffs[0]; // 퍼즐 중 최고 난이도 숫자 값
        
        this.plusTime = new int[times.length]; // i번째 퍼즐 실패 시 총 소요시간에 더할 값 종류
        
        for(int i = 1; i < times.length; i++) {
            plusTime[i] = times[i] + times[i-1];
            
            if(diffs[i] > startLevel) { // 최고 난이도 값 갱신하는 조건문
                startLevel = diffs[i];
            }
            
            defaultValue += times[i]; // 이론상 가능한 최소 시간값을 구하는 코드
        }
        
        // times 내의 원소의 총합이 limit과 같다면 숙련도가 난이도의 최고값과 같아야만 시간제한을 맞출 수 있다.
        if(defaultValue == limit) {
            return startLevel;
        }
        
        binary(1, startLevel);
        return minLevel;
    }
    
    public static void binary(int startLevelRange, int endLevelRange) {
        if(endLevelRange - startLevelRange < 1) {
            return;
        } else if(endLevelRange - startLevelRange == 1) {
            if(cal(startLevelRange) <= limit) {
                minLevel = startLevelRange;
            } else {
                minLevel = endLevelRange;
            }
            return;
        }
        
        int middleLevel = (startLevelRange + endLevelRange)/2;
        long curTime = cal(middleLevel);
        
        if(curTime > limit) {
            binary(middleLevel, endLevelRange);
        } else if(curTime < limit) {
            minLevel = middleLevel;
            binary(startLevelRange, middleLevel);
        } else {
            minLevel = middleLevel;
        }
    }
    
    public static long cal(int level) {
        long curTime = defaultValue;
        for(int j = 0; j < diffs.length; j++) {
            if(diffs[j] > level) {
                curTime += plusTime[j]*(diffs[j] - level);
            }
        }
        return curTime;
    }
}