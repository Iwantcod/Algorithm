import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());
        int pay = 1000 - n;
        int cnt = 0;
        int[] coin = {500, 100, 50, 10, 5, 1};

        for (int i = 0; i < 6; i++) {
            if(pay >= coin[i]) {
                int tmp = pay / coin[i];
                cnt += tmp;
                pay -= tmp*coin[i];
            }
        }

        bw.write(String.valueOf(cnt));
        bw.close();
    }
}