package intf;

import bo.Player;

import java.util.List;

public abstract class PlayingStrategy {
    protected List<Player> playerList ;

    public PlayingStrategy(List<Player> playerList) {
        this.playerList = playerList;
    }

    public abstract Player getTurn();
}
