import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] ary = new int[10];
        int a = -1;
        for(int i = 0; i<10; i++) {
            do {
                a = Integer.parseInt(br.readLine());
            }while (a < 0 || a > 1000);
            ary[i] = a%42;
        }
        br.close();

        ary = Arrays.stream(ary).distinct().toArray();  // stream을 이용하여
        bw.write(String.valueOf(ary.length));
        bw.close();
    }
}