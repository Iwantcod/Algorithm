import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 500,000의 제곱은 int범위를 벗어나므로, long 사용
        long n = Long.parseLong(br.readLine());

        // n번만큼 반복하는 반복문 내에 n번 반복문이 있으므로 수행 횟수는 n*n
        System.out.println(n*n);
        // 시간복잡도는 n^2이 되므로 차수는 2이다.
        System.out.print(2);
    }
}