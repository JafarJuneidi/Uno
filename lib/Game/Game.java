import java.util.Stack;

public class Game {
    private final PlayerTable players;
    private Stack<Card> drawPile;
    private Stack<Card> discardPile;
    private Player winner;

    public Game(Stack<Card> drawPile, PlayerTable players) {
        this.drawPile = drawPile;
        this.players = players;
        this.discardPile = new Stack<>();
    }

    public void play() {
        Card topCard = drawPile.pop();
        discardPile.push(topCard);
        if (topCard instanceof ActionCard)
            ((ActionCard) topCard).action(this);

        players.next();

        while (winner == null) {
           Card playCard = players.getCurrentPlayer().pickCard(discardPile.peek());
           if (!isValidPlayCard(playCard)) {
               // some exception
           }

           discardPile.add(playCard);
           if (playCard instanceof ActionCard)
               ((ActionCard) playCard).action(this);

           if (players.getCurrentPlayer().cardSize() == 0) {
               winner = players.getCurrentPlayer();
           }
        }
    }

    private boolean isValidPlayCard(Card card) {
        return false;
    }
}
