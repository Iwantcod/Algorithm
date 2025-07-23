import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            String[] s = br.readLine().split(" ");
            int result = Integer.parseInt(s[0]) + Integer.parseInt(s[1]);
            bw.write("Case #" + String.valueOf(i+1) + ": " + String.valueOf(result) + "\n");
        }
        bw.close();
    }
}