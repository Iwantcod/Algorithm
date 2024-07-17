import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());
        boolean[] ary = new boolean[N+1];       // 소인수분해에 사용할 소수를 구하기 위한 배열
        ary[1] = true;      // 1은 미리 제거

        boolean isDone = true;

        if (N > 1) {
            for (int i = 2; i < ary.length; i++) {      // 소수 판별: 에라토스테네스의 체
                if (!ary[i]) {
                    for (int j = i * 2; j < ary.length; j += i) {
                        ary[j] = true;
                    }
                    // 소수를 찾았으면, 그 소수로 나누어떨어지지 않을 때까지 나누면서 해당 소수를 출력
                    while (isDone) {
                        if (N % i == 0) {
                            bw.write(String.valueOf(i)+"\n");
                            N = N / i;
                        } else {        // 나누어 떨어지지 않으면, 반복문을 탈출하고 다음 소수를 찾는다.
                            isDone = false;
                        }
                    }
                    isDone = true;
                }
            }
            bw.close();
        }
    }
}