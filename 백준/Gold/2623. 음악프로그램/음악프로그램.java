import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sp = br.readLine().split(" ");
        int n = Integer.parseInt(sp[0]);
        int m = Integer.parseInt(sp[1]);

        List<Integer>[] map = new ArrayList[n+1];
        for(int i = 0; i < map.length; i++) {
            map[i] = new ArrayList<>();
        }

        int[] indegree = new int[n+1];

        for(int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            for(int j = 2; j < s.length; j++) {
                int cur = Integer.parseInt(s[j]);
                int parent = Integer.parseInt(s[j-1]);
                map[parent].add(cur);
                indegree[cur]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> answer = new ArrayList<>();
        while(!q.isEmpty()) {
            int cur = q.poll();
            answer.add(cur);

            for(int child : map[cur]) {
                indegree[child]--;
                if(indegree[child] == 0) {
                    q.add(child);
                }
            }
        }

        if(answer.size() != n) {
            System.out.println("0");
        } else {
            for(int i = 0; i < answer.size(); i++) {
                System.out.println(answer.get(i));
            }
        }

    }
}

// 대표적인 위상정렬 문제