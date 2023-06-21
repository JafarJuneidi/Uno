import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Stream;

public class PlayerTable {
    private final Player[] players;
    private int currentPlayer = 0;
    private int direction = 1;

    public PlayerTable(Player[] players) {
        this.players = players;
    }

    public Player getCurrentPlayer() {
        return players[currentPlayer];
    }

    public void reverseDirection() {
        direction = -1;
    }

    public Player next() {
        currentPlayer = getNextIndex();
        return getCurrentPlayer();
    }

    private int getNextIndex() {
        return (players.length + currentPlayer + direction) % players.length;
    }
}
