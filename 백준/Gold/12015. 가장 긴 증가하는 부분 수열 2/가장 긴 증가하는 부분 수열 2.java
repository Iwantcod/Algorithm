import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] lis = new int[n];
        String[] sp = br.readLine().split(" ");
        for(int i = 0; i < sp.length; i++) {
            arr[i] = Integer.parseInt(sp[i]);
        }

        lis[0] = arr[0];
        int indx = 0;
        for(int i = 0; i < n; i++) {
            if (lis[indx] > arr[i]) {
                change(lis, 0, indx, arr[i]);
            } else if(lis[indx] < arr[i]) {
                indx++;
                lis[indx] = arr[i];
            }
        }

        System.out.println(indx + 1);

    }
    public static void change(int[] lis, int left, int right, int target) {
        int result = 0;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(lis[mid] >= target) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        lis[result] = target;
    }
}