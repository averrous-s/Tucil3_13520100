package Commands;

import Puzzle.Puzzle;

public class RightCommand implements Command<Puzzle> {
    public Puzzle nextState(Puzzle previousState){
        previousState = previousState.copy();
        int[] oldPos = previousState.getPosition(16);
        int[] newPos = new int[]{oldPos[0], oldPos[1]+1};
        previousState.setPosition(previousState.occupiedBy(newPos), oldPos);
        previousState.setPosition(16, newPos);
        return previousState;
    }

    public boolean isAllowed(Puzzle previousState){
        int[] oldPos = previousState.getPosition(16);        
        return oldPos[1] + 1 < 4;
    }

    @Override
    public String toString(){
        return "RIGHT";
    }

    public String opposite(){
        return "LEFT";
    }
}
