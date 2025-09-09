import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] arr = new boolean[1_000_001];
        arr[0] = true; arr[1] = true; arr[2] = true;
        for(int i = 2; i <= (int)Math.sqrt(1_000_000); i++) {
            for(int j = i*2; j < arr.length; j += i) {
                arr[j] = true;
            }
        }

        int n = Integer.parseInt(br.readLine());
        while(n != 0) {
            if(n <= 1_000_000 && n >= 6) {
                for(int i = 3; i <= n/2; i++) {
                    if(!arr[i] && !arr[n-i]) {
                        bw.write(String.valueOf(n)+" = "+String.valueOf(i)+" + "+String.valueOf(n-i)+"\n");
                        break;
                    }
                }    
            } else {
                bw.write("Goldbach's conjecture is wrong.\n");
            }            
            n = Integer.parseInt(br.readLine());
        }
        bw.close();
    }
}