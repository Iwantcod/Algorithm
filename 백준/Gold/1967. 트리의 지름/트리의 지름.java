import java.util.*;
import java.lang.*;
import java.io.*;


class Node {
    int dest, weight;
    public Node(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }
}

class Main {
    public static ArrayList<Node>[] list;
    public static boolean[] visited;
    public static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1]; // 특정 노드 기준(인덱스 값으로 표시)으로 연결된 노드와 가중치값 저장
        visited = new boolean[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<Node>();
        }

        // 값 입력
        StringTokenizer st;
        for(int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            // 양방향 매핑
            list[start].add(new Node(dest, weight));
            list[dest].add(new Node(start, weight));
        }

        for(int i = 1; i <= n; i++) {
            dfs(i, 0);
            visited = new boolean[n+1];
        }

        bw.write(String.valueOf(max));
        bw.close();

    }
    public static void dfs(int start, int weightCum) {
        visited[start] = true;
        
        if(weightCum > max) {
            max = weightCum;
        }
        
        for(Node node : list[start]) {
            if(!visited[node.dest]) {
                dfs(node.dest, weightCum + node.weight);
            }
        }
    }    
}