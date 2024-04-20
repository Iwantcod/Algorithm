import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 선언할때마다 각자 다른 Scanner 객체를 이용하는 셈이 된다.
        //System.out.print("테스트 케이스 개수 입력(정수): ");
        int n = sc.nextInt(); // test case num
        int cnt = 0;    // 중첩된 O의 개수, 즉 점수.
        int[] result = new int[n];
        String st = null;
        sc.nextLine();


        for (int i = 0; i < n; i++) {  // 테스트 케이스 순서

            st = sc.nextLine();     // 문자열 입력받을 변수

            while(true) {

                if(st.length() < 80 && st.length() > 0) {   // 입력받은 문자열이 80 미만 && 0 초과이면 테스트 통과 -> 루프 탈출
                    break;
                }

                //System.out.print("다시입력: ");            // 조건을 만족하지 못했을 경우, 문자열 다시 입력
                st = sc.nextLine();

            }


            for (int j = 0; j < st.length(); j++) { // 입력한 문자열 점수 반환하는 for문
                if (st.charAt(j) == 'O') {
                    cnt++;      // 'O' 발견 시 카운트 변수 1 증가
                    result[i] += cnt;   // 카운트 변수의 현재값을 결과 변수에 더하기
                } else if (st.charAt(j) == 'X') {
                    cnt = 0;
                } else {
                    System.out.println("Error!!!!!");
                    cnt = 0;
                    break;
                }
            }
            cnt = 0;        // 다음 문자열 검사를 위해 카운트 변수 0으로 초기화
        }
        for(int i=0;i<n;i++) {      // 각 문자열의 점수를 출력
            System.out.println(result[i]);
        }
    }
}