import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        boolean[][] ary = new boolean[n+1][n+1];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ary[a][b] = ary[b][a] = true;
        }

//        for (int i = 1; i <= n; i++) {
//            System.out.print(i+": ");
//            for (int j = 1; j <= n; j++) {
//                if (ary[i][j]) {
//                    System.out.print(j+" ");
//                }
//            }
//            System.out.println();
//        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] isEnter = new boolean[n+1]; // 1 ~ n의 인덱스 사용 (숫자가 이미 탐색되었는지 여부 기록)
        q.add(1); // 1부터 BFS 탐색 시작
        isEnter[1] = true;

        int cnt = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 1; i <= n; i++) {
                if (ary[cur][i]) {
                    // ary[cur][i]가 true면, cur와 i가 연결되었다는 의미이다.
                    if(!isEnter[i]){
                        // cur, i가 서로 연결되었고, i를 이전에 방문한 적이 없다면 카운트에 추가한다.
                        isEnter[i] = true; // 그리고 방문 여부 표시
                        q.add(i); // 방문한 i의 링크 정보를 방문하도록 큐의 뒤에 넣는다.
                        cnt++;
                    }
                }
            }
        }
        bw.write(String.valueOf(cnt));
        bw.close();
    }
}