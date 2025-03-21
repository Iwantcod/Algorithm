import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static int[] ary;
    public static boolean isExist;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ary = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ary);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            search(tmp, 0, N-1);
            if(isExist) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
            isExist = false;
        }
        bw.close();
    }

    public static void search(int a, int start, int end) {
        if(end - start == 0) {
            if(ary[start] == a) {
                isExist = true;   
            }
            return;
        }
        int middlePoint = (start + end) / 2;
        if(ary[middlePoint] >= a) {
            search(a, start, middlePoint);  
        } else {
            search(a, middlePoint + 1, end);
        }
    }
}