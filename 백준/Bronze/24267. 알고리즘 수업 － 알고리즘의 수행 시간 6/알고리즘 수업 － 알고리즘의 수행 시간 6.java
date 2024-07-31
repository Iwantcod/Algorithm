import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());


        // n이 10이라고 하고 알고리즘을 전개해보았을때 실행횟수가 36, 28, 21, 15, 10, 6, 3, 1 순으로 떨어지는 것을 확인할 수 있다.
        // 이를 뒤집으면 1, 3, 6, 10, 15, 21, 28, 36이다.
        // 변수 a에 1 -> 8 까지의 수를 하나씩 더해준다.
        // 이와 동시에 result변수에 a를 더해준다.
        // 1 + 3(1+2) + 6(1+2+3) + 10(1+2+3+4) ...

        long result = 0l;
        long nextSum = 0L;
        for (int i = 1; i <= n-2; i++) {
            nextSum += i;
            result += nextSum;
        }

        bw.write(String.valueOf(result)+"\n");
        bw.write("3");
        bw.close();
    }
}