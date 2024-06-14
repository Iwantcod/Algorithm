import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] a = new int[6];
        int[] b = {1, 1, 2, 2, 2, 8};

        boolean vert = false;
        do {    // 발견한 흰색 피스 개수 입력
            StringTokenizer strtk = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < 6; i++) {
                a[i] = Integer.parseInt(strtk.nextToken());
                if(a[i] < 0 || a[i] > 10)
                    vert = true;
            }
        } while (vert);

        int x = 0;
        for (int j = 0; j < 6; j++) {
            x = b[j] - a[j];        // 알맞게 찾았으면 0, 아니라면 부족하거나 많은 개수를 출력
            bw.write(String.valueOf(x)+" ");
        }
        bw.close();
    }
}
