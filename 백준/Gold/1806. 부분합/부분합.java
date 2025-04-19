import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1]; // 계산 편의를 위해 0번째 원소에 0을 넣고, 이후로 입력받은 값을 넣는다.
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = 0;

        // 두 개의 포인터로 부분수열의 범위를 선형적으로 탐색한다. 최소 이동 칸 횟수를 변수로 저장한다.
        // 범위 내의 값이 S보다 커질때까지 end를 이동한다. 이동 완료 후 이동 칸 개수를 구하고, 최소 이동 칸 횟수와 비교한다.
        // S보다 작아질때까지 start를 이동한다. 이후 같은 과정을 반복하며 새로운 부분수열의 길이를 탐색한다.

        int minCnt = Integer.MAX_VALUE;

        while(start <= n && end <= n) {
            if(sum >= s && minCnt > end - start) {
                minCnt = end - start;
            }

            if(sum < s) {
                sum += arr[end++];
            } else {
                sum -= arr[start++];
            }
        }

        if(minCnt == Integer.MAX_VALUE) {
            bw.write("0");
        } else {
            bw.write(String.valueOf(minCnt));
        }
        bw.close();
    }
}