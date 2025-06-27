class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] result = new int[2];
        
        int sum = sequence[0];
        int tmpLength = 1;
        int minLength = Integer.MAX_VALUE;
        
        int p = 0, q = 0;
        
        while(p <= q) {
            if(sum < k && q+1 < sequence.length) {
                q++;
                sum += sequence[q];
                tmpLength++;
            } else if(sum > k) {
                sum -= sequence[p];
                p++;
                tmpLength--;
            } else if(sum == k) {
                if(tmpLength < minLength) { // 길이가 더 짧다면 갱신
                    minLength = tmpLength;
                    result[0] = p;
                    result[1] = q;
                } else if(tmpLength == minLength && p < result[0]) {
                    // 길이는 같으나 부분수열 시작 인덱스번호가 더 작다면 갱신
                    result[0] = p;
                    result[1] = q;
                }
                
                // 다음 계산을 위해 p 1칸 증가
                sum -= sequence[p];
                p++;
                tmpLength--;
            } else {
                break;
            }
            
        }
        
        return result;
    }
}