import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        // S, E 범위에 해당하는 숫자가 펠린드롬인지 검사하는 로직이 다른 질문에서도 중복될 수 있다.
        // ex) 첫번째 질문이 (2, 7)인데 두번째 질문이 (2, 8)인 경우, 첫번째 질문에서의 검증 과정이 완전히 중복 수행된다.
        // 각 수행 결과를 저장하는 배열을 통해 연산 횟수를 절약한다(dp)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] sp = br.readLine().split(" ");
        int[] arr = new int[n+1];
        for(int i = 0; i < sp.length; i++) {
            arr[i+1] = Integer.parseInt(sp[i]);
        }

        // dp[x][y]: x번째 숫자부터 y번째 숫자까지 펠린드롬 검사 결과
        boolean[][] dp = new boolean[n+1][n+1];

        for(int i = 1; i < n; i++) {
            dp[i][i] = true;
            dp[i][i+1] = arr[i] == arr[i+1];
        }
        dp[n][n] = true;

        int x = 2;
        while(x < n) {
            for(int i = 1; i < n; i++) {
                if(i+x <= n) {
                    dp[i][i+x] = arr[i] == arr[i+x] && dp[i+1][i+x-1];
                }
            }
            x++;
        }

        // for(int i = 1; i <= n; i++) {
        //     for(int j = 0; j < i; j++) {
        //         System.out.print(" ");
        //     }
        //     for(int j = i; j <= n; j++) {
        //         System.out.print((dp[i][j]) ? 1 : 0);
        //     }
        //     System.out.println();
        // }
        
        
        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
            String[] q = br.readLine().split(" ");
            int start = Integer.parseInt(q[0]);
            int end = Integer.parseInt(q[1]);
            bw.write(((dp[start][end]) ? "1" : "0") + "\n");
        }
        bw.close();
    }
}