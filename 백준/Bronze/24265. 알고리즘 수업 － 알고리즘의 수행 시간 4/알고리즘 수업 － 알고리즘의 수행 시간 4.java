import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());

        long result = 0l;
        // n번만큼 반복하는 반복문 내에 n번 반복문이 있으므로 수행 횟수는 n*n
        for (int i = 1; i <= n-1; i++) {
            result += i;
        }
        // 시간복잡도는 n^2이 되므로 차수는 2이다.
        System.out.println(result);
        System.out.print(2);
    }
}