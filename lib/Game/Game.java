import java.util.*;

public abstract class Game {
    private final Player[] players;
    private int currentPlayerIndex;
    private final CardPile drawPile;
    private final CardPile discardPile;
    private Direction direction;
    private final int cardsDealt;
    private final int pointsToWin;

    public Game(CardPile drawPile, Player[] players, int cardsDealt, int pointsToWin) {
        this.players = players;
        this.currentPlayerIndex = 0;
        this.cardsDealt = cardsDealt;
        this.pointsToWin = pointsToWin;
        this.drawPile = drawPile;
        this.discardPile = new DefaultCardPile(new Stack<>());
        this.direction = Direction.CLOCKWISE;
    }

    public void play() {
        while (findGameWinner(pointsToWin) == null) {
            playRound();
        }

        System.out.println("Game Over, Winner is:" + findGameWinner(pointsToWin).getName() + " with " + findGameWinner(pointsToWin).getPlayerPoints() + " Points");
    }

    private void playRound() {
        System.out.println("Round Started");
        initializeRound();
        while (findRoundWinner() == null) {
            playTurn();
        }
        calculateRoundPoints(findRoundWinner());
        System.out.println("Round winner is: " + findRoundWinner().getName() + " with " + findRoundWinner().getPlayerPoints() + " Points");
        System.out.println("-----------------------------------------------------------");
    }

    private void playTurn() {
        Card card = null;
        do {
            // display options
            displayOptions(getCurrentPlayer().getAllCards());
            // pick option
            int index = scanUserInput();

            if (index == 0) {
                Card drawnCard = drawCards(1).get(0);
                if (discardPile.peekCard().matches(drawnCard)) {
                    System.out.println("Your Card is a match and will be played!!!!!!");
                    discardCard(drawnCard);
                    drawnCard.play(this);
                } else {
                    getCurrentPlayer().addCards(List.of(drawnCard));
                }
                moveIndexToNextPlayer();
                return;
            }

            card = getCurrentPlayer().getCard(index - 1);
        } while (!discardPile.peekCard().matches(card));

        getCurrentPlayer().removeCard(card);
        discardCard(card);
        card.play(this);
        moveIndexToNextPlayer();
    }

    private void initializeRound() {
        this.currentPlayerIndex = 0;
        this.drawPile.addCards(this.discardPile.removeAllCards());
        this.direction = Direction.CLOCKWISE;

        // retrieve all cards from players
        // add cards back to draw pile
        drawPile.addCards(collectAllCards());
        // shuffle draw pile before dealing
        drawPile.shuffle();
        // deal cards to players
        List<List<Card>> dealingCards = drawPile.getPlayerHands(getNumberOfPlayers(), cardsDealt);
        dealHands(dealingCards);
        // shuffle draw pile until a no action card faces up
        while (drawPile.peekCard().hasPlayBehavior()) {
            drawPile.shuffle();
        }
        // play first card
        Card card = drawPile.removeCard();
        discardCard(card);
        card.play(this);
    }

    public Direction getDirection() {
        return this.direction;
    }

    private Player getCurrentPlayer() {
        return players[currentPlayerIndex];
    }

    public Player getNextPlayer() {
        return players[getNextPlayerIndex(direction)];
    }

    public void moveIndexToNextPlayer() {
        currentPlayerIndex = getNextPlayerIndex(this.direction);
    }

    private int getNextPlayerIndex(Direction direction) {
        return (getNumberOfPlayers() + currentPlayerIndex + direction.getValue()) % getNumberOfPlayers();
    }

    private void calculateRoundPoints(Player roundWinner) {
        int points = 0;
        for (Player player: players) {
            if (player.handSize() != 0) {
                points += player.getHandPoints();
            }
        }

        roundWinner.setPlayerPoints(roundWinner.getPlayerPoints() + points);
    }

    private Player findRoundWinner() {
        for (Player player: players) {
            if (player.handSize() == 0) {
                return player;
            }
        }
        return null;
    }

    private Player findGameWinner(int pointsToWin) {
        for (Player player: players) {
            if (player.getPlayerPoints() >= pointsToWin) {
                return player;
            }
        }
        return null;
    }

    public void reverseDirection() {
        this.direction = this.direction.reverse();
    }

    private void dealHands(List<List<Card>> cards) {
        for (int i = 0; i < cards.size(); ++i) {
            players[i].addCards(cards.get(i));
        }
    }

    private List<Card> collectAllCards() {
        List<Card> allCards = new ArrayList<>();
        for (Player player: players) {
            allCards.addAll(player.getAllCards());
            player.resetHand();
        }

        return allCards;
    }

    private void displayOptions(List<Card> cards) {
        System.out.println(getCurrentPlayer().getName() + "'s turn!");
        System.out.println("Card to match: " + discardPile.peekCard());

        if (cards.isEmpty()) {
            System.out.println("No cards available to play.");
        } else {
            System.out.println("Here are your available cards to play:");
            System.out.println(0 + ". Draw a card from the deck.");
            for (int i = 0; i < cards.size(); i++) {
                System.out.println((i + 1) + ". " + cards.get(i).toString());
            }
        }

        System.out.println("Enter the number of the card you want to play, or " + 0 + " to draw a card.");
    }

    private int scanUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public List<Card> drawCards(int n) {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            cards.add(drawPile.removeCard());
        }

        return cards;
    }

    public int getNumberOfPlayers() {
        return players.length;
    }

    public void discardCard(Card card) {
        discardPile.addCard(card);
    }
}