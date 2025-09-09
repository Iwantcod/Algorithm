import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        // 첫째 줄에 (A+B)%C
        // 둘째 줄에 ((A%C) + (B%C))%C
        // 셋째 줄에 (A×B)%C
        // 넷째 줄에 ((A%C) × (B%C))%C

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] sp = br.readLine().split(" ");
        int a = Integer.parseInt(sp[0]);
        int b = Integer.parseInt(sp[1]);
        int c = Integer.parseInt(sp[2]);

        bw.write(String.valueOf( (a + b) % c) +"\n");
        bw.write(String.valueOf( ((a % c) + (b % c)) % c )+"\n");
        bw.write(String.valueOf( (a * b) % c )+"\n");
        bw.write(String.valueOf( ((a % c) * (b % c)) % c ));
        bw.close();
    }
}