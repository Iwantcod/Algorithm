import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // k층 n호
        long[][] ary = new long[15][15]; // 층은 0~14, 호수는 1~14

        // 0층의 i호에는 i명이 산다.
        for (int i = 1; i < 15; i++) {
            ary[0][i] = i;
        }

        // a층의 b호에 살려면 자신의 아래(a-1)층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야 한다.
        // 빈방은 없다.
        // 아래층의 1호부터 b호까지 사람들의 수의 합은, 현재층의 b-1호가 가지고있다. -> 이전의 결과를 재활용하여 중복 계산을 없앤다.
        // k층 n호에 거주하는 사람의 수: k층 n-1호 거주 인원 + k-1층 n호 거주 인원
        // 이렇게 더하다보면 int의 범위를 넘어서므로 long 데이터타입을 사용한다.
        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 15; j++) {
                ary[i][j] = ary[i][j-1] + ary[i-1][j];
            }
        }

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int index1 = 0, index2 = 0;
            index1 = Integer.parseInt(br.readLine());
            index2 = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(ary[index1][index2])+"\n");
        }
        bw.close();
    }
}