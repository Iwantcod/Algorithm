import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sp = br.readLine().split(" ");
        int n = Integer.parseInt(sp[0]);
        int m = Integer.parseInt(sp[1]);

        long left = 1;
        long right = 0;
        long[] arr = new long[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
            right = Math.max(right, arr[i]);
        }
        right *= m;

        long answer = 0;

        while(left <= right) {
            long mid = (left + right) / 2;
            long tmp = 0;
            for(int i = 0; i < n; i++) {
                tmp += mid / arr[i];
                if(tmp >= m) {
                    break;
                }
            }

            if(tmp >= m) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
