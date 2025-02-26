import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] parent = new int[n+1];
        ArrayList<Integer>[] list = new ArrayList[n+1]; // 각 노드의 연결정보를 하나의 연결리스트로 관리 -> 연결리스트 타입 배열 필요
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 양방향 연결
            list[a].add(b);
            list[b].add(a);
        }

        // BFS를 이용해서 1번 노드부터 순회하기 시작한다.
        // x노드와 인접한 노드들의 부모는 x라는 의미이므로, 부모 노드로 기록한다.
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int tmp = q.poll();
            for (int node : list[tmp]) {
                if(!visited[node]) {
                    visited[node] = true;
                    q.add(node);
                    parent[node] = tmp;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            bw.write(String.valueOf(parent[i])+"\n");
        }
        bw.close();
    }
}