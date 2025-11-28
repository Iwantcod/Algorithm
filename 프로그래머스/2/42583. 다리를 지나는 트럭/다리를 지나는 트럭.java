// 13:55
import java.util.*;
class Solution {
    class Truck {
        int entryTime;
        int weight;
        Truck(int e, int w) {
            this.entryTime = e;
            this.weight = w;
        }
    }
    public int solution(int len, int weight, int[] truck) {
        
        int time = 1; // 현재 시간 카운트
        int seq = 1; // 다음에 다리에 진입할 트럭 번호
        int w = truck[0];
        Queue<Truck> q = new LinkedList<>();
        q.add(new Truck(time, truck[0]));
        while(!q.isEmpty()) {
            // 다리를 다 지난 트럭을 큐에서 제거
            time++;
            // System.out.println(time+"초 총 무게(큐 제거 전): "+w);
            while(!q.isEmpty() && len == time - q.peek().entryTime) {
                w -= q.peek().weight;
                // System.out.println("큐 길이: "+q.size());
                // System.out.println("제거: "+time+"초: "+q.peek().entryTime+" "+q.peek().weight);
                q.poll();
            }
            // System.out.println(time+"초 총 무게(큐 제거 후): "+w);
            if(seq < truck.length) {
                Truck cur = new Truck(time, truck[seq]);
                if(w + cur.weight <= weight) {
                    w += cur.weight;
                    q.add(cur);
                    seq++;
                    // System.out.println("input: "+time+"초: "+cur.weight);
                }
            }
            // System.out.println(time+"초 총 무게(큐 추가 후): "+w);
            // System.out.println("=========");
        }
        return time;
    }
}