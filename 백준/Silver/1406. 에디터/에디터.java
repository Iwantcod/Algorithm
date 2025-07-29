import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int commendNum = Integer.parseInt(br.readLine());
        int cursor = str.length();
        LinkedList<Character> arr = new LinkedList<>();
        
        for(int i = 0; i < str.length(); i++) {
            arr.add(str.charAt(i));
        }
        ListIterator<Character> iter = arr.listIterator(); // 양방향 iterator

        while(iter.hasNext()) {
            iter.next();
        }

        for(int i = 0; i < commendNum; i++) {
            String input = br.readLine();
            char commend = input.charAt(0);
            switch(commend) {
                case 'L':
                    if(iter.hasPrevious())
                        iter.previous();
                    break;
                case 'D':
                    if(iter.hasNext())
                        iter.next();
                    break;
                case 'B':
                    if(iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case 'P':
                    char c = input.charAt(2);
                    iter.add(c);
                    break;
            }
            // System.out.println("cur commend: "+input+", cursor index:" + cursor);
            // for(char cur : arr) {
            //     System.out.print(cur);
            // }
            // System.out.println();
            // System.out.println();
        }
        
        for(char cur : arr) {
            bw.write(cur);
        }
        
        bw.close();
    }
}