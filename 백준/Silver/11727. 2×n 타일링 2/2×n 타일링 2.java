import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2*n 직사각형을 채우는 경우의 수
        // n이 1인 경우와 2인 경우는 직접 계산해서 기본값으로 입력해준다.
        int[] ary = new int[1001]; // 1~1000 인덱스를 사용한다.
        ary[1] = 1;
        ary[2] = 3;
        // 규칙성을 발견하기 위해 n을 1부터 5까지 구해보니 다음의 규칙을 발견했다.
        // 1. n이 홀수인 경우의 수는 (n-1의 경우의 수 * 2) - 1
        // 2. n이 짝수인 경우의 수는 (n-1의 경우의 수 * 2) + 1

        // 알아낸 규칙을 통해 모든 값을 미리 구해놓는다.
        // 값: 경우의 수 % 10007
        for (int i = 3; i < 1001; i++) {
            if(i % 2 == 0) {
                ary[i] = ((ary[i - 1] * 2 + 1) % 10007);
            } else {
                ary[i] = ((ary[i - 1] * 2 - 1) % 10007);
            }
        }

        int n = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(ary[n]));
        bw.close();
    }
}