import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        // 중복되지 않는 값들을 조회하기 편하고 빠른 hashset 이용.
        HashSet<Integer> card = new HashSet<>(N);

        StringTokenizer strtk = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            card.add(Integer.parseInt(strtk.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        int[] check = new int[M];
        StringTokenizer strtk2 = new StringTokenizer(br.readLine(), " ");
        for (int j = 0; j < M; j++) {
            int nowCheck = Integer.parseInt(strtk2.nextToken());
            // 해당 값이 존재하면 1을, 아니면 0을 저장.
            String nowResult = (card.contains(nowCheck)) ? "1 " : "0 ";
            bw.write(nowResult);
        }
        bw.close();
    }
}