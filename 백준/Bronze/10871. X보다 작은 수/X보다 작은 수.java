import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n<1 || n>10000) {
            n = sc.nextInt();
        }
        int x = sc.nextInt();
        if (x<1 || x>10000) {
            x = sc.nextInt();
        }
        int[] inputAry = new int[n];

        for(int i=0;i<n;i++) {
            inputAry[i] = sc.nextInt();
            if(inputAry[i]<1 || inputAry[i]>10000) {
                inputAry[i] = sc.nextInt();
            }
        }
        for(int i=0;i<n;i++) {
            if(inputAry[i]<x) {
                System.out.print(inputAry[i]+" ");
            }
        }
    }
}