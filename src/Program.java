import IO.*;
import Puzzle.BnBPuzzle;
public class Program {
    public static void welcome(){
        System.out.println("Welcome to 15-Puzzle Solver");
    }

    public static int[][] input(){
        System.out.println("Input your puzzle down here");
        int[][] c = new int[][]{};
        try {
            c = IOManagement.read();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return c;
    }
    public static void main(String[] args) {
        welcome();
        BnBPuzzle solver = new BnBPuzzle(input());
        solver.run();
    }
}
