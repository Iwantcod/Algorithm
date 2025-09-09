import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        if(N == 0) {
            bw.write("0");
        } else {
            while(N != 1) {
                sb.append(Math.abs(N % -2));
                N = (int)Math.ceil(N/-2.0);
            }
            sb.append(N);
        }
        bw.write(sb.reverse().toString());
        bw.close();
    }
}