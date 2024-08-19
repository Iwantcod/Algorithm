import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());
        HashSet<String> hash = new HashSet<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer strtk = new StringTokenizer(br.readLine(), " ");
            String name = strtk.nextToken();
            boolean isEnter = strtk.nextToken().equals("enter");
            if(isEnter) {
                hash.add(name);
            } else {
                hash.remove(name);
            }
        }

        String[] member = new String[hash.size()];
        Iterator iter = hash.iterator();
        for (int j = 0; j < hash.size(); j++) {
            if(iter.hasNext()) {
                member[j] = iter.next().toString();
            }
        }
        Arrays.sort(member, (s1, s2) -> s2.compareTo(s1));
        for (String s : member) {
            bw.write(s+"\n");
        }
        bw.close();
    }
}