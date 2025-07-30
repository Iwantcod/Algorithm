import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);

        int m = Integer.parseInt(br.readLine());
        int tmpA = (int)Math.pow(a, (m-1));

        String[] num = br.readLine().split(" ");
        int target = 0;
        for(int i = 0; i < num.length; i++) {
            target += Integer.parseInt(num[i]) * tmpA;
            tmpA /= a;
        }
        
        int tmpB = 0;
        int lengthCnt = 1;
        for(int i = b; i < target; i *= b) {
            tmpB = i;
            lengthCnt++;
        }
        int[] result = new int[lengthCnt];
        int index = 0;
        for(int i = tmpB; i > 0; i /= b) {
            result[index] = target / i;
            target = target % i;
            bw.write(String.valueOf(result[index])+" ");
            index++;
        }
        bw.close();
    }
}