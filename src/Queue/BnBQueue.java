package Queue;

import java.util.ArrayList;
import Puzzle.Puzzle;
import Tree.StateTreeNode;

public class BnBQueue extends ArrayList<StateTreeNode<Puzzle>> {
    public BnBQueue(){

    }
    public void enqueue(StateTreeNode<Puzzle> elmt){
        int i = 0;
        int c = elmt.cost();
        while (i < size() && get(i).cost() <= c) {
            i++;
        }
        if (i == size()){
            add(elmt);
        } else {
            add(i, elmt);
        }
    }

    public StateTreeNode<Puzzle> dequeue(){
        return remove(0);
    }
}
