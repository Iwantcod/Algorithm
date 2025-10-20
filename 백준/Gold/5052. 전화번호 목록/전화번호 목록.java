import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            Set<String> set = new HashSet<>();
            boolean answer = true;
            String[] arr = new String[n];
            for(int j = 0; j < n; j++) {
                arr[j] = br.readLine();
            }
            Arrays.sort(arr);
            for(int j = 0; j < n; j++) {
                String cur = arr[j];
                for(int k = 0; k < cur.length(); k++) {
                    String tmp = cur.substring(0, k+1);
                    if(set.contains(tmp)) {
                        answer = false;
                        break;
                    }
                }
                set.add(cur);
                if(answer == false) {
                    break;
                }
            }

            if(answer == true) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }
        bw.close();
    }
}