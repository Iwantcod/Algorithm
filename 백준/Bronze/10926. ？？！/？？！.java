import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a;
        do {
            a = br.readLine().toLowerCase();
        } while (a.length() > 50);
        br.close();
        bw.write(a+"??!");
        bw.close();
    }
}