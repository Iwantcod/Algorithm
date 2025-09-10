import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        if(n % 5 == 0) {
            cnt = n/5;
            n = 0;
        } else {
             while(n > 0) {
                n -= 3;
                cnt++;
                if(n > 0 && n % 5 == 0) {
                    cnt += n/5;
                    n = 0;
                }
            }
        }
        if(n == 0) {
            bw.write(String.valueOf(cnt));    
        } else {
            bw.write("-1");
        }
        bw.close();
    }
}