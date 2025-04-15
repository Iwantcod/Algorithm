import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int p = 0, q = n-1;

        int[] min = new int[3]; // 0: 최소합 결과, 1: p포인터 가리키는 값, 2: q포인터 가리키는 값
        min[0] = Math.abs(arr[p] + arr[q]); // 가장 작은 경우의 수의 값(절대값)를 기록
        min[1] = p;
        min[2] = q;

        while(p < q) {
            int cur = arr[p] + arr[q];
            if(Math.abs(cur) < min[0]) {
                min[0] = Math.abs(cur);
                min[1] = p;
                min[2] = q;
            }

            if(cur >= 0) {
                q--;
            } else if(cur < 0) {
                p++;
            }
        }

        bw.write(String.valueOf(arr[min[1]])+" "+String.valueOf(arr[min[2]]));
        bw.close();
    }
}