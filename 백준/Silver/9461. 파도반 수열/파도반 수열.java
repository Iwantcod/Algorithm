import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        long[] ary = new long[101];
        ary[1] = 1; ary[2] = 1; ary[3] = 1; // 초기값
        for (int i = 4; i < 101; i++) {
            ary[i] = ary[i-2] + ary[i-3]; // 그림을 살펴보면 i번째 삼각형의 변의 길이는 i-2, i-3 삼각형의 변의 길이를 서로 더한 것과 같다.
        }

        for (int i = 0; i < T; i++) {
            int indx = Integer.parseInt(br.readLine());
            bw.write(ary[indx] + "\n");
        }
        bw.close();
    }
}