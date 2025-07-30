import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            arr.add(i);
        }

        bw.write("<");
        int index = k-1;
        while(!arr.isEmpty()) {            
            int cur = arr.remove(index);
            bw.write(String.valueOf(cur));
            if(!arr.isEmpty()) {
                bw.write(", ");
            }
            
            if(index == arr.size()) {
                index = 0;
            }
            index += (k-1);
            if(index > arr.size()-1 && !arr.isEmpty()) {
                index = index % arr.size();
            }
            
        }
        bw.write(">");
        bw.close();
        
    }
}