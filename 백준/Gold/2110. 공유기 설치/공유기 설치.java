import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sp = br.readLine().split(" ");
        int n = Integer.parseInt(sp[0]);
        int c = Integer.parseInt(sp[1]);
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            int cur = Integer.parseInt(br.readLine());
            arr[i] = cur;
        }
        Arrays.sort(arr);

        // 공유기 간격은 모두 '최소 간격' 이상이어야 한다.
        // 첫번째 집에 놓고, 이 '최소 간격'으로 공유기를 계속해서 놓는다.
        // 최종적으로 설치된 공유기 수가 c 이상이라면 '최소 간격'을 줄인다. 반대의 경우 늘린다.
        // 이 과정을 반복해서 answer을 도출한다.
        int left = 1;
        int right = arr[n-1] - arr[0];
        int answer = 0;

        while(left <= right) {
            int mid = (left + right) / 2;
            int tmp = 1;
            int lastWifiIndex = 0;
            for(int i = 1; i < n; i++) {
                if(arr[i] - arr[lastWifiIndex] >= mid) {
                    lastWifiIndex = i;
                    tmp++;
                }
            }

            if(tmp >= c) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
        
    }
}
