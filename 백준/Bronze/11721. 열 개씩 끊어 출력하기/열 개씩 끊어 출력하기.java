import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = br.readLine();
        int len = str.length();
        if(len < 10) {
            bw.write(str);
            bw.close();
        } else {
            int index = 0;
            for(int i = 0; i < len/10; i++) {
                index = i*10;
                bw.write(str.substring(index, index+10) + "\n");
            }
            index += 10;
            bw.write(str.substring(index));
            bw.close();
        }
    }
}