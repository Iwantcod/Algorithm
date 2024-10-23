import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer strtk = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(strtk.nextToken());
        int B = Integer.parseInt(strtk.nextToken());
        int cnt = 0; //결과값으로는 cnt+1의 값을 출력
        // B를 만들 수 있는지 검사하고, 두 가지 연산을 거꾸로 B에게 적용하여 B의 숫자를 낮춰나간다.
        // 그러다가 B와 A가 같아지면 연산 횟수 반환
        // 일의 자리가 1이 아닌 홀수는 만들 수 없으므로, 계산하지 않는다.


        // 일의 자리가 1이 아닌 홀수라도, A와 B가 같다면 연산을 하지 않고 수를 만들 수 있으므로 1 출력
        if(A == B) {
            bw.write("1");
        } else if((B-1)%10 != 0 && B%2 != 0) {
            bw.write("-1");
        } else {
            while(B > A) {
                if((B-1)%10 == 0) {
                    B = (B-1) / 10;
                    cnt++;
                } else if(B%2 == 0) {
                    B = B/2;
                    cnt ++;
                } else {
                    B = 0; // 위 두 연산을 더 이상 수행할 수 없는 경우, A가 가질 수 있는 최소범위인 1보다 작은 0으로 만들어, 반복문 종료
                }
            }
            if(A == B) {
                bw.write(String.valueOf(cnt+1));
            } else {
                bw.write("-1");
            }
        }
        bw.close();
    }
}