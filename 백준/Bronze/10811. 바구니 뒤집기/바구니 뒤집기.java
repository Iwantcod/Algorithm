import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static int[] ary;
    public static boolean isExist;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] ary = new int[N+1]; // 1 ~ N 인덱스 사용
        for(int i = 1; i <= N; i++) {
            ary[i] = i;
        }
        int p = 0, q = 0; // 값을 서로 바꿀때 사용할 포인터 두개
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            p = Integer.parseInt(st.nextToken());
            q = Integer.parseInt(st.nextToken());
            while(p < q) {
                int tmp = ary[p];
                ary[p] = ary[q];
                ary[q] = tmp;
                p++;
                q--;
            }
        }

        for(int i = 1; i <= N; i++) {
            bw.write(String.valueOf(ary[i])+" ");
        }
        bw.close();
        
    }
}