import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = 0, B = 0, C = 0;
        int T = Integer.parseInt(br.readLine());
        if(T%10 != 0) {
            bw.write("-1");
        } else {
            A += (T/300);
            T -= A*300;

            B += (T/60);
            T -= B*60;

            C += (T/10);
            T -= C*10;

            bw.write(String.valueOf(A)+" "+String.valueOf(B)+" "+String.valueOf(C));
        }
        bw.close();
    }
}