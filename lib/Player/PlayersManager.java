import java.util.ArrayList;
import java.util.List;

public class PlayersManager {
    private final Player[] players;
    private int currentPlayerIndex;

    private Player emptyHandPlayer;

    public PlayersManager(Player[] players) {
        this.players = players;
        currentPlayerIndex = 0;
        emptyHandPlayer = null;
    }

    public int getNumberOfplayers() {
        return players.length;
    }

    public void nextPlayer(Direction direction) {
        currentPlayerIndex = getNextPlayerIndex(direction);
    }

    private int getNextPlayerIndex(Direction direction) {
        return (players.length + currentPlayerIndex + direction.getValue()) % players.length;
    }

    private Player getCurrentPlayer() {
        return players[currentPlayerIndex];
    }

    public Card currentPlayerPickCard(int index) {
        Player currentPlayer = getCurrentPlayer();
        return currentPlayer.pickCard(index);
    }

    public List<Card> currentPlayerGetHand() {
        Player currentPlayer = getCurrentPlayer();
        return currentPlayer.getAllCards();
    }

    public boolean currentPlayerRemoveCard(Card cards) {
        Player currentPlayer = getCurrentPlayer();

        if (currentPlayer.handSize() == 0) {
            emptyHandPlayer = currentPlayer;
        }

        return currentPlayer.removeCard(cards);
    }

    public void currentPlayerAddCard(Card card) {
        Player currentPlayer = getCurrentPlayer();
        currentPlayer.addCard(card);
    }

    public boolean hasEmptyHandPlayer() {
        return emptyHandPlayer == null;
    }

    public void calculatePoints() {
        int points = 0;
        for (Player player: players) {
            if (player != emptyHandPlayer) {
                points += player.getHandPoints();
            }
        }
    }

    public List<Card> collectAllCards() {
        List<Card> allCards = new ArrayList<>();
        for (Player player: players) {
            allCards.addAll(player.getAllCards());
            player.resetHand();
        }

        return allCards;
    }

    public void dealHands(List<List<Card>> cards) {
        for (int i = 0; i < cards.size(); ++i) {
            players[i].addCards(cards.get(i));
        }
    }

    public Player findPlayerWithEqualOrGreaterPoints(int pointsToWin) {
        for (Player player: players) {
            if (player.getPoints() == pointsToWin) {
                return player;
            }
        }
        return null;
    }
}
