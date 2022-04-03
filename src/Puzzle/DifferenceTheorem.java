package Puzzle;
public class DifferenceTheorem {
    public static int difference(int num, int[][] p) {
        int val = 0;
        int[] positionNum = p[num - 1];
        int idxSmaller = num - 2;
        while (idxSmaller >= 0) {
            if (isPositionBigger(p[idxSmaller], positionNum)) {
                val++;
            }
            idxSmaller--;
        }
        return val;
    }


    public static int differeceTheorem(int[][] p){
        int X;
        int differenceTotal = 0;
        if (isPositionInShade(p[p.length - 1])) {
            X = 1;
        } else {
            X = 0;
        }

        for (int i = 0; i < p.length; i++) {
            differenceTotal += difference(i+1, p);
        }

        return differenceTotal + X;
    }
    private static boolean isPositionBigger(int[] a1, int[] a2){
        if ((a1[0] == a2[0] && a1[1] <= a2[1]) || a1[0] < a2[0]) {
            return false;
        } else {
            return true;
        }
    }

    private static boolean isPositionInShade(int[] a) {
        return (a[0] + a[1]) % 2 != 0;
    }
}
