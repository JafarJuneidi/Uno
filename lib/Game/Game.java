import java.util.*;

public class Game {
    private final PlayersManager playersManager;
    private final CardPile drawPile;
    private final CardPile discardPile;
    private Direction direction;
    private final int cardsDealt;
    private final int pointsToWin;

    public Game(CardPile drawPile, PlayersManager playersManager) {
        this.playersManager = playersManager;
        this.drawPile = drawPile;
        this.discardPile = new DefaultCardPile(new Stack<>());
        this.direction = Direction.CLOCKWISE;
        this.cardsDealt = 7;
        this.pointsToWin = 500;
    }

    public void playTurn() {
        // display options
        displayOptions(playersManager.currentPlayerGetHand());
        // pick option
        int index = scanUserInput();

        if (index == 0) {
            playersManager.currentPlayerAddCard(drawPile.removeCard());
        } else {
            Card card = playersManager.currentPlayerPickCard(index - 1);

            if (!validation(card, drawPile.peekCard())) {
                playTurn();
                return;
            }

            playersManager.currentPlayerRemoveCard(card);
            discardPile.addCard(card);
            card.play(this);
        }

        playersManager.nextPlayer(direction);
    }

    public void playRound() {
        initializeRound();
        while (!playersManager.hasEmptyHandPlayer()) {
            playTurn();
        }
        playersManager.calculatePoints();
    }

    public void play() {
        while (playersManager.findPlayerWithEqualOrGreaterPoints(pointsToWin) == null) {
            playRound();
        }

        // Todo Game over Winner found
    }

    private void reverseDirection() {
        this.direction = this.direction.reverse();
    }

    private void initializeRound() {
        // retrieve all cards from players
        // add cards back to draw pile
        drawPile.addCards(playersManager.collectAllCards());
        // shuffle draw pile
        drawPile.shuffle();
        // deal cards to players
        List<List<Card>> dealingCards = drawPile.getPlayerHands(playersManager.getNumberOfplayers(), cardsDealt);
        playersManager.dealHands(dealingCards);
        // play first card
        Card card = drawPile.removeCard();
        discardPile.addCard(card);
        card.play(this);
        playersManager.nextPlayer(direction);
    }

    public void displayOptions(List<Card> cards) {
        if (cards.isEmpty()) {
            System.out.println("No cards available to play.");
        } else {
            System.out.println(0 + ". Draw a card from the deck.");

            System.out.println("Here are your available cards to play:");
            for (int i = 0; i < cards.size(); i++) {
                System.out.println((i + 1) + ". " + cards.get(i).toString());
            }
        }

        System.out.println("Enter the number of the card you want to play, or " + 0 + " to draw a card.");
    }

    public int scanUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public boolean validation(Card a, Card b) {
        // Todo
        return true;
    }
}