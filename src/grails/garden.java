package grails;

import java.io.*;

public class garden {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int tests = Integer.parseInt(reader.readLine());
        while (tests-- > 0) {
            String[] params = reader.readLine().split(" ");
            int rows = Integer.parseInt(params[0]);
            String[] garden = new String[rows];
            for (int i = 0; i < rows; i += 1) {
                garden[i] = reader.readLine();
            }
            out.write(computeElegance(garden) + "\r\n");
        }
        out.flush();
    }

    public static int computeElegance(String[] garden) {
        int squares = 0;
        int rows = garden.length;
        int columns = garden[0].length();

        for (int i = 0; i < rows - 1; i += 1) {
            for (int j = 0; j < columns - 1; j += 1) {
                char tLeftChar = garden[i].charAt(j);
                for (int tRight = j + 1; tRight < columns; tRight += 1) {
                    for (int bLeft = i + 1; bLeft < rows; bLeft += 1) {
                        if (garden[i].charAt(tRight) == tLeftChar) {
                            if (garden[bLeft].charAt(j) == tLeftChar) {
                                if (garden[bLeft].charAt(tRight) == tLeftChar) {
                                    squares += 1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return squares;
    }
}
