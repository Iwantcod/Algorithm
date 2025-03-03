import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int[][] map;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        map = new int[n][2]; // 첫번째 인덱스는 알파벳 코드 - 65를 의미한다. 왼, 오른 순으로 입력된다.
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int index = st.nextToken().charAt(0) - 'A';
            map[index][0] = st.nextToken().charAt(0) - 'A';
            map[index][1] = st.nextToken().charAt(0) - 'A';
        }
        preorder(0);
        sb.append("\n");
        Arrays.fill(visited, false);
        inorder(0);
        sb.append("\n");
        Arrays.fill(visited, false);
        postorder(0);
        bw.write(sb.toString());
        bw.close();
    }
    // 순회 방법에 따라 인덱스를 이동하며 순회 방법을 재귀적으로 적용한다.
    // 조회할 대상이 '.'이거나(음수이거나), 이미 방문한 경우 아무것도 수행하지 않고 return한다.
    public static void preorder(int start) {
        if(start < 0 || visited[start]) {
            return;
        }
        sb.append((char)('A' + start));
        visited[start] = true;

        preorder(map[start][0]);
        preorder(map[start][1]);
    }

    public static void inorder(int start) {
        if(start < 0 || visited[start]) {
            return;
        }
        inorder(map[start][0]);

        sb.append((char)('A' + start));
        visited[start] = true;

        inorder(map[start][1]);
    }

    public static void postorder(int start) {
        if(start < 0 || visited[start]) {
            return;
        }
        postorder(map[start][0]);
        postorder(map[start][1]);

        sb.append((char)('A' + start));
        visited[start] = true;
    }
}