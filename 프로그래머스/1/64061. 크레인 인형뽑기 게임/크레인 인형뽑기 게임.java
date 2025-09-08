import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int[] top = new int[board.length];

        // 각 격자의 높이 측정
        for(int i = 0; i < board.length; i++) {
            boolean isExist = false;
            for(int j = 0; j < board[0].length; j++) {
                if(board[j][i] != 0) {
                    top[i] = j;
                    isExist = true;
                    break;
                }
            }
            if(top[i] == 0 && isExist == false) {
                top[i] = board.length;
            }
            // System.out.print(top[i]+" ");
        }
        
        // 인형뽑기
        int cnt = 0;
        for(int i = 0; i < moves.length; i++) {
            int target = moves[i] - 1;
            if(top[target] >= board.length) {
                continue;
            }
            
            int select = board[top[target]][target];
            top[target]++;
            if(!stack.isEmpty() && stack.peek() == select) {
                stack.pop();
                cnt += 2;
            } else {
               stack.push(select); 
            }
        }

        return cnt;
    }
}