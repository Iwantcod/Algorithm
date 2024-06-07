import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String x;
        int h, m;
        do {
            x = br.readLine();
            h = Integer.parseInt(x.split(" ")[0]);
            m = Integer.parseInt(x.split(" ")[1]);
        } while (h < 0 || h > 23 || m < 0 || m > 59);
        
        if (h == 0 && m < 45) {
            h = 23;
            m = 60-(45-m);
        } else if (m<45) {
            m = 60-(45-m);
            h--;
        } else {
            m = m - 45;
        }
        bw.write(String.valueOf(h)+" "+String.valueOf(m));
        bw.close();
    }
}