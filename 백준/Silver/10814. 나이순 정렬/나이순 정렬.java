import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());
        String[][] str = new String[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer strtk = new StringTokenizer(br.readLine(), " ");
            str[i][0] = strtk.nextToken();
            str[i][1] = strtk.nextToken();
        }

        // 나이를 비교하기 위해 Integer형으로 변환
        Arrays.sort(str, (s1, s2) -> {
            int s1Age = Integer.parseInt(s1[0]);
            int s2Age = Integer.parseInt(s2[0]);

            // 나이가 같은 경우 아무것도 하지 않음.
            if(s1Age == s2Age) {
                return 0;
            } else {    // 나이가 다른 경우에만 비교.
                return s1Age-s2Age;
            }
        });

        for (int i = 0; i < N; i++) {
            bw.write(str[i][0]+" "+str[i][1]+"\n");
        }
        bw.close();
    }
}