import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] times = new int[1000001]; // 1 ~ 1000000 범위의 인덱스범위를 사용하기 위한 배열
        // 범위 내의 모든 수를 1로 만들기 위한 횟수를 구한다.
        // 그 횟수는 오름차순으로 구하며, 이때 이전의 결과를 메모하여 재사용한다.

        for (int i = 2; i < times.length; i++) {
            // case1: 2로 나눈 수를 1로 만들기 위해 필요한 횟수 - 2로 나누어떨어지지 않는 수의 경우 범위 내의 최대값으로 설정하여 예외처리
            // case2: 3으로 나눈 수를 1로 만들기 위해 필요한 횟수 - 3으로 나누어떨어지지 않는 수의 경우 범위 내의 최대값으로 설정하여 예외처리
            // case3: 1을 뺀 수를 1로 만들기 위해 필요한 횟수
            int case1 = 10000000;
            int case2 = 10000000;
            if(i%2 == 0) {
                case1 = times[i/2];
            }
            if(i%3 == 0) {
                case2 = times[i/3];
            }
            int case3 = times[i-1];
            int result = Math.min(Math.min(case1, case2), case3);
            times[i] = result + 1;
        }

        int inputNum = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(times[inputNum]));
        bw.close();
    }
}