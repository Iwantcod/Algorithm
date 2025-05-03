import java.util.*;
class Solution {
    public static int[][] arr;
    public static boolean[][] possible;
    public static int h, w, cnt;
    public static boolean[][] visited;
    public int solution(String[] storage, String[] requests) {
        h = storage.length;
        w = storage[0].length();
        cnt = h*w;
        visited = new boolean[h+2][w+2];
        arr = new int[h+2][w+2];
        possible = new boolean[h+2][w+2];
        
        for(int i = 1; i <= h; i++) {
            for(int j = 1; j <= w; j++) {
                arr[i][j] = (int)storage[i-1].charAt(j-1) - 64;
                // 초기의 접근가능한 위치를 표시
                if(i == 1 || i == h) {
                    possible[i][j] = true;
                }
                if(j == 1 || j == w) {
                    possible[i][j] = true;
                }
            }
        }
        
        for(int k = 0; k < requests.length; k++) {
            // System.out.println("현재 요청: "+requests[k]);
            // System.out.println("현재 possible 상태:");
            // for(int i = 1; i <= h; i++) {
            //     for(int j = 1; j <= w; j++) {
            //         System.out.print(possible[i][j]+" ");
            //     }
            //     System.out.println();
            // }
            if(requests[k].length() == 1) {
                int curRequest = (int)requests[k].charAt(0) - 64;
                singleRequest(curRequest, false);
                toPossible(0, 0);
                fill();
            } else {
//                 int firstVal = (int)requests[k].charAt(0) - 64;
//                 int secondVal = (int)requests[k].charAt(1) - 64;
//                 doubleRequest(firstVal, secondVal);
//                 toPossible(0, 0);
//                 fill();
                
//                 singleRequest(firstVal, true);
//                 toPossible(0, 0);
//                 fill();
                
//                 singleRequest(secondVal, true);
//                 toPossible(0, 0);
//                 fill();
                int curRequest = (int)requests[k].charAt(0) - 64;
                doubleRequest(curRequest);
                toPossible(0, 0);
                fill();
                
                singleRequest(curRequest, true);
                toPossible(0, 0);
                fill();
            }
            
        }
        

        return cnt;
    }
    
    public static void fill() {
        for(boolean[] a : visited) {
            Arrays.fill(a, false);
        }
    }
    
    public static void toPossible(int i, int j) {
        // [0, 0]부터 시작해서 상하좌우 방면으로 bfs 수행. 값이 0인 곳의 possible을 true.
        
        boolean up = i - 1 >= 0;
        boolean down = i + 1 < h+2;
        boolean right = j + 1 < w+2;
        boolean left = j - 1 >= 0;
        
        if(up) {
            if(arr[i-1][j] == 0 && !visited[i-1][j]) {
                visited[i-1][j] = true;
                check(i-1, j);
                toPossible(i-1, j);
            }
        }
        if(down) {
            if(arr[i+1][j] == 0 && !visited[i+1][j]) {
                visited[i+1][j] = true;
                check(i+1, j);
                toPossible(i+1, j);
            }
        }
        if(right) {
            if(arr[i][j+1] == 0 && !visited[i][j+1]) {
                visited[i][j+1] = true;
                check(i, j+1);
                toPossible(i, j+1);
            }
        }
        if(left) {
            if(arr[i][j-1] == 0 && !visited[i][j-1]) {
                visited[i][j-1] = true;
                check(i, j-1);
                toPossible(i, j-1);
            }
        }
    }
    
    public static void check(int i, int j) {
        boolean up = i - 1 >= 0;
        boolean down = i + 1 < h+2;
        boolean right = j + 1 < w+2;
        boolean left = j - 1 >= 0;
        
        if(up) {
            possible[i-1][j] = true;
        }
        if(down) {
            possible[i+1][j] = true;
        }
        if(right) {
            possible[i][j+1] = true;
        }
        if(left) {
            possible[i][j-1] = true;
        }
    }
    
    public static void singleRequest(int curRequest, boolean isCrane) {
        if(isCrane) {
            for(int i = 1; i <= h; i++) {
                for(int j = 1; j <= w; j++) {
                    if(arr[i][j] == curRequest) {
                        // System.out.println(curRequest+": "+i+" "+j);
                        arr[i][j] = 0;
                        cnt--;
                    }
                }
            }
        } else {
            for(int i = 1; i <= h; i++) {
                for(int j = 1; j <= w; j++) {
                    if(arr[i][j] == curRequest && possible[i][j]) {
                        // System.out.println(curRequest+": "+i+" "+j);
                        arr[i][j] = 0;
                        cnt--;
                    }
                }
            }
        }
    }
    
    public static void doubleRequest(int curRequest) {
        for(int i = 1; i <= h; i++) {
            for(int j = 1; j <= w; j++) {
                if(arr[i][j] == curRequest && arr[i][j+1] == curRequest) {
                    arr[i][j] = 0;
                    arr[i][j+1] = 0;
                    cnt -= 2;
                }
            }
        }
    }
}