import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sp = br.readLine().split(" ");
        int n = Integer.parseInt(sp[0]);
        int y = Integer.parseInt(sp[1]) + 1;
        int x = Integer.parseInt(sp[2]) + 1;

        System.out.println(s(n, y, x));
        
    }
    public static int s(int n, int y, int x) {
        if(n == 0) {
            return 0;
        }

        int len = (int)Math.pow(2, n);
        int size = len * len;
        // System.out.println("len: "+len+", "+y+" "+x);

        if(y <= len/2 && x <= len/2) {
            // System.out.println("1 사분면 진입");
            return s(n-1, y, x);
        } else if(y <= len/2 && x > len/2) {
            // System.out.println("2 사분면 진입, +"+(size * 1/4));
            return size/4 + s(n-1, y, x - len/2);
        } else if(y > len/2 && x <= len/2) {
            // System.out.println("3 사분면 진입, +"+(size * 2/4));
            return size/4*2 + s(n-1, y - len/2, x);
        } else {
            // System.out.println("4 사분면 진입, +"+(size * 3/4));
            return size/4*3 + s(n-1, y - len/2, x - len/2);
        }
    }
}