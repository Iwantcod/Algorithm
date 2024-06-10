import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] ary = new boolean[31];
        int n = 0;
        for(int i = 0; i < 28; i++) {
            do {
                n = Integer.parseInt(br.readLine());
            } while(n<1 || n>30 || ary[n]);
            ary[n] = true;
        }

        for(int j = 1; j <= 30; j++){
            if(!ary[j]) {
                System.out.println(j);
            }
        }
    }
}