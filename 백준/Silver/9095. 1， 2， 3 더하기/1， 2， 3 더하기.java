import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] ary = new int[12];
        ary[1] = 1;
        ary[2] = 2;
        ary[3] = 4;

        for (int i = 4; i < ary.length; i++) {
            ary[i] = ary[i-1] + ary[i-2] + ary[i-3];

            // 근거
            // i-1의 각 경우의 수 뒤에 1을 더하면 i가 된다.
            // i-2의 각 경우의 수 뒤에 2를 더하면 i가 된다.
            // i-3의 각 격우의 수 뒤에 3을 더하면 i가 된다.
            // 따라서 4번째부터는 코딩으로 간단히 구할 수 있다.
        }

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int tmp = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(ary[tmp])+"\n");
        }
        bw.close();
    }
}