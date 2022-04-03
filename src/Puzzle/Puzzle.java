package Puzzle;

public class Puzzle  {
    /* 
    content berbentuk 16x2 dengan 16 angka yang menyimpan 2 buah nilai posisi
    pendekatan ini dipilih karena memudahkan pencarian dan pertukaran posisi
    */
    private int[][] content;
    public Puzzle(int[][] c){
        content = c;
    }

    public void copy(Puzzle a){
        // a has been initialize
        a.content = content;
    }

    public Puzzle copy(){
        Puzzle b = new Puzzle(content.clone());
        return b;
    }

    public int[][] getContent() {
        return content;
    }

    public void print(){
        int tmp;
        for (int i = 0; i< 4; i++){
            for (int j = 0; j < 4; j++){
                tmp = occupiedBy(new int[]{i, j});
                if (tmp == 16) {
                    System.out.print("? ");
                } else {
                    System.out.print(tmp +" ");
                }
            }
            System.out.println();
        }
    }
    /* 
    Untuk melakukan print, perlu dilakukan pencarian mana angka yang harus diprint duluan
    */
    public void printPositionStatus(){
        for (int i = 0; i < content.length; i++) {
            System.out.print("Position of " + (i+1) + " is in position of " );
            System.out.print(correctNumberOf(content[i]));
            System.out.println();
        }
    }

    public void setPosition(int num, int[] position) {
        content[num - 1] = position;
    }


    public int[] getPosition(int num){
        return content[num-1];
    }

    public boolean isGoal(){
        boolean v = true;
        int i = 0;
        while (i < content.length && v) {
            v = v && isCorrectPosition(i+1, content[i]);
            i++;
        }

        return v;
    }

    public static boolean isCorrectPosition(int num, int[] pos){
        return (pos[0]*4 + pos[1] + 1) == num;
    }

    public static int correctNumberOf(int[] pos) {
        return (pos[0]*4 + pos[1] + 1);
    }

    public static int[] correctPositionOf(int num) {
        int row = num / 4;
        int col = num % 4;
        return new int[]{row, col};
    }

    private static boolean isArrEqual(int[] a, int[] b){
        if (a.length == b.length){
            int i = 0;
            boolean same = true;
            while (i < a.length && same){
                same = a[i] == b[i];
                i++;
            }
            return same;
        } else {
            return false;
        }
    }

    public int occupiedBy(int[] pos) {
        int i = 0;
        while (i < content.length && !isArrEqual(pos, content[i])){      
            i++;
        }
        
        if (i < content.length && isArrEqual(pos, content[i])) {
            return i + 1;
        } else {
            return -1;
        }
    }

}
