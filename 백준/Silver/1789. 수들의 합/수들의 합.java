import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long S = Long.parseLong(br.readLine());

        long tmp = 0;
        long cnt = 0;
        long i = 1;
        while(tmp < S) {
            tmp += i;
            cnt++;
            i++;
        }

        if(tmp > S) {
            bw.write(String.valueOf(cnt-1));
        } else {
            bw.write(String.valueOf(cnt));
        }
        bw.close();
    }
}