import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // System.out.print("Min(1~1,000,000,000,000), Max(min <= max <= 1,000,000): ");
        String[] line = br.readLine().split(" ");
        long min = Long.parseLong(line[0]);
        long max = Long.parseLong(line[1]);
        while(min < 1 || min > 1000000000000L || max < min || max > min + 1000000L) {   // 조건에 맞지 않는 수 입력 시 다시입력받음
            // System.out.print("다시 입력하세요: ");
            line = br.readLine().split(" ");
            min = Long.parseLong(line[0]);
            max = Long.parseLong(line[1]);
        }
        br.close();
        int size = 0;
        int length = (int) (max - min + 1); // 범위의 크기 계산
        boolean[] isNotPow = new boolean[length];   //  범위의 크기만한 bool 배열 선언
        // 제곱수의 배수를 true로 만듦 -> false인 인덱스가 '제곱ㄴㄴ수'임을 의미.
        // 범위 내 임의의 수는 (해당 수 - min)값에 해당하는 인덱스에 위치해 있다고 생각할 수 있다.

        for(long i = 2; i*i <= max; i++) {  // 2부터 시작하여 i*i가 max보다 커지기 전까지 반복한다.
            long pow = i*i; // 검증에 사용되는 제곱수에 해당하는 변수
            long start = min % pow == 0 ? min / pow : (min / pow) + 1;  // pow * start의 값은 min보다 높아야하므로, 나누어 떨어지지 않는 경우 1을 더해준다.
            // ex) min이 10이라 가정: start값이 10/4인 2가 되어버리면 시작값이 8로, 10보다 작은 오류가 발생. 나누어떨어지는 경우 min부터 검증을 시작할 수 있으므로 1을 더해주지 않아도 된다.

            for(long j = start; j*pow <= max; j++) {           // 1씩 증가하는 j와 제곱수를 곱해주면서 해당되는 인덱스의 값을 모두 true로 만듦.
                isNotPow[(int)(j*pow - min)] = true;        // 뒤에 min을 빼주는 이유는 시작 인덱스가 min이기 때문이다. min이 10이고 j*pow가 16일때, 배열은 10부터 시작하므로 min을 빼준 6이 올바른 인덱스값이 된다.
            }
        }

        for(boolean item : isNotPow) {
            if(!item) { // 인덱스값이 false라면 '제곱ㄴㄴ수'임을 의미하므로 '제곱ㄴㄴ수' 개수 카운팅
                size++;
            }
        }
        String s = String.valueOf(size);
        bw.write(s);
        bw.close();
    }
}


// 1. min, max값 입력받고 long타입으로 형변환
// 2. 해당 범위의 크기에 맞는 배열 선언(이때 배열의 최대크기는 백만이므로 int형 배열로 선언 가능)
// 3. max보다 작거나 같은 'i제곱의 배수'들을 배열의 해당 인덱스에 true로 표시
//      3-1. 이때, min보다 작은 'i제곱의 배수'가 연산에 사용되어서는 안된다. => min%pow가 0이 아니라면 'min/pow의 몫에 1을 더한 값'과 제곱수를 곱해 나온 값으로 검증을 시작한다.
//      3-2. ex) min = 10, 10%4 = 2, 4의 배수 존재여부 검증을 시작하기 위한 처음 숫자는 12(4 * 3)이 된다. 검증에 사용되는 숫자가 10보다 작을 순 없기 때문이다.
//      3-3. 범위 내 임의값에 해당하는 인덱스: 임의값 - min(범위가 1부터 시작하는게 아니기 때문에 min을 빼주면 된다.)
// 4. 마지막으로, 배열 내의 false개수를 세어 반환하면 끝!