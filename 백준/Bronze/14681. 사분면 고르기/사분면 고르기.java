import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x, y;
        do {
            x = Integer.parseInt(br.readLine());
            y = Integer.parseInt(br.readLine());
        } while ( x < -1000 || x > 1000 || x == 0 || y < -1000 || y > 1000 || y == 0);
        boolean isX = x > 0;
        boolean isY = y > 0;
        br.close();

        if(isX && isY) {
            bw.write('1');
        } else if (isY) {
            bw.write('2');
        } else if (isX) {
            bw.write('4');
        } else {
            bw.write('3');
        }
        bw.close();
    }
}