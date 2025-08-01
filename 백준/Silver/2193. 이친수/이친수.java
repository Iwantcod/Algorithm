import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long result = 0;
        if(n < 3) {
            result = 1;
        } else {
            long[] arr = new long[n+1];
            arr[1] = 1; arr[2] = 1;
            for(int i = 3; i < arr.length; i++) {
                arr[i] = arr[i-1] + arr[i-2];
            }
            result = arr[n];
        }

        bw.write(String.valueOf(result));
        bw.close();
    }
}