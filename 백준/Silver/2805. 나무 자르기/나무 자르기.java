import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sp = br.readLine().split(" ");
        int n = Integer.parseInt(sp[0]);
        long m = Long.parseLong(sp[1]);

        long l = 0;
        long r = 0;
        long[] tree = new long[n];
        String[] sp2 = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            tree[i] = Long.parseLong(sp2[i]);
            r = Math.max(r, tree[i]);
        }
        long answer = r;

        while(l <= r) {
            long mid = (l+r)/2;
            long sum = 0;
            for(int i = 0; i < n; i++) {
                long get = tree[i] - mid;
                if(get > 0) {
                    sum += get;
                }
            }

            if(sum >= m) {
                answer = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }
}