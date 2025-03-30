import java.util.*;
import java.lang.*;
import java.io.*;

class Node implements Comparable<Node> {
    public int end, weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node n) {
        return weight - n.weight;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        int K = Integer.parseInt(br.readLine());

        int inf = 100000000;

        boolean[] visited = new boolean[V+1];
        int[] result = new int[V+1];
        List<Node>[] list = new ArrayList[V+1]; // 인덱스번호가 '시작 노드'를 의미

        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<Node>(); // list의 각 인덱스는 각각의 '리스트'이다.
            result[i] = inf;
        }
        result[K] = 0;

        
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v, w));
        }

        // 최단거리 노드를 최우선으로 탐색하기 위해 우선순위 큐 자료구조를 이용
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(K, 0));
        while(!q.isEmpty()) {
            // 인근 연결 노드를 탐색할 기준 노드를 큐에서 뽑는다.
            Node cur = q.poll();
            int start = cur.end;

            // 이미 탐색한적 있는 노드(번호로 구분)라면, 다음 반복문을 수행한다.
            if(visited[start]) {
                continue;
            } else {
                visited[start] = true;   // 탐색 시 탐색 여부를 체크한다.
            }


            // list에서 해당 노드 번호로 시작하여 연결되는 인접 노드들을 순회한다.
            for (Node node : list[start]) {
                int weight = node.weight; // 인접 노드로의 가중치
                int dest = node.end; // 인접 노드의 번호
                // result 배열에서 해당 인접 노드로 갈때 필요한 가중치(기록된 가중치)가 현재 계산된 값보다 크다면 해당 값을 갱신
                if(result[dest] > weight + result[start]) {
                    result[dest] = weight + result[start];
                    q.add(new Node(dest, result[dest])); // 갱신한 경우, 해당 노드를 탐색하기 위해 큐에 넣는다. 이때 가중치는 갱신된 가중치 값을 넣는다.
                }
                
            }
        }

        for (int i = 1; i <= V; i++) {
            if(result[i] == inf) {
                bw.write("INF\n");
            } else {
                bw.write(String.valueOf(result[i])+"\n");
            }
        }

        bw.close();
    }
}