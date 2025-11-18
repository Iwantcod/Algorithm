class Solution {
    public int[] solution(int n, int s) {
        if(n > s) {
            return new int[]{-1};
        }
        
        int[] arr = new int[n];
        int p = arr.length - s % n;
        for(int i = 0; i < n; i++) {
            arr[i] = s/n;
            if(i >= p) {
                arr[i]++;
            }
        }
        return arr;
    }
}