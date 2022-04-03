package Queue;

import java.util.ArrayList;

import Tree.StateTreeNode;

public class BnBQueue<T> extends ArrayList<StateTreeNode<T>> {
    public BnBQueue(){

    }
    public void enqueue(StateTreeNode<T> elmt){
        int i = 0;
        while (i < size() && get(i).cost() <= elmt.cost()) {
            i++;
        }
        if (i == size()){
            add(elmt);
        } else {
            add(i, elmt);
        }
    }

    public StateTreeNode<T> dequeue(){
        return remove(0);
    }
}
