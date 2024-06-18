import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] classAry = new String[20];
        double[] scoreAry = new double[20];
        double[] avgRankAry = new double[20];       // 문자열로 입력되는 과목평점을 숫자로 치환하여 입력받을 예정

        String avgRankString = "";
        for (int i = 0; i < 20; i++) {
            StringTokenizer strtk = new StringTokenizer(br.readLine(), " ");
            classAry[i] = strtk.nextToken();
            scoreAry[i] = Double.parseDouble(strtk.nextToken());
            avgRankString = strtk.nextToken();
            if(avgRankString.equals("A+")) {
                avgRankAry[i] = 4.5;
            } else if (avgRankString.equals("A0")) {
                avgRankAry[i] = 4.0;
            } else if (avgRankString.equals("B+")) {
                avgRankAry[i] = 3.5;
            } else if (avgRankString.equals("B0")) {
                avgRankAry[i] = 3.0;
            } else if (avgRankString.equals("C+")) {
                avgRankAry[i] = 2.5;
            } else if (avgRankString.equals("C0")) {
                avgRankAry[i] = 2.0;
            } else if (avgRankString.equals("D+")) {
                avgRankAry[i] = 1.5;
            } else if (avgRankString.equals("D0")) {
                avgRankAry[i] = 1.0;
            } else if (avgRankString.equals("F")) {
                avgRankAry[i] = 0.0;
            } else {
                scoreAry[i] = 0.0;
                avgRankAry[i] = 0.0;
            }
        }

        double sumScore = 0.0;
        double scoreMulRank = 0.0;
        for (int j = 0; j < 20; j++) {
            sumScore += scoreAry[j];
            scoreMulRank += scoreAry[j] * avgRankAry[j];
        }
        System.out.println(scoreMulRank / sumScore);
    }
}