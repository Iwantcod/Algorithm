import java.util.*;
class Solution {
    class Node {
        int num;
        Queue<Node> child = new LinkedList<>();
        Node lastChild;
        Node(int num) {
            this.num = num;
        }
        public Node getChild() {
            Node node = child.poll();
            child.add(node);
            lastChild = node;
            return node;
        }
    }
    List<Integer> cycle = new ArrayList<>();
    int[] cnt;
    public int[] solution(int[][] e, int[] target) {
        this.cnt = new int[target.length];
        Arrays.sort(e, (e1, e2) -> {
            if(e1[0] == e2[0]) {
                return e1[1] - e2[1];
            } else {
                return e1[0] - e2[0];
            }
        });
        
        Node[] nodeArr = new Node[target.length + 1];
        for(int i = 1; i < nodeArr.length; i++) {
            nodeArr[i] = new Node(i);
        }
        Node root = nodeArr[1];
        
        for(int i = 0; i < e.length; i++) {
            int p = e[i][0];
            int c = e[i][1];
            nodeArr[p].child.add(nodeArr[c]);
            nodeArr[p].lastChild = nodeArr[c];
        }
        
        // 공 떨어뜨린 횟수 카운팅: cnt[i]
        // 각 리프노드가 가질 수 있는 값은 cnt[i]*1 ~ cnt[i]*3 범위의 값이다.
        // target[i] 값이 cnt[i] 보다 작은 것이 하나라도 있다면 불가능 판정
        // 모든 target[i]가 (cnt[i] ~ cnt[i]*3) 범위에 들어올 때까지 공을 계속 떨어뜨리고, 공이 도착한 리프노드의 순서를 기록
        // target, cnt을 복사한 배열 생성
        // '리프노드 순서 배열'을 차례대로 순회하면서, 자신이 선택할 수 있는 공 중 가장 작은 공 선택
        // 공 선택 기준
        // - 남은 값이 3보다 큰 경우: 남은값%3
        // - 남은 값이 2보다 큰 경우: 남은값%2
        // - 그 외: 남은값
        // 공을 선택했으면 복사한 cnt[i]을 1 감소, 복사한 target[i]에서 공 숫자만큼 감소
        // 선택한 공 숫자를 answer 배열에 추가
        
        boolean isFinish = false;
        while(!isFinish) {
            isFinish = true;
            for(int i = 0; i < target.length; i++) {
                if(target[i] < cnt[i]) {
                    return new int[]{-1};
                } else if(target[i] > cnt[i] * 3) {
                    isFinish = false;
                    dropOnce(root);
                }
            }
        }
        
        int[] cpCnt = cnt.clone();
        int[] cpTarget = target.clone();
        
        int[] answer = new int[cycle.size()];
        for(int i = 0; i < cycle.size(); i++) {
            int cur = cycle.get(i) - 1;
            cpCnt[cur]--;
            int div = cpCnt[cur] * 3;
            int add;
            if(div >= cpTarget[cur]) {
                add = 1;
            } else {
                add = cpTarget[cur] - div;
            }
            answer[i] = add;
            cpTarget[cur] -= add;
        }
        
        
        return answer;
    }
    
    public void dropOnce(Node node) {
        if(node.child.isEmpty()) {
            cycle.add(node.num);
            cnt[node.num - 1]++;
            return;
        }
        Node child = node.getChild();
        dropOnce(child);
    }
}