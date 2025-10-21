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
            int[] tree = new int[n+1]; // 각 노드의 부모 노드 번호를 저장
            int[] cnt = new int[n+1];
            for(int j = 0; j < n - 1; j++) {
                String[] sp = br.readLine().split(" ");
                int p = Integer.parseInt(sp[0]);
                int c = Integer.parseInt(sp[1]);
                tree[c] = p;
            }
            int root = 0;
            for(int j = 0; j < tree.length; j++) {
                if(tree[j] == 0) {
                    root = j;
                    tree[j] = j;
                }
            }
            String[] sp = br.readLine().split(" ");
            int a = Integer.parseInt(sp[0]);
            int b = Integer.parseInt(sp[1]);

            cnt[a]++; cnt[b]++;
            int p = tree[a];
            while(p != tree[p]) {
                cnt[p]++;
                p = tree[p];
            }

            p = tree[b];
            boolean end = false;
            while(p != tree[p]) {
                cnt[p]++;
                if(cnt[p] == 2) { 
                    bw.write(String.valueOf(p)+"\n");
                    end = true;
                    break;
                }
                p = tree[p];
            }
            if(!end) {
                bw.write(String.valueOf(root)+"\n");
            }
        }
        bw.close();
    }
}