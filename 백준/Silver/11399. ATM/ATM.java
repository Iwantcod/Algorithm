import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = 0;
        while(n<1 || n > 1000) {
            String a = br.readLine();
            n = Integer.parseInt(a);
        }

        int[] ary = new int[n];

        boolean err = true;
        while(err) {
            err = false;
            String[] b = br.readLine().split(" ");
            for(int i = 0; i < n; i++) {
                ary[i] = Integer.parseInt(b[i]);
                if(ary[i] < 1 || ary[i] > 1000) {
                    err = true;
                }
            }
        }


        int cnt = 0;
        int sum = 0;
        for(int j = 1; j <= 1000; j++) {
            for(int z = 0; z < n; z++) {
                if(ary[z] == j) {
                    sum = sum + (cnt + j);
                    cnt += j;
                }
            }
        }
        System.out.println(sum);
    }
}