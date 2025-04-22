import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static int n, m;
    public static boolean[] visited; // calList 원소의 방문 여부
    public static int[] calList; // 연산자 종류 정보를 저장
    public static int[] calCase; // 연산자 경우의 수 저장
    public static int[] arr; // 수열 저장
    public static StringBuilder sb = new StringBuilder();
    public static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE; // 최대값, 최소값 저장 변수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        m = n-1;
        arr = new int[n];
        calList = new int[m];
        calCase = new int[m];
        visited = new boolean[m];

        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");

        int p = 0;
        for(int i = 1; i <= 4; i++) {
            int num = Integer.parseInt(st.nextToken());
            for(int j = 0; j < num; j++) {
                calList[p] = i;
                p++;
            }
        }

        dfs(0);
        bw.write(String.valueOf(max)+"\n");
        bw.write(String.valueOf(min));
        bw.close();
    }
    public static void dfs(int depth) {
        if(depth == m) {
            // 연산자 배치 경우의 수가 하나 완성되었으면 그 경수의 수를 따라서 수열을 차례대로 계산해나간다.
            int result = arr[0];

            for(int i = 0; i < m; i++) {
                switch(calCase[i]) {
                    case 1: // '+' 인 경우
                        result += arr[i+1];
                        break;
                    case 2: // '-' 인 경우
                        result -= arr[i+1];
                        break;
                    case 3: // '*' 인 경우
                        result *= arr[i+1];
                        break;
                    case 4: // '/' 인 경우
                        if(result < 0) {
                            result = ((result * -1) / arr[i+1]) * -1;
                        } else {
                            result /= arr[i+1];
                        }
                        break;
                }
            }
            
            // 최대값 및 최소값 갱신
            if(result > max) {
                max = result;
            }
            if(result < min) {
                min = result;
            }
            
            return;
        }


        for(int i = 0; i < m; i++) {
            if(!visited[i]) {
                visited[i] = true;
                calCase[depth] = calList[i];
                dfs(depth+1);
                
                visited[i] = false;
            }
        }
    }
}