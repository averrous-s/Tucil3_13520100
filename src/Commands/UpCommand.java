package Commands;

import Puzzle.Puzzle;

public class UpCommand implements Command<Puzzle> {
    public Puzzle nextState(Puzzle previousState){
        previousState = previousState.copy();

        int[] oldPos = previousState.getPosition(16);
        int[] newPos = new int[]{oldPos[0] - 1, oldPos[1]};
        previousState.setPosition(previousState.occupiedBy(newPos), oldPos);
        previousState.setPosition(16, newPos);
        return previousState;
    }

    public boolean isAllowed(Puzzle previousState){
        int[] oldPos = previousState.getPosition(16);        
        return oldPos[0] - 1 >= 0;
    }

    @Override
    public String toString(){
        return "UP";
    }

    public String opposite(){
        return "DOWN";
    }
}