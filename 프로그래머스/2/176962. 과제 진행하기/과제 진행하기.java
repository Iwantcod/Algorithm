import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        int resultIndex = 0;
        String[] result = new String[plans.length];
        
        HashMap<Integer, String> map = new HashMap<>();
        Stack<Integer> stackInt = new Stack<>();
        
        // 00:00 ~ 23:59 -> 0 ~ 1440 인덱스로 치환, 남은 playtime 값 저장
        int[] timeLine = new int[1440];
        
        for(String[] p : plans) {
            String name = p[0];
            StringTokenizer st = new StringTokenizer(p[1], ":"); // ":" 문자열 기준으로 시간 숫자 추출
            int start = Integer.parseInt(st.nextToken())*60 + Integer.parseInt(st.nextToken());
            int playtime = Integer.parseInt(p[2]);
            
            map.put(start, name);
            timeLine[start] = playtime;
        }
        
        // 00:00 ~ 23:59까지 순회하며 과제 계획(start)이 잡혀있는지 검증한다.
        // 계획을 발견하면 해당 인덱스(시간 값)를 스택에 추가한다.
        // 스택이 비지 않았을 경우, 스택 최상단의 시간 값에 해당하는 과제의 playtime을 1씩 감소한다.
        // playtime이 0이 되면 해당 과제를 pop하고, 과제의 start 시간에 해당하는 문자열 값을 map에서 찾아 결과 배열에 추가한다.
        for(int i = 0; i < timeLine.length; i++) {
            if(!stackInt.isEmpty()) {
                int index = stackInt.peek();
                timeLine[index]--;
                if(timeLine[index] == 0) {
                    int pop = stackInt.pop();
                    result[resultIndex] = map.get(pop);
                    resultIndex++;
                }
            }
            
            if(timeLine[i] != 0) {
                stackInt.push(i);
            }
        }
        
        if(!stackInt.isEmpty()) {
            while(!stackInt.isEmpty()) {
                int pop = stackInt.pop();
                result[resultIndex] = map.get(pop);
                resultIndex++;
            }
        }
        
        return result;
    }
}