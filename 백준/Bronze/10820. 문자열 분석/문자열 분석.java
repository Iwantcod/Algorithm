import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;
        while((str = br.readLine()) != null) {
            int lower = 0, upper = 0, num = 0, blank = 0;
            for(int i = 0; i < str.length(); i++) {
                char cur = str.charAt(i);
                if(Character.isLowerCase(cur))
                    lower++;
                else if(Character.isUpperCase(cur))
                    upper++;
                else if(Character.isDigit(cur))
                    num++;
                else if(Character.isWhitespace(cur))
                    blank++;
            }
            bw.write(String.valueOf(lower)+" "+String.valueOf(upper)+" "+String.valueOf(num)+" "+String.valueOf(blank)+"\n");
        }
        bw.close();
    }
}