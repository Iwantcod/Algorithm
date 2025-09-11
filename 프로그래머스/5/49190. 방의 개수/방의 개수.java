import java.util.*;
// 14:10 ~ 15:22

class Solution {
    static Set<String> visited = new HashSet<>();
    static Set<String> move = new HashSet<>();
    static int cnt = 0;
    public int solution(int[] arrows) {
        double[] addr = new double[2]; // y, x
        
        visited.add("0.0 0.0");
        
        for(int i = 0; i < arrows.length; i++) {
            double[] start = new double[]{addr[0], addr[1]};
            switch(arrows[i]) {
                case 0:
                    addr[0]++; break;
                case 1:
                    addr[0]++; addr[1]++; break;
                case 2:
                    addr[1]++; break;
                case 3:
                    addr[0]--; addr[1]++; break;
                case 4:
                    addr[0]--; break;
                case 5:
                    addr[0]--; addr[1]--; break;
                case 6:
                    addr[1]--; break;
                case 7:
                    addr[0]++; addr[1]--; break;
            }
            double[] next = new double[]{addr[0], addr[1]};
            isMake(start, next, arrows[i]);
            
        }
        
        return cnt;
    }
    public static void isMake(double[] s, double[] n, int arrow) {
        String start = s[0] + " " + s[1];
        String next = n[0] + " " + n[1];
        if(arrow == 1 || arrow == 3 || arrow == 5 || arrow == 7) {
            double middleY = (s[0] + n[0]) / 2.0;
            double middleX = (s[1] + n[1]) / 2.0;
            String middle = ""+middleY+" "+middleX;
            if(move.add(start+" "+middle) 
               && move.add(middle+" "+start) 
               && !visited.add(middle)) {
                cnt++;
            }   
            if(move.add(middle+" "+next)
               && move.add(next+" "+middle)
               && !visited.add(next)) {
                cnt++;
            }
        } else if(move.add(start+" "+next) 
                  && move.add(next+" "+start)
                  && !visited.add(next)) {
            // System.out.println(start+" "+next);
            // System.out.println(next+" "+start);
            cnt++;
        }   
    }
}

// 방문할때마다 set에 저장하고, 저장에 실패한 동시에 새로운 경로가 생성되었으면 도형 생성으로 간주
// 대각선 이동의 경우 '시작 -> 중간지점 -> 목적지' 로 저장하기
// 이유: 점 4개를 이용하여 모래시계 모양이 만들어지는 경우 판단하기 위함
