import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        if(n % 5 == 0) {
            bw.write(String.valueOf(n/5));
            bw.close();
            return;
        }

        int cnt5 = 0;
        int cnt3 = 0;
        cnt5 = n / 5;
        n %= 5;
        while(cnt5 >= 0) {
            if(n % 3 == 0) {
                cnt3 += n / 3;
                break;
            } else {
                cnt5--;
                n += 5;
            }
        }

        bw.write(String.valueOf(cnt5 + cnt3));
        bw.close();
    }
}