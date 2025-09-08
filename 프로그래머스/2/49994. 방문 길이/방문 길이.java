import java.util.*;

class Solution {
    public int solution(String dirs) {
        int minY = -5, minX = -5;
        int maxY = 5, maxX = 5;
        int[] addr = new int[2]; // 캐릭터의 현재 y, x의 위치값 가짐
        int[] move = new int[2]; // 이동할 y, x값을 가지는 배열
        Set<String> set = new HashSet<>(); // 길이 4의 배열을 가짐 [시작 y, 시작 x, 도착 y, 도착 x];
        
        String[] sp = dirs.split("");
        for(int i = 0; i < sp.length; i++) {
            String cur = sp[i];
            switch(cur) {
                case "U":
                    move[0] = 1;
                    break;
                case "D":
                    move[0] = -1;
                    break;
                case "L":
                    move[1] = -1;
                    break;
                case "R":
                    move[1] = 1;
                    break;
            }
            int ny = addr[0] + move[0];
            int nx = addr[1] + move[1];
            // 다음 이동값 초기화
            move[0] = 0; move[1] = 0;
            // 이동 가능 여부 검사
            if(ny > maxY || ny < minY || nx > maxX || nx < minX) continue;
            // 이동 경로 양방향으로 추가
            set.add(addr[0]+" "+addr[1]+" "+ny+" "+nx);
            set.add(ny+" "+nx+" "+addr[0]+" "+addr[1]);
            // System.out.println(addr[0]+" "+addr[1]+" "+ny+" "+nx+"   "+ny+" "+nx+" "+addr[0]+" "+addr[1]);
            // 이동
            addr[0] = ny; addr[1] = nx;
        }

        return set.size() / 2;
    }
}