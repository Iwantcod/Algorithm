import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        // 어떤 수가 입력되든 딱 한번만 실행되기 때문에, 모든 경우에서 1과 0을 출력한다.
        System.out.println(1);
        System.out.print(0);

    }
}