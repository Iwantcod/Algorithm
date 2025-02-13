import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 물품 개수
        int k = Integer.parseInt(st.nextToken()); // 최대 수용 가능 무게
        int[][] info = new int[n+1][2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken()); // w
            info[i][1] = Integer.parseInt(st.nextToken()); // v
        }

        int[][] result = new int[k+1][n+1]; // 예외처리를 위한 0번 인덱스, 그리고 실제 계산에 사용되는 1~n, 1~k 인덱스를 사용

        for (int i = 1; i <= k; i++) { // i == 해당 시점에서 담을 수 있는 최대 무게(1~n)
            for (int j = 1; j <= n; j++) { // j == 물품의 번호(info의 첫 인덱스를 의미)
                // 현재 조회한 물품의 무게가 i보다 크면, 직전에 기록된 최대값을 반영(해당 시점에서의 누적 최대 무게량)
                if(info[j][0] > i) {
                    result[i][j] = result[i][j-1];
                } else {
                    int extraWeight = i - info[j][0]; // 물품을 담고 난 뒤의 여분 무게량

                    // 1. 현재 조회한 물품의 가치 + 여분 무게량에 넣을 수 있는 물품 중 최고 가치
                    // 2. 직전에 기록된 최대값
                    // 1과 2 중 더 큰 값을 선택
                    result[i][j] = Math.max(info[j][1] + result[extraWeight][j-1], result[i][j-1]);
                }
            }
        }
        bw.write(String.valueOf(result[k][n]));
        bw.close();
    }
}