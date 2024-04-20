import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 선언할때마다 각자 다른 Scanner 객체를 이용하는 셈이 된다.
        //System.out.print("테스트 케이스 개수 입력(정수): ");
        int n = sc.nextInt();   // 설탕 kg 입력

        int cnt5 = 0;   // 5kg 봉지 사용 개수
        int cnt3 = 0;   // 3kg 봉지 사용 개수

        while(n<3 || n > 5000) {   // n은 3 이상 5000 이하의 값을 가질 수 있다.
            // System.out.print("범위에 맞는 값을 입력(3 <= n <= 5000): ");
            n = sc.nextInt();
        }

        while(n != 0) {
            //System.out.println("현재 n의 값: "+n); // 계산 과정 확인용
            if(n == 4 || n == 7) {  // 4, 7은 어떤 방법을 써도 딱 맞아떨어지게 봉지에 담을 수 없다.
                System.out.println(-1);
                break;
            }
            if(n%5 == 0) {      // n이 5의 배수인 경우 또한 딱히 계산할 것이 없다.
                cnt5 = n/5;
                n = 0;
            }
            if(n<15 && n%3 == 0) {      // 남은 n의 값이 15미만이면서 3의 배수인 경우, 남은 설탕을 모두 3kg 봉지에 담는다.
                cnt3 += n/3;
                n = 0;
            } else {
                cnt5++;
                n -= 5;
            }
            //System.out.println("5kg 봉지 사용개수: "+cnt5+", 3kg봉지 사용개수: "+cnt3);
        }
        if(n == 0){     // 4, 7같은 수가 입력된 경우 출력하지 않기 위해 if문 안에 출력문을 넣었다.
            System.out.println(cnt3 + cnt5);
        }
    }
}