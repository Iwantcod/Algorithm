import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[][] map;
    static List<int[]> emptyAddr;
    static boolean isFinish;
    public static void main(String[] args) throws IOException {
        // 백트래킹 이용
        // 1. 비어있는 좌표 정보 수집: emptyAddr
        // 2. 비어있는 좌표마다 1~9를 순서대로 대입해보며, 스도쿠 전체를 채울 수 있는지 검사
        // 3. 채울 수 없다면 돌아가서 그 다음 숫자를 대입 후 재시도
        // 4. 처음으로 완성된 스도쿠(즉, 모든 비어있는 좌표에 값이 대입된 첫 시점)를 결과값으로 출력
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];
        emptyAddr = new ArrayList<>();
        isFinish = false;
        
        for(int i = 0; i < 9; i++) {
            String[] sp = br.readLine().split("");
            for(int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(sp[j]);
                if(map[i][j] == 0) {
                    emptyAddr.add(new int[]{i, j}); // 1. 비어있는 좌표 수집
                }
            }
        }
        
        dfs(0); // 백트래킹 이용

        // 결과 출력
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }        
    }

    public static void dfs(int indx) {
        if(indx == emptyAddr.size()) {
            // 처음으로 스도쿠가 완성되면 연산 종료
            isFinish = true;
            return;
        }
 
        for(int i = 1; i <= 9; i++) {
            int y = emptyAddr.get(indx)[0];
            int x = emptyAddr.get(indx)[1];
            if(checkNum(y, x, i)) {
                map[y][x] = i;
                dfs(indx + 1);
                if(isFinish == true) {
                    return;
                }
                map[y][x] = 0;
            }
        }
        
    }
    
    public static boolean checkNum(int y, int x, int target) {
        // 1. 현재 속한 3*3 정사각형 그룹에서 대상 숫자가 이미 존재하는지 확인
        // 2. 현재 열에서 대상 숫자가 이미 존재하는지 확인

        for(int i = y/3*3; i < y/3*3+3; i++) {
            for(int j = x/3*3; j < x/3*3+3; j++) {
                if(map[i][j] == target) {
                    return false;
                }
            }
        }

        for(int i = 0; i < 9; i++) {
            int curX = map[y][i];
            int curY = map[i][x];
            if(curX == target || curY == target) {
                return false;
            }
        }

        return true;
    }
}