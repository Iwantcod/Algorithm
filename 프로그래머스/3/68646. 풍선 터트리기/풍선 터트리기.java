// 11:29
class Solution {
    public int solution(int[] a) {
        if(a.length <= 2) {
            return a.length;
        }
        int[] minAsc = new int[a.length];
        minAsc[0] = a[0];
        int[] minDesc = new int[a.length];
        minDesc[a.length - 1] = a[a.length - 1];
        
        for(int i = 1; i < a.length; i++) {
            minAsc[i] = Math.min(a[i], minAsc[i-1]);
            int descIndx = a.length - i - 1;
            minDesc[descIndx] = Math.min(a[descIndx], minDesc[descIndx+1]);
        }
        
        int answer = 2;
        for(int i = 1; i < a.length - 1; i++) {
            int cur = a[i];
            int leftMin = minAsc[i-1];
            int rightMin = minDesc[i+1];
            if(leftMin > cur || rightMin > cur) {
                answer++;
            }
        }
        
        return answer;
    }
}