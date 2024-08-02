import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer strtk = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(strtk.nextToken());
        int b = Integer.parseInt(strtk.nextToken());
        int c = Integer.parseInt(strtk.nextToken());

        int d = Integer.parseInt(strtk.nextToken());
        int e = Integer.parseInt(strtk.nextToken());
        int f = Integer.parseInt(strtk.nextToken());

        // 가감법이 아니라 가능한 모든 경우의 수를 대입하여 해를 찾는 방식(단순해도 시간 내에 풀면 그만..)
        for (int i = -999; i <= 999; i++) {
            for (int j = -999; j <= 999; j++) {
                if(a*i + b*j == c && d*i + e*j == f) {
                    bw.write(String.valueOf(i)+" "+String.valueOf(j));
                    bw.close();
                    break;
                }
            }
        }
    }
}