import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String[] arr = new String[s.length()];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = s.substring(i);
        }

        Arrays.sort(arr);

        for(int j = 0; j < arr.length; j++) {
            bw.write(arr[j]+"\n");
        }
        bw.close();
    }
}