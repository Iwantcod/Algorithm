import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer strtk1 = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(strtk1.nextToken());
        int M = Integer.parseInt(strtk1.nextToken());

        boolean[][] ary = new boolean[N][M];

        String str = "";
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            for (int j = 0; j < M; j++) {
                // 해당 칸이 검은색이라면 false, 하얀색이라면 true 입력한다.
                if(str.charAt(j) == 'W') {
                    ary[i][j] = true;
                }
            }
        }

        int result = -1;    // 최종 결과값(출력되는 값)

        boolean startColor = false;
        // 8*8 커널로 보드를 순회하며 검증. 검증 횟수 = (N-8+1)*(M-8+1)번
        // i와 j는 검증 횟수임과 동시에 검증을 시작하는 위치값이 되기도 한다.
        for (int i = 0; i < N-8+1; i++) {
            for (int j = 0; j < M-8+1; j++)
            {
                int[] tempCnt = {0, 0}; // 두 번의 검증의 카운트 수를 임시저장하기 위함


                // 같은 커널을 두 번 검증
                // 로직: 완벽한 형태의 8*8 형태의 체스판은 두 가지 형태가 존재한다. (B로 시작, W로 시작)
                // 이 두 형태의 체스판과 다른 타일의 개수를 카운트하여 둘 중에 더 작은 개수를 결과값으로 채택
                for (int k = 0; k < 2; k++) {
                    boolean nowColor = startColor;
                    for (int l = 0; l < 8; l++) {
                        nowColor = !nowColor; // 체스판 모양을 위해 줄바꿈 때마다 한번 더 추가로 색깔변환해줌.
                        for (int m = 0; m < 8; m++) {
                            if(ary[i+l][j+m] != nowColor) {
                                tempCnt[k]++;
                            }
                            nowColor = !nowColor;
                        }
                    }
                    startColor = !startColor; // 다음 검증의 첫 타일 색깔 결정
                }

                int tempResult = Math.min(tempCnt[0], tempCnt[1]);  // 두 번의 검증 결과 중 더 작은 값을 임시 저장.
                if(result == -1) {  // 초기값인 경우 이번 검증에서 나온 결과값 넣기
                    result = tempResult;
                } else if(tempResult < result) {    // 초기값 아닌경우, result보다 작은 경우에만 적용하기
                    result = tempResult;
                }

            }
        }
        bw.write(String.valueOf(result));
        bw.close();
    }
}