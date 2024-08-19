import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer strtk = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(strtk.nextToken());
        int M = Integer.parseInt(strtk.nextToken());
        int cnt = 0;
        // 중복되지 않는 값들을 조회하기 편하고 빠른 hashset 이용.
        HashSet<String> hash = new HashSet<>(N);
        for (int i = 0; i < N; i++) {
            hash.add(br.readLine());
        }

        for (int j = 0; j < M; j++) {
            if(hash.contains(br.readLine())) {
                cnt++;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.close();
    }
}