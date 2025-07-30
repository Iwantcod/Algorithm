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

        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            list.add(i);
        }
        bw.write("<");
        Iterator<Integer> iter = list.iterator();
        int cnt = 0;
        while(!list.isEmpty()) {
            cnt++;
            int cur;
            if(!iter.hasNext()) { // 
                iter = list.iterator();
                cur = iter.next();
            } else {
                cur = iter.next();
            }
            
            if(cnt == k) {
                bw.write(String.valueOf(cur));
                iter.remove();
                if(!list.isEmpty()) {
                    bw.write(", ");
                }
                cnt = 0;
            }   
        }
        bw.write(">");
        
        bw.close();
    }
}