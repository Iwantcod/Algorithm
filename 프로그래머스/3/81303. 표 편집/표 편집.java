import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int[] left = new int[n];
        int[] right = new int[n];
        boolean[] isDead = new boolean[n];
        Stack<Integer> trash = new Stack<>();
        
        for(int i = 0; i < n; i++) {
            left[i] = i - 1;
            right[i] = i + 1;
        }
        int cursor = k;
        int dest;
        for(int i = 0; i < cmd.length; i++) {
            String cur = cmd[i];
            switch(cur.charAt(0)) {
                case 'D':
                    dest = Integer.parseInt(cur.substring(2));
                    while(dest-- > 0) {
                        cursor = right[cursor];
                    }
                    break;
                case 'U':
                    dest = Integer.parseInt(cur.substring(2));
                    while(dest-- > 0) {
                        cursor = left[cursor];
                    }
                    break;
                case 'C':
                    isDead[cursor] = true;
                    trash.push(cursor);
                    if(left[cursor] != -1) right[left[cursor]] = right[cursor];
                    if(right[cursor] != n) left[right[cursor]] = left[cursor];
                    cursor = (right[cursor] != n) ? right[cursor] : left[cursor];
                    break;
                case 'Z':
                    int restore = trash.pop();
                    isDead[restore] = false;
                    if(left[restore] != -1) right[left[restore]] = restore;
                    if(right[restore] != n) left[right[restore]] = restore;
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            if(isDead[i])
                sb.append("X");
            else
                sb.append("O");
        }
        return sb.toString();
    }
}
