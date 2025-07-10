import java.util.*;

class Node {
    long x;
    long y;
    public Node(long x, long y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Node) {
            Node o = (Node) obj;
            return o.x == x && o.y == y;
        } else
            return false;
    }
}

class Solution {
    public String[] solution(int[][] line) {
        HashSet<Node> set = new HashSet<>(); // 별 위치 저장하는 set
        // min, max 좌표값
        long maxX = Long.MIN_VALUE, minX = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE, minY = Long.MAX_VALUE;
        
        
        // 모든 경우의 수의 두 방정식 조합에서 x, y값을 구한 뒤 0이 아닌 정수라면 set에 저장
        // a, b, c, d, e, f는 x, y값 계산에 필요한 변수
        // parent는 두개의 계산식에 공통적으로 사용되는 값
        long a, b, c, d, e, f, parent;
        for(int i = 0; i < line.length; i++) {
            int[] cur = line[i]; // 방정식 1
            a = cur[0];
            b = cur[1];
            e = cur[2];
            
            for(int j = i+1; j < line.length; j++) {
                int[] target = line[j]; // 방정식 2
                c = target[0];
                d = target[1];
                parent = (a*d) - (b*c);
                if(parent == 0) {
                    continue;
                }
                
                f = target[2];
                
                // x, y를 구한다.
                double x = (double) ((b*f) - (e*d)) / parent;
                double y = (double) ((e*c) - (a*f)) / parent;
                
                if(x % 1.0 != 0.0 || y % 1.0 != 0.0) {
                    continue;
                } else {
                    // 0이 아닌 정수인 경우 set에 추가한다.
                    long tmpX = (long) x;
                    long tmpY = (long) y;
                    
                    // x, y의 최대값 및 최소값을 갱신한다.(결과값 출력을 위함)
                    if(tmpX > maxX)
                        maxX = tmpX;
                    if(tmpX < minX)
                        minX = tmpX;
                    if(tmpY > maxY)
                        maxY = tmpY;
                    if(tmpY < minY)
                        minY = tmpY;
                    
                    set.add(new Node(tmpX, tmpY));
                }
            }
        }
        
        int width = (int) (maxX - minX + 1);
        int height = (int) (maxY - minY + 1);
        
        String[] answer = new String[height];
        char[][] rows = new char[height][width];
        
        for(int i = 0; i < rows.length; i++) {
            Arrays.fill(rows[i], '.');
        }
        
        for(Node cur : set) {
            int y = (int) (cur.y - maxY) * -1;
            int x = (int) (cur.x - minX);
            rows[y][x] = '*';
        }
        
        for(int i = 0; i < rows.length; i++) {
            answer[i] = new String(rows[i]);
        }
        
        return answer;
    }
}