import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        long cnt = 0;
        int max = 0;
        for(int i = 0; i < n; i++) {
            int cur = Integer.parseInt(br.readLine());
            if(cur > max) max = cur;
            
            if (!stack.isEmpty() && stack.peek() < cur) {
                cnt += cur - stack.peek();
                // System.out.println(i+" "+cur+" 증가 이후: "+cnt);
                while(!stack.isEmpty() && stack.peek() <= cur) {
                    stack.pop();
                }
            }
            // System.out.println(cur+" 추가");
            stack.push(cur);
        }

        if(!stack.isEmpty()) {
            cnt += (max - stack.peek());
        }
        bw.write(String.valueOf(cnt));
        bw.close();
    }
}