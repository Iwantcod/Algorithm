import java.util.*;

class Solution {
    public static HashMap<String, Integer> map;
    public static Set<String> set;
    public int solution(String[] want, int[] number, String[] discount) {
        map = new HashMap<>();
        // want 요소를 map에 추가
        for(int i = 0; i < want.length; i++) {
            if(map.containsKey(want[i])) {
                map.put(want[i], map.get(want[i]) + 1);
            } else {
                map.put(want[i], number[i]);
            }
        }
        set = map.keySet();
        int result = 0;
        
        for(int i = 0; i < 10; i++) {
            if(map.containsKey(discount[i])) {
                map.put(discount[i], map.get(discount[i]) - 1);
            }
        }
        if(isPossible()) {
            result++;
        }
        
        int l = 0;
        for(int r = 10; r < discount.length; r++) {
            if(map.containsKey(discount[l])) {
                map.put(discount[l], map.get(discount[l]) + 1);
            }
            l++;
            if(map.containsKey(discount[r])) {
                map.put(discount[r], map.get(discount[r]) - 1);
            }
            
            if(isPossible()) {
                result++;
            }
        }
        
        return result;
    }
    
    public boolean isPossible() {
        for(String cur : set) {
            if(map.get(cur) > 0) {
                return false;
            }
        }
        return true;
    }
}