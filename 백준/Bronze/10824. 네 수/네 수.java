import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sp = br.readLine().split(" ");
        long result = Long.parseLong(sp[0] + sp[1]) + Long.parseLong(sp[2] + sp[3]);
        bw.write(String.valueOf(result));
        bw.close();
    }
}