import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int[] N = new int[str.length()+1];


        for (int i = 0; i < str.length(); i++) {
            N[i] = Integer.parseInt(str.substring(i, i+1));
        }
        Arrays.sort(N);


        for (int i = N.length-1; i > 0; i--) {
            bw.write(String.valueOf(N[i]));
        }
        bw.close();
    }
}