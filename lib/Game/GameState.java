import java.util.Stack;

public class GameState {
    private final Player[] players;
    private int currentPlayerIndex;
    private final CardPile drawPile;
    private final CardPile discardPile;
    private Direction direction;

    public GameState(CardPile drawPile, Player[] players) {
        this.drawPile = drawPile;
        this.players = players;
        this.currentPlayerIndex = 0;
        this.discardPile = new DefaultCardPile(new Stack<>());
        this.direction = Direction.CLOCKWISE;
    }
}
