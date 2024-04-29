import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 배열을 통해 정렬하는 방법
        int n = 0;      //  입력받을 수의 개수
        while (n < 1 || n > 10000000) {
            n = Integer.parseInt(br.readLine());
        }
        int[] ary = new int[10001];

        int test;
        // 입력받은 값과 같은 인덱스의 값을 1 올려준다.
        for (int i = 0; i < n; i++) {
            test = 0;
            while (test < 1 || test > 10000) {
                test = Integer.parseInt(br.readLine());
                ary[test]++;    // 입력한 값과 대응되는 인덱스의 값 1 증가
            }
        }
        br.close();

        // 배열을 순회하며 인덱스의 값이 0이 아닌지 검사한다.
        // 0이 아니라면, 해당 인덱스의 번호(입력값과 대응됨)를 출력하고 인덱스의 값을 1 감소한다.
        // 위 과정을 해당 인덱스의 값이 0이 될때까지 반복한다.
        // 복잡도: 10000 + 입력값의 개수
        // 이중 반복문을 사용하면 최소 복잡도는 '입력값의 개수 + 입력값의 개수 * 1' 이지만, 최대 복잡도는 '입력값의 개수 + 입력값의 개수 * 10000'가 되어버린다.
        for (int j = 1; j < 10001; j++) {
            while (ary[j] > 0) {
                bw.write(String.valueOf(j) + '\n');
                ary[j]--;
            }
        }
        bw.close();
    }
}