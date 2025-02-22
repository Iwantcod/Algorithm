import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] ary;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ary = new int[m];

        dfs(1, 0); // 1부터 탐색 시작, 깊이는 0(초기깊이)
        System.out.print(sb.toString());
    }

    public static void dfs(int start, int depth) {
        // 현재 '깊이'에 놓을 수 있는 숫자의 모든 경우의 수를 계산한다.
        // 하나 놓으면, 그 다음 깊이에 놓을 수 있는 모든 경우의 수를 또 계산한다.
        // 반복하다가, 깊이가 m과 같아지면 더 이상 진행할 수 없으므로 예외처리를 해서 입력된 배열을 출력한다.

        if(depth == m) {
            // 깊이가 배열의 크기와 같아지면 그때는 입력된 배열값 반환하고, 해당 메소드 종료
            for (int i = 0; i < m; i++) {
                sb.append(ary[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 배열에 '깊이'에 해당하는 칸에 값 입력하고 재귀호출
        for (int i = start; i <= n; i++) {
            ary[depth] = i;
            // 다음 함수 시작위치: 현재 입력된 값보다 1큰 값
            // 다음 함수의 깊이: 1 증가
            dfs(i + 1, depth + 1);
        }
    }
}