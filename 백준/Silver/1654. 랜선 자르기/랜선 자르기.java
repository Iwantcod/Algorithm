import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sp = br.readLine().split(" ");
        int k = Integer.parseInt(sp[0]);
        int n = Integer.parseInt(sp[1]);
        int[] arr = new int[k];
        long right = 0, left = 1;
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i] > right) right = arr[i];
        }

        long mid = 0;
        while(left <= right) {
            long cnt = 0;

            mid = (left + right) / 2;

            for(int i = 0; i < arr.length; i++) {
                cnt += arr[i] / mid;
            }
            if(cnt >= n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        bw.write(String.valueOf(left - 1));
        bw.close();
    }
}