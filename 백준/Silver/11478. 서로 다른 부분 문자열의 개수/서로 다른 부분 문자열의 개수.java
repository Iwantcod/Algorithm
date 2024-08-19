import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        HashSet<String> set = new HashSet<>();
        int cnt = 0;
        for (int i = 1; i <= str.length(); i++) {
            int indx = 0;
            for (int j = i; j <= str.length(); j++) {
                String tmp = str.substring(indx, i+indx);
                indx++;
                if(!set.contains(tmp)) {
                    set.add(tmp);
                    cnt++;
                }
            }
        }
        bw.write(String.valueOf(cnt));
        bw.close();
    }
}