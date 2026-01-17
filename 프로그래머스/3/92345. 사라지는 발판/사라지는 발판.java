class Solution {
    int[] dy = {-1, 1, 0, 0};
    int[] dx = {0, 0, -1, 1};
    int h;
    int w;
    int[][] board;
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        this.board = board;
        this.h = board.length;
        this.w = board[0].length;
        return dfs(aloc[0], aloc[1], bloc[0], bloc[1], true);
    }
    public int dfs(int ay, int ax, int by, int bx, boolean isATurn) {
        int bestWin = Integer.MAX_VALUE; // 내가 이길 수 있을 때 가장 빠르게 끝내는 시간
        int bestLose = 0; // 내가 질 때 가장 늦게 끝내는 시간
        int cy = isATurn ? ay : by;
        int cx = isATurn ? ax : bx;
        if(board[cy][cx] == 0) {
            return 0;
        }
        
        boolean canMove = false;
        for(int i = 0; i < 4; i++) {
            int ny = dy[i] + cy;
            int nx = dx[i] + cx;
            if(!checkLocValid(ny, nx)) {
                continue;
            }
            canMove = true;
            board[cy][cx] = 0;
            int val; // 이후 턴부터 이동한 총 횟수
            if(isATurn) {
                val = dfs(ny, nx, by, bx, false);
            } else {
                val = dfs(ay, ax, ny, nx, true);
            }
            board[cy][cx] = 1;
            
            if(val % 2 == 0) {
                bestWin = Math.min(bestWin, val + 1);
            } else {
                bestLose = Math.max(bestLose, val + 1);
            }
        }
        if(!canMove) {
            // 이동할 곳 없으면 0 return
            return 0;
        } else if(bestWin != Integer.MAX_VALUE) {
            // 이긴 적이 한번이라도 있으면 이긴 경우의 이동 횟수 return
            return bestWin;
        } else {
            // 전부 졌으면 최대로 생존한 이동 횟수 return
            return bestLose;
        }
    }
    public boolean checkLocValid(int ny, int nx) {
        if(ny >= 0 && nx >= 0 && ny < h && nx < w && board[ny][nx] == 1) {
            return true;
        }
        return false;
    }
}