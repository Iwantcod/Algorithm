import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a, b;
        do {
            String x = br.readLine();
            a = Integer.parseInt(x.split(" ")[0]);
            b = Integer.parseInt(x.split(" ")[1]);
        } while(a <= 0 || b >= 10);
        br.close();
        bw.write(String.valueOf(a-b));
        bw.close();
    }
}