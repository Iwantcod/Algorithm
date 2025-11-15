import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        if(n <= 2) {
            bw.write("0");
            bw.close();
            return;
        }
        
        String[] sp = br.readLine().split(" ");
        long[] arr = new long[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(sp[i]);
        }
        Arrays.sort(arr);
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            int p = 0;
            int q = n-1;
            if(p == i) p++;
            if(q == i) q--;
            long cur = arr[i];
            while(p < q) {
                long sum = arr[p] + arr[q];
                if(sum == cur) {
                    cnt++;
                    break;
                }
                if(sum > cur) {
                    q--;
                    if(q == i) q--;
                } else {
                    p++;
                    if(p == i) p++;
                }
            }
        }
        bw.write(String.valueOf(cnt));
        bw.close();
    }
}