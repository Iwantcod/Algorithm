import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] ary = new int[20_000_001]; // 0 ~ 2천만
        String[] spN = br.readLine().split(" ");
        for(int i = 0; i < spN.length; i++) {
            int idx = Integer.parseInt(spN[i]) + 10_000_000;
            ary[idx]++;
        }

        int m = Integer.parseInt(br.readLine());
        String[] spM = br.readLine().split(" ");
        for(int i = 0; i < spM.length; i++) {
            int idx = Integer.parseInt(spM[i]) + 10_000_000;
            bw.write(String.valueOf(ary[idx])+" ");
        }
        bw.close();
    }
}