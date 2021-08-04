package service;

import bo.Player;
import intf.PlayingStrategy;

import java.util.List;

public class PlayingStrategyImpl extends PlayingStrategy {
    int n =0;

    public PlayingStrategyImpl(List<Player> playerList) {
        super(playerList);
    }

    @Override
    public Player getTurn() {
        Player player = playerList.get(n % playerList.size());
        n++;
        return player;

    }
}
