package Puzzle;

import java.util.ArrayList;

import IO.IOManagement;
import Queue.BnBQueue;
import Tree.StateTreeNode;

public class BnBPuzzle {
    private BnBQueue<Puzzle> queue;
    public Puzzle problem;

    public BnBPuzzle(int[][] p) {
        problem = new Puzzle(p);
    }

    private void enqueueAllChild(StateTreeNode<Puzzle> n) {
        for (int i = 0; i < n.childs.size(); i++) {
            queue.enqueue(n.childs.get(i));
        }
    }

    public static void main(String[] args) {
        BnBPuzzle l = new BnBPuzzle(IOManagement.read());
        l.run();
    }

    public void printInitialStatus(StateTreeNode<Puzzle> initialState) {
        System.out.println("INITIAL STATE");
        initialState.val.print();
        System.out.println();
        System.out.println("'KURANG' VALUE");
        for (int i = 1; i <= 16; i++) {
            System.out.print(i + ":" + DifferenceTheorem.difference(i, initialState.val.getContent()) + "; ");
        }
        System.out.println();
        System.out.println();
        System.out.println(
                "'REACHABLE GOAL' THEOREM VALUE: " + DifferenceTheorem.differeceTheorem(initialState.val.getContent()));
    }

    public void run() {
        StateTreeNode<Puzzle> access;
        StateTreeNode<Puzzle> initialState = new StateTreeNode<Puzzle>(problem, 0, "", new ArrayList<>());
        queue = new BnBQueue<>();
        System.out.println();
        printInitialStatus(initialState);
        // some time passes
        if (DifferenceTheorem.differeceTheorem(initialState.val.getContent()) % 2 == 0) {
            System.out.println("Solving...");
            queue.enqueue(initialState);
            boolean found = false;
            long start = System.nanoTime();
            while (!queue.isEmpty() && !found) {
                access = queue.dequeue();
                if (access.val.isGoal()) {
                    found = true;
                    long end = System.nanoTime();
                    access.printPath(initialState.val);
                    long elapsedTime = end - start;
                    System.out.println("ELAPSED TIME: " + elapsedTime +" nanoseconds");
                } else {
                    access.expand();
                    enqueueAllChild(access);
                }
            }
        } else {
            System.out.println();
            System.out.println("SOLUTION IS UNREACHABLE");
        }

    }
}
