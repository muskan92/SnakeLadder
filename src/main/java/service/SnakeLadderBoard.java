package service;

import bo.Ladder;
import bo.Snake;

import java.util.HashMap;
import java.util.Map;

public class SnakeLadderBoard {

    Map<Integer,Integer> snakeHeadTailMap = new HashMap<>();
    Map<Integer,Integer> ladderStartEndMap = new HashMap<>();

    int size = 100;

    public SnakeLadderBoard() {
    }

    public SnakeLadderBoard(int size) {
        this.size = size;
    }

    public void addSnake(Snake snake){
        snakeHeadTailMap.put(snake.getHead(),snake.getTail());
    }
    public void addLadder(Ladder ladder){
        ladderStartEndMap.put(ladder.getStart(),ladder.getEnd());
    }

    public boolean isWinning(int currentPosition){
        return currentPosition==size;
    }

    public int getPlayerFinalPosition(int currentPosition,int diceNumber){
        int finalPosition = currentPosition+diceNumber;
        int positionBefore = 0;
        if(finalPosition > size){
            return currentPosition;
        }
        /**
         * 10
         *
         */
        while(positionBefore != finalPosition) {
            positionBefore = finalPosition;
            if (snakeHeadTailMap.containsKey(finalPosition)) {
                positionBefore = finalPosition;
                finalPosition = snakeHeadTailMap.get(finalPosition);
                System.out.println("~ Snake bite from "+positionBefore+" to "+finalPosition);
            }
            if (ladderStartEndMap.containsKey(finalPosition)) {
                positionBefore = finalPosition;
                finalPosition = ladderStartEndMap.get(finalPosition);
                System.out.println("^ Ladder jump from "+positionBefore+" to "+finalPosition);

            }

        }

        return finalPosition;
    }

}
