import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String value;          // 입력받을 변수
        int n = 0, k = 0;      //  동전의 종류, 목표 가치
        while (n < 1 || n > 10 || k < 1 || k > 100000000) {
            value = br.readLine();
            n = Integer.parseInt(value.split(" ")[0]);
            k = Integer.parseInt(value.split(" ")[1]);
        }

        // 오름차순으로 입력받기 위해 이전 인덱스와 비교해야하는데, 이를 수월하게 하기 위해 0이 아닌 1번째 인덱스부터 입력받는다(0번째부터 시작하면 예외처리가 귀찮아지는데, 이를 간단히 해결하는 방안이다).
        // 0번째 배열은 입력하지 않아도 정수형 기본값인 0이 주어진다. 따라서 n+1의 크기로 선언한다.
        int[] coin = new int[n + 1];
        int startIndex = 0;
        for (int i = 1; i <= n; i++) {
            coin[i] = Integer.parseInt(br.readLine());

            // 이전 인덱스의 값보다 현재 인덱스의 값이 작거나, 입력값이 허용범위를 초과할 경우 재입력받는다.
            while (coin[i] <= coin[i - 1] || coin[i] > 1000000) {
                coin[i] = Integer.parseInt(br.readLine());
            }
            // 추후 최소 동전개수를 계산할 때 k보다 가치가 높은 동전은 셀 필요가 없다. 이를 위해서 반복문을 시작할 인덱스의 위치를 계산하는 조건문
            if (coin[i] <= k)
                startIndex++;
        }
            br.close();

            int result = 0;    // 총 필요한 동전의 최소개수(결과값)
            int cnt = 0;        // 각 동전당 필요한 개수를 카운팅하기 위해 사용되는 변수
            for (int j = startIndex; j > 0; j--) {      // 배열의 인덱스를 거꾸로 순회한다(큰 동전부터 세어야 함)
                if (coin[j] <= k) {
                    cnt = k / coin[j];      // k를 해당 동전으로 나눈 몫을 저장
                    result += cnt;          // 저장된 카운팅 값을 결과값에 sum
                    k -= cnt * coin[j];     // k에서 카운팅한 만큼의 총 값을 차감
                    cnt = 0;                // 다음연산에 사용하기 위해 카운팅변수 0으로 초기화
                }
                if (k == 0)         // 개수를 다 세었으면 반복문 탈출
                    break;
            }
            bw.write(String.valueOf(result));
            bw.close();
    }
}