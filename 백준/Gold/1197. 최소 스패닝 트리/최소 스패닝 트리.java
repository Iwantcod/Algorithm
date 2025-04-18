import java.util.*;
import java.lang.*;
import java.io.*;

class Edge implements Comparable<Edge> {
    int a, b, w;
    Edge(int a, int b, int w) {
        this.a = a;
        this.b = b;
        this.w = w;
    }

    @Override
    public int compareTo(Edge e) {
        // 가중치가 낮은 것을 우선으로 취급하기 위한 비교연산
        return this.w - e.w;
    }
}
    
class Main {
    public static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int v = Integer.parseInt(st.nextToken()); // 노드 개수
        int e = Integer.parseInt(st.nextToken()); // 간선 개수
        parent = new int[v+1]; // 각 노드가 속한 집합의 부모 노드 번호를 기록
        // 크루스칼 알고리즘에서는 여러 개의 '집합'을 하나로 합쳐나가는 방식으로 최소 스패닝 트리를 구한다.
        // 각 집합의 내부 구조는 루트노드를 시작으로하는 상하 관계가 존재하는 '트리' 형식으로 관리된다.

        for(int i = 1; i < v+1; i++) {
            // 모든 노드들은 초기에는 자기 자신만 존재하는 집합에 속해있다.
            parent[i] = i;
        }
        
        // 노드 연결정보를 저장하는 우선순위 큐
        PriorityQueue<Edge> q = new PriorityQueue<>();

        for(int i = 0; i<e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            q.add(new Edge(a, b, w));
        }

        int result = 0;
        int size = q.size(); // 변수를 이용하여 값을 복사한다.
        // 큐의 크기 값을 얻는 메소드를 반복문에 직접 넣게되면 큐 크기가 감소할 때마다 반복문의 루프 횟수 또한 동시에 감소한다.
        // 즉, 원래 의도한 반복횟수만큼 반복을 수행하지 못하게 된다.
        
        for(int i = 0; i < size; i++) {
            // 우선순위 큐(가중치 낮을수록 우선순위 높음)에서 Edge를 하나씩 추출한다.
            Edge cur = q.poll();
            
            // 하나의 간선에 연결된 두 노드가 속한 집합을 find()로 조회하는 동시에 '경로 압축 알고리즘' 적용
            int a = find(cur.a);
            int b = find(cur.b);

            // 두 노드가 속한 집합이 서로 다르다면(각 집합의 루트가 서로 다르다면)
            if(!isSameParent(a, b)) {
                // 최종 결과값에 현재 추출한 Edge의 가중치를 더한다.
                result += cur.w;
                // b 노드의 집합을 a 노드의 집합으로 합친다: union(x, y)
                union(cur.a, cur.b);
            }
        }

        bw.write(String.valueOf(result));
        bw.close();
    }
    // 파라메터로 넘겨받은 노드가 속한 집합의 루트노드가 누구인지 찾는 메소드
    // 부모가 자기 자신이 아닌 경우, 재귀로 계속 거슬러 올라가면서 부모 번호를 최상위 부모 번호로 갱신한다.
    public static int find(int x) {
        if(parent[x] == x) {
            return x;
        }

        // 이 재귀 과정에서 x의 상위 노드들의 '부모 노드 번호 값'은 모두 루트 번호로 갱신된다.
        return parent[x] = find(parent[x]);
    }
    
    // y 노드가 속한 집합의 루트 노드의 '부모'를 x 노드가 속한 집합의 루트노드로 설정하는 메소드
    // 즉, y노드 집합을 x노드 집합에 병합
    public static void union(int x, int y) {
        x = find(x);
        y = find(y); // y노드가 속한 집합의 루트 노드 번호 탐색


        // x, y가 서로 다른 집합에 속한다면 y를 x가 속한 집합으로 이전: x가 속한 집합의 루트노드를 y의 부모로 설정
        if(x != y) {
            // y 집합의 루트 노드의 '부모 노드' 정보를 x 집합의 루트 노드로 설정
            parent[y] = x;    
        }
    }


    // 두 노드가 서로 같은 집합에 속하는지 검증하는 메소드
    public static boolean isSameParent(int x, int y) {
        if(find(x) == find(y)) {
            return true;
        } else {
            return false;
        }
    }
}