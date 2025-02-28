import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();

        int[][] ary = new int[a.length + 1][b.length + 1];


        // ary[i][j] 값을 찾는 방법
        // a[i] == b[j]이면, ary[i][j-1]에서 1을 더한 값을 기록
        // 그렇지 않다면, ary[i][j-1]값과 ary[i-1][j]값 중 더 큰 값을 기록

        for (int i = 1; i <= a.length; i++) {
            char tmpA = a[i - 1];
            for (int j = 1; j <= b.length; j++) {
                char tmpB = b[j - 1];
                if(tmpA == tmpB && ary[i][j-1] <= i-1) {
                    // 해당 문자를 두 문자열 모두에서 제외하고 LCS 비교했던 '시점'에서의 값에 1을 더한 값을 기록한다.
                    ary[i][j] = ary[i-1][j-1] + 1;
                } else {
                    ary[i][j] = Math.max(ary[i-1][j], ary[i][j-1]);
                }
            }
        }
        bw.write(String.valueOf(ary[a.length][b.length]));
        bw.close();
    }
}