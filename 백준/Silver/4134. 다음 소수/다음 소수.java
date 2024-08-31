import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 정수가 주어졌을 때, 그 정수보다 같거나 큰 소수중 가장 작은 소수를 찾는 프로그램
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(br.readLine());
            if(num == 0 || num == 1) {  // 0이나 1이 입력될 경우 2가 출력(예외처리)
                bw.write("2\n");
            } else {
                boolean isNotPrime = true;

                // 소수판별 방법: 해당 수와 해당 수의 제곱근보다 같거나 작은 수와 모두 맞아떨어지지 않으면 소수.
                while(isNotPrime) {
                    int tmp = (int)Math.sqrt(num);
                    int cnt = 0;
                    for (int j = 2; j <= tmp; j++) {
                        if(num % j == 0) { // 소수가 아닌 경우, 반복문 종료
                            cnt++;
                            break;
                        }
                    }
                    if(cnt == 0) {
                        isNotPrime = false; // 소수를 찾았으면 while문 종료
                        bw.write(String.valueOf(num)+"\n");
                    } else {
                        // 이번에 판별한 수가 소수가 아닌경우, 다음 수(1이 증가된 수)를 판별하기 시작
                        num++;
                    }

                }
            }
        }
        bw.close();
    }
}