import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] sp = br.readLine().split("");
        int len = sp.length % 3;        
        int[] result = new int[len == 0 ? sp.length / 3 : sp.length / 3 + 1];

        int indx = sp.length - 1;
        int resultIndx = result.length - 1;
        if(indx >= 3) {
            while(indx > len - 1 && resultIndx > 0) {
                int tmp = 0;
                if(sp[indx].equals("1")) tmp += 1;
                if(sp[indx - 1].equals("1")) tmp += 2;
                if(sp[indx - 2].equals("1")) tmp += 4;
                result[resultIndx--] = tmp;
                indx -= 3;
            }    
        }
        
        int last = 1;
        int tmp = 0;
        if(indx >= 0) {
            while(indx >= 0) {
                if(sp[indx].equals("1")) tmp += last;
                last *= 2;
                indx--;
            }
            result[0] = tmp;
        }
        for(int i = 0; i < result.length; i++) {
            bw.write(String.valueOf(result[i]));
        }
        bw.close();
    }
}