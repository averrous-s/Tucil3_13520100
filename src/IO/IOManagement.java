package IO;

import java.io.*;
import java.util.Scanner;

public class IOManagement {
    public static void main(String[] args) {
        read();
    }

    public static int[][] readFile(String p) {
        int[][] puzzle = new int[16][2];
        try {
            File file = new File(p);
            BufferedReader b = new BufferedReader(new FileReader(file));
            String st;
            int row = 0;
            while ((st = b.readLine()) != null) {
                int[] l = readLine(st);
                for (int i = 0; i < l.length; i++) {
                    puzzle[l[i] - 1] = new int[] { row, i };
                }
                row++;
            }
            b.close();
        } catch (Exception e) {

        }
        return puzzle;

    }

    private static int[] readLine(String l) {
        int i = 0;
        String tmp = "";
        int[] val = new int[4];
        int eff = 0;
        String t;

        while (i < l.length() && (t = l.substring(i, i + 1)) != null) {
            if (t.equals(" ") && (tmp.equals(" ") || tmp.equals("?"))) {
                val[eff] = 16;
                tmp = "";
                eff++;
            } else if (t.equals(" ") && tmp.strip().length() != 0) {
                val[eff] = (Integer.parseInt(tmp.strip()));
                tmp = "";
                eff++;
            } else {
                tmp += t;
            }

            if (i == l.length() - 1 && tmp.strip().length() != 0) {
                val[eff] = (Integer.parseInt(tmp.strip()));
            } else if (i == l.length() - 1 && tmp.equals(" ")) {
                val[eff] = 16;
            }
            i++;
        }

        return val;
    }

    public static int[][] read() {
        Scanner s = new Scanner(System.in);
        int[][] content = new int[16][2];
        String line;
        int[] rowContent;

        for (int row = 0; row < 4; row++) {
            line = s.nextLine();
            rowContent = readLine(line);
            for (int i = 0; i < rowContent.length; i++) {
                content[rowContent[i] - 1] = new int[] { row, i };
            }
        }

        s.close();
        return content;
    }
}
