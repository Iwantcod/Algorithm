import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = 5;
        int[] ary = new int[N];
        int[] result = new int[N];
        int[] smallNum = {1001, 0};

        for (int i = 0; i < N; i++) {
            ary[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(ary[j] < smallNum[0]) {
                    smallNum[0] = ary[j];
                    smallNum[1] = j;
                }
            }
            result[i] = smallNum[0];
            ary[smallNum[1]] = 1001;
            smallNum[0] = 1001;
        }

        int avg = 0;
        for (int i = 0; i < N; i++) {
            avg += result[i];
        }
        avg /= 5;
        bw.write(String.valueOf(avg)+"\n");
        bw.write(String.valueOf(result[2]));
        bw.close();
    }
}