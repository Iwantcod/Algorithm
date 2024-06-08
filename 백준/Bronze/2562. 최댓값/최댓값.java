import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] ary = new int[9];
        int max = 0;
        int index = 10;

        for(int i = 0; i<9; i++) {
            do {
                ary[i] = Integer.parseInt(br.readLine());
            } while (ary[i] < 1 || ary[i] > 100);
            if(ary[i] > max) {
                max = ary[i];
                index = i+1;
            }
        }
        br.close();

        bw.write(String.valueOf(max)+'\n'+String.valueOf(index));
        bw.close();
    }
}