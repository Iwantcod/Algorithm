import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sp = br.readLine().split(" ");
        int k = Integer.parseInt(sp[0]);
        int n = Integer.parseInt(sp[1]);
        int[][] arr = new int[2][7];
        
        for(int i = 0; i < k; i++) {
            sp = br.readLine().split(" ");
            int gender = Integer.parseInt(sp[0]);
            int grade = Integer.parseInt(sp[1]);
            arr[gender][grade]++;
        }

        int result = 0;
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 7; j++) {
                if(arr[i][j] > 0) {
                    result += Math.ceil(arr[i][j] / (n * 1.0));
                }
            }
        }
        bw.write(String.valueOf(result));
        bw.close();
    }
}