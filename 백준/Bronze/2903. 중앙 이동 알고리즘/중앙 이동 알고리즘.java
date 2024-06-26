import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        // 사각형의 개수: 4의 N제곱
        // 해당 도형이 가지는 점의 개수: 사각형의 개수의 제곱근 + 1을 제곱한 수

        int powNum = (int)Math.pow(4,N);
        int sqrtNum = (int)Math.sqrt(powNum)+1;
        System.out.println(sqrtNum*sqrtNum);
    }
}