import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(pow(a, b)));
        bw.close();
    }

    public static long pow(long a, long b) {
        // b가 1인경우 재귀 탈출
        if (b == 1) {
            return a % c;
        }
        // 지수를 절반으로 나눈 값을 c로 나눈 나머지 값을 구한다.(재귀호출)
        // 지수를 분할하여 구해도 되는 이유는 지수 법칙을 이용하기 때문이다.
        // 나머지 값을 구할 때 역시 모듈러 성질을 이용하여 계산한다.(그냥 계산하기에는 값의 범위가 너무나도 크기 때문이다.)
        long tmp = pow(a, b / 2);

        if(b % 2 == 1) { // 지수가 홀수인 경우 자기 자신(a)을 한번 더 곱해준다(자기 자신을 c로 나눈 값을 곱해준다)
            return (tmp * tmp % c) * a % c;
        } else {
            return tmp * tmp % c;
        }
    }
}