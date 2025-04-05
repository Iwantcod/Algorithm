import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static int[] arr;
    public static int cnt = 0;
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dfs(0);
        bw.write(String.valueOf(cnt));
        bw.close();
        
    }

    public static void dfs(int depth) {
        if(depth == n) {
            cnt++;
            return;
        }

        for (int i =0; i < n; i++) {
            arr[depth] = i;
            
            if(possible(depth)) {
                dfs(depth+1);
            }
        }
        
    }

    public static boolean possible(int col) {
        for (int i = 0; i < col; i++) {
            if(arr[i] == arr[col]) {
                return false;
            } else if(Math.abs(col-i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}