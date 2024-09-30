import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];

        StringTokenizer strtkA = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(strtkA.nextToken());
        }
        StringTokenizer strtkB = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(strtkB.nextToken());
        }


        Integer[] tmpB = Arrays.stream(B).boxed().toArray(Integer[]::new);

        // 기본정렬(오름차순)은 별도의 클래스를
        Arrays.sort(A);
        // comparator을 이용하여 정렬의 조건을 임의 지정해주기 위해서는
        // Wrapper class타입의 객체를 인자로 넘겨줘야 한다. (제네릭 타입을 받는다)
        Arrays.sort(tmpB, ((o1, o2) -> {
            return o2 - o1;
        }));
        /*
        Arrays.sort(tmpB, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        */

        int result = 0;
        for (int i = 0; i < N; i++) {
            result += (A[i]*tmpB[i]);
        }
        System.out.println(result);
    }
}