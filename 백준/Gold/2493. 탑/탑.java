import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] sp = br.readLine().split(" ");
        Stack<int[]> stack = new Stack<>(); // [탑 번호, 높이] 저장
        int[] result = new int[n];
        
        for(int i = n-1; i >= 0; i--) {
            int[] cur = new int[]{i, Integer.parseInt(sp[i])};

            while(!stack.isEmpty()) {
                int[] head = stack.peek();
                if(head[1] < cur[1]) {
                    // 스택의 위에서부터 자신보다 높이가 낮은 탑 정보를 모두 pop
                    stack.pop();
                    // pop된 탑의 수신지는 자신의 탑 번호(0 ~ N-1) + 1
                    result[head[0]] = cur[0] + 1;
                } else {
                    break;
                }
            }
            stack.push(cur);
        }

        for(int i = 0; i < result.length; i++) {
            bw.write(String.valueOf(result[i])+" ");
        }

        bw.close();
    }
}