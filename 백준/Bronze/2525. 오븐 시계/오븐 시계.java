import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String x;
        int h, m, c;
        do {
            x = br.readLine();
            h = Integer.parseInt(x.split(" ")[0]);
            m = Integer.parseInt(x.split(" ")[1]);
            c = Integer.parseInt(br.readLine());
        } while (h < 0 || h > 23 || m < 0 || m > 59 || c < 0 || c > 1000);

        int[] a = {c/60, c%60};     // c가 몇시간 몇분인지에 대한 정보를 저장
        h += (m + a[1]) / 60;       // c로 인해 완료시간이 60분이 넘어갈 경우 시간 업데이트
        m = (m + a[1]) % 60;        // 위의 계산 결과의 나머지를 완료 분으로 설정
        h = (h + a[0]) % 24;        // c에 시간단위가 있는 경우 더해주기

        bw.write(String.valueOf(h)+" "+String.valueOf(m));
        bw.close();
    }
}