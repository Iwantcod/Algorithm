// 08:26

import java.util.*;
class Solution {
    class Node {
        int num;
        int req;
        int cost;
        Node(int num, int req, int cost) {
            this.num = num;
            this.req = req;
            this.cost = cost;
        }
    }
    public int solution(int[][] jobs) {
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> {
            if(n1.cost == n2.cost) {
                if(n1.req == n2.req) {
                    return n1.num - n2.num;
                }
                return n1.req - n2.req;
            }
            return n1.cost - n2.cost;
        });
        
        Node[] arr = new Node[jobs.length];
        for(int i = 0; i < jobs.length; i++) {
            int[] cur = jobs[i];
            arr[i] = new Node(i, cur[0], cur[1]);
        }
        
        Arrays.sort(arr, (j1, j2) -> {
            if(j1.req == j2.req) {
                return j1.num - j2.num;
            }
            return j1.req - j2.req;
        });
        
        int indx = 0;
        
        int timer = 0;
        int answer = 0;
        while(indx < arr.length) {
            while(indx < arr.length && arr[indx].req <= timer) {
                pq.add(arr[indx++]);
            }
            
            if(pq.isEmpty()) {
                timer = arr[indx].req;
            } else {
                Node cur = pq.poll();
                timer = Math.max(timer, cur.req);
                timer += cur.cost;
                answer += timer - cur.req;
            }
        }
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            timer = Math.max(timer, cur.req);
            timer += cur.cost;
            answer += timer - cur.req;
        }
        
        answer /= jobs.length;
        return answer;
    }
}