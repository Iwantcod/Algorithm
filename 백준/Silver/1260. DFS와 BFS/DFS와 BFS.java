import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        boolean[][] ary = new boolean[n+1][n+1]; // 2차원 배열로 그래프의 연결 상태를 표시. true면 연결된 것
        boolean[] isEnterStack = new boolean[n+1]; // 1 ~ N 정점의 탐색 여부를 기록
        boolean[] isEnterQueue = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            // 양방향으로 연결 상태를 기록
            ary[src][dst] = true;
            ary[dst][src] = true;
        }

        Stack<Integer> stackInt = new Stack<>();
        stackInt.push(v);

        while(!stackInt.isEmpty()) {
            int tmp = stackInt.pop();
            if(!isEnterStack[tmp]) { // pop한 항목이 탐색한 적이 없는 노드인 경우에만 아래를 수행
                isEnterStack[tmp] = true;
                bw.write(String.valueOf(tmp)+" ");
                for (int i = n; i > 0; i--) {
                    if(ary[tmp][i] && !isEnterStack[i]) { // 노드가 서로 연결되어 있고, 탐색한 적이 없으면 스택에 넣는다.
                        // 작은 번호의 노드를 먼저 조회하기 위해, 큰 번호의 노드부터 스택에 넣는다. (LIFO)
                        stackInt.push(i);
                    }
                }
            }

        }
        bw.write("\n");

        Queue<Integer> queueInt = new LinkedList<>();
        queueInt.add(v);

        while(!queueInt.isEmpty()) {
            int tmp = queueInt.poll();
            if(!isEnterQueue[tmp]) {
                isEnterQueue[tmp] = true;
                bw.write(String.valueOf(tmp)+" ");
                for (int i = 1; i <= n; i++) {
                    // 작은 번호의 노드를 먼저 조회하기 위해, 작은 번호의 노드부터 큐에 넣는다. (FIFO)
                    if(ary[tmp][i] && !isEnterQueue[i]) {
                        queueInt.add(i);
                    }
                }
            }
        }
        bw.close();
    }
}