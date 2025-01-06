import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());
        int[] ary = new int[1001];
        int result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            int index = Integer.parseInt(st.nextToken());
            ary[index] = 1; // 길이 1짜리 부분수열에 속한다고 가정하기 위함이다. 그 부분수열 내의 1번째 순서라고 표시하기 위함이다.
            int max = 0;

            // 특정 부분 수열에서 수가 위치하는 순서: 해당 숫자보다 작은 숫자들이 가지는 순서값 중 최대값에서 1을 더한 값이다.
            // ex: { 10, 20, 10, 40, 30, 50 } 수열이 존재
            // -> 숫자 40을 포함하는 부분수열에서 숫자 40의 위치: 이전까지 입력받은 수들의 순서값 중 최대값(2) 에서 1을 더한 값 == 3
            // 자신보다 작은 값을 순회할 때 내림차순으로 순회하는 것이 시간을 더 절약한다.
            for (int j = index-1; j > 0; j--) {
                if(ary[j] > max) {
                    max = ary[j];
                }
            }
            ary[index] += max;
            // 부분 수열들의 길이 중 가장 긴 것이 최종 결과값이 된다.
            if(ary[index] > result) {
                result = ary[index];
            }
        }
        bw.write(String.valueOf(result));
        bw.close();
    }
}