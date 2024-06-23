import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[][] ary = new char[5][15];
        for (int i = 0; i < 5; i++) {
            String sub = br.readLine();
            for (int j = 0; j < sub.length(); j++) {
                ary[i][j] = sub.charAt(j);
            }
        }
        br.close();

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (ary[j][i] != '\0') {
                    bw.write(ary[j][i]);
                }
            }
        }
        bw.close();
    }
}