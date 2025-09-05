import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sp = br.readLine().split(" ");
        int n = Integer.parseInt(sp[0]);
        int k = Integer.parseInt(sp[1]);
        int[] arr = new int[n+1];
        arr[0] = 1;
        for(int i = 1; i <= n; i++) {
            arr[i] = arr[i-1] * i;
        }

        int result = arr[n] / (arr[n-k] * arr[k]);
        bw.write(String.valueOf(result));
        bw.close();
    }
}