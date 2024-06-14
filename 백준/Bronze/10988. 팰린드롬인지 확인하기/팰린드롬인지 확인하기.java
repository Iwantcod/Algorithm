import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String a = "", b = "", c = "";

        for (int i = 0; i < str.length()/2; i++) {
            a += str.charAt(i);
            b += str.charAt(str.length() - str.length()/2 + i);
        }
        for (int j = 0; j < str.length()/2; j++) {
            c += b.charAt(str.length()/2 - 1 - j);
        }

        int result = 0;
        if(a.equals(c)) {
            result = 1;
        }
        System.out.println(result);
    }
}