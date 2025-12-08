// 08:41
import java.util.*;
class Solution {
    class Edge {
        int v;
        int w;
        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
    public int solution(int[][] land, int height) {
        int n = land.length;
        int[][] area = new int[n][n];
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        
        Queue<int[]> q = new LinkedList<>();
        int num = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(area[i][j] == 0) {
                    num++; 
                    area[i][j] = num;
                    q.add(new int[]{i, j});
                    while(!q.isEmpty()) {
                        int[] cur = q.poll();
                        for(int k = 0; k < 4; k++) {
                            int ny = cur[0] + dy[k];
                            int nx = cur[1] + dx[k];
                            if(ny >= 0 && nx >= 0 && ny < n && nx < n && area[ny][nx] == 0) {
                                int abs = Math.abs(land[cur[0]][cur[1]] - land[ny][nx]);
                                if(abs <= height) {
                                    area[ny][nx] = num;
                                    q.add(new int[]{ny, nx});
                                }
                            }
                        }
                    }
                }
            }
        }
        int[] root = new int[num+1];
        for(int i = 0; i < root.length; i++) {
            root[i] = i;
        }
        
        List<Edge>[] list = new ArrayList[num + 1];
        for(int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        Set<String> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < 4; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    String road = ""+i+" "+j+" "+ny+" "+nx;
                    String roadReverse = ""+ny+" "+nx+" "+i+" "+j;
                    if(ny >= 0 && nx >= 0 && ny < n && nx < n && !set.contains(road)) {
                        set.add(road);
                        set.add(roadReverse);
                        int srcAreaNum = area[i][j];
                        int destAreaNum = area[ny][nx];
                        if(srcAreaNum != destAreaNum) {
                            int abs = Math.abs(land[i][j] - land[ny][nx]);
                            list[srcAreaNum].add(new Edge(destAreaNum, abs));
                            list[destAreaNum].add(new Edge(srcAreaNum, abs));
                        }
                    }
                }
            }
        }
        
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> {
            return e1.w - e2.w;
        });
        boolean[] visited = new boolean[num + 1];
        int answer = 0;
        visited[1] = true;
        for(int i = 0; i < list[1].size(); i++) {
            pq.add(list[1].get(i));
        }
        while(!pq.isEmpty()) {
            Edge e = pq.poll();
            if(visited[e.v] == true) {
                continue;
            }
            visited[e.v] = true;
            answer += e.w;
            for(int i = 0; i < list[e.v].size(); i++) {
                pq.add(list[e.v].get(i));
            }
        }
        
        return answer;
    }
}