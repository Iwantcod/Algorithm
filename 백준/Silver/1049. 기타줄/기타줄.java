import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] sp = br.readLine().split(" ");
        int n = Integer.parseInt(sp[0]);
        int m = Integer.parseInt(sp[1]);
        int INF = Integer.MAX_VALUE;

        int minPack = INF;
        int minOne = INF;

        for(int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            int curPack = Integer.parseInt(s[0]);
            int curOne = Integer.parseInt(s[1]);
            minOne = Math.min(minOne, curOne);
            minPack = Math.min(minPack, Math.min(curPack, minOne * 6));
        }

        int answer = 0;
        answer += (n/6) * minPack;
        answer += Math.min((n%6) * minOne, minPack);

        System.out.println(answer);
    }
}