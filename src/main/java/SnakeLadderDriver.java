import bo.Ladder;
import bo.Player;
import bo.Snake;
import intf.PlayingStrategy;
import service.PlayingStrategyImpl;
import service.SnakeLadderBoard;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class SnakeLadderDriver {
    public static void main(String[] args) {
        SnakeLadderBoard snakeLadderBoard = new SnakeLadderBoard();

        snakeLadderBoard.addLadder(new Ladder(4,9));
        snakeLadderBoard.addLadder(new Ladder(18,29));
        snakeLadderBoard.addLadder(new Ladder(40,99));
        snakeLadderBoard.addLadder(new Ladder(24,79));
        snakeLadderBoard.addSnake(new Snake(12,8));
        snakeLadderBoard.addSnake(new Snake(19,4));
        snakeLadderBoard.addSnake(new Snake(90,2));

        Player p1 = new Player(1,"Muskan");
        Player p2 = new Player(2,"Prashant");
        Player p3 = new Player(3,"Rahul");
        Player p4 = new Player(4,"Debo");

        List<Player> playerList = new ArrayList<>();
        playerList.add(p1);
        playerList.add(p2);
        playerList.add(p3);
        playerList.add(p4);

        PlayingStrategy playingStrategy = new PlayingStrategyImpl(playerList);
        Player currPlayer = playingStrategy.getTurn();

        while (true){
            System.out.println("Playing "+currPlayer.getName());
            int i = Utils.rollDice();

            int playerFinalPosition = snakeLadderBoard.getPlayerFinalPosition(currPlayer.getCurrPosition(), i);

            System.out.println("moved from "+currPlayer.getCurrPosition() +" to "+playerFinalPosition);

            currPlayer.setCurrPosition(playerFinalPosition);
            if(snakeLadderBoard.isWinning(playerFinalPosition)){
                currPlayer.setWinner(true);
                System.out.println("winner is "+currPlayer.getName());
                break;
            }
            currPlayer = playingStrategy.getTurn();
        }




    }
}
