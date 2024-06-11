import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = 0;
        do {
            n = Integer.parseInt(br.readLine());
        } while (n<1 || n>10);
        String[] ary = new String[n];
        for(int i = 0; i<n; i++) {
            do {
                ary[i] = br.readLine();
            } while (ary[i].length() > 1000);
        }
        br.close();

        for(int j = 0; j<n; j++) {
            bw.write(ary[j].charAt(0));
            bw.write(ary[j].charAt(ary[j].length()-1));
            bw.write('\n');
        }
        bw.close();
    }
}