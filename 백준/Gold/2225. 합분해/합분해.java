import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);
        int mod = 1000000000;

        int[][] arr = new int[n+1][k+1];
        for(int i = 0; i <= n; i++) {
            arr[i][1] = 1; // 숫자 1개로 n을 만들 수 있는 경우의 수는 1가지 뿐이다.
        }

        for(int i = 0; i <= k; i++) {
            arr[1][i] = i; // 1을 만들 수 있는 경우의 수는 해당되는 k 숫자와 같다.
        }

        for(int i = 2; i <= n; i++) {
            for(int j = 2; j <= k; j++) {
                // arr[i][j]를 구하는 점화식
                arr[i][j] = (arr[i][j-1] + arr[i-1][j]) % mod;
            }
        }

        bw.write(String.valueOf(arr[n][k]));
        bw.close();
    }
}
    