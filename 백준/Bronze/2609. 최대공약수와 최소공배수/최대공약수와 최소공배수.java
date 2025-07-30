import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);

        if(a == b) {
            bw.write(String.valueOf(a)+"\n");
            bw.write(String.valueOf(a));
        } else {
            int big = Math.max(a,b);
            int small = Math.min(a,b);
            for(int i = small; i > 0; i--) {
                if(big % i == 0 && small % i == 0) {
                    bw.write(String.valueOf(i)+"\n");
                    break;
                }
            }

            int limit = big;
            int min = 0;
            int max = 0;
            for(int i = 1; i <= limit; i++) {
                min += small;
                if(max < min) {
                    max += big;
                }
                if(min == max) {
                    bw.write(String.valueOf(max));
                    break;
                }
            }
        }
        bw.close();        
    }
}