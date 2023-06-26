import java.util.Stack;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
//        Stack<Card> deck = new CardListBuilder().buildAsStack();
//        Player[] players = new Player[];
//        Game game = new Game(deck, );
    }
}
//
//public abstract class Card {
//    private String color;
//
//    public Card(String color) {
//        this.color = color;
//    }
//
//    public String getColor() {
//        return color;
//    }
//
//    public abstract void playCard(Game game, Player currentPlayer);
//}
//
//public class NumberCard extends Card {
//    private int number;
//
//    public NumberCard(String color, int number) {
//        super(color);
//        this.number = number;
//    }
//
//    public int getNumber() {
//        return number;
//    }
//
//    public void playCard(Game game, Player currentPlayer) {
//        // Logic for playing a number card
//        game.advanceTurn();
//    }
//}
//
//public class ActionCard extends Card {
//    private ActionType actionType;
//
//    public ActionCard(String color, ActionType actionType) {
//        super(color);
//        this.actionType = actionType;
//    }
//
//    public ActionType getActionType() {
//        return actionType;
//    }
//
//    public void playCard(Game game, Player currentPlayer) {
//        // Logic for playing an action card
//        switch (actionType) {
//            case SKIP:
//                game.skipNextPlayer();
//                break;
//            case REVERSE:
//                game.reverseTurnOrder();
//                break;
//            case DRAW_TWO:
//                Player nextPlayer = game.getNextPlayer();
//                nextPlayer.drawCards(2);
//                break;
//            // Handle other action card types
//        }
//        game.advanceTurn();
//    }
//}
//
//public class WildCard extends Card {
//    private WildType wildType;
//
//    public WildCard(WildType wildType) {
//        super("Wild");
//        this.wildType = wildType;
//    }
//
//    public WildType getWildType() {
//        return wildType;
//    }
//
//    public void playCard(Game game, Player currentPlayer) {
//        // Logic for playing a wild card
//        // Prompt the player to choose a color or determine the color automatically based on the wild type
//        game.advanceTurn();
//    }
//}
//
//public enum ActionType {
//    SKIP,
//    REVERSE,
//    DRAW_TWO
//}
//
//public enum WildType {
//    WILD,
//    WILD_DRAW_FOUR
//}
//
//public class Deck {
//    private List<Card> cards;
//
//    public Deck() {
//        cards = new ArrayList<>();
//        initializeDeck();
//        shuffle();
//    }
//
//    private void initializeDeck() {
//        // Create and add Uno cards to the deck
//        // Add number cards
//        for (String color : getColors()) {
//            for (int number = 0; number <= 9; number++) {
//                cards.add(new NumberCard(color, number));
//            }
//        }
//
//        // Add action cards
//        for (String color : getColors()) {
//            for (int i = 0; i < 2; i++) {
//                cards.add(new ActionCard(color, ActionType.SKIP));
//                cards.add(new ActionCard(color, ActionType.REVERSE));
//                cards.add(new ActionCard(color, ActionType.DRAW_TWO));
//            }
//        }
//
//        // Add wild cards
//        for (int i = 0; i < 4; i++) {
//            cards.add(new WildCard(WildType.WILD));
//            cards.add(new WildCard(WildType.WILD_DRAW_FOUR));
//        }
//    }
//
//    public void shuffle() {
//        // Shuffle the deck
//        // ...
//    }
//
//    public Card drawCard() {
//        // Draw a card from the deck
//        // Remove it from the deck and return it
//        Card card = cards.remove(cards.size() - 1);
//        return card;
//    }
//
//    public void returnCard(Card card) {
//        // Return a card to the deck
//        // Add it back to the deck
//        cards.add(card);
//    }
//
//    private String[] getColors() {
//        return new String[]{"Red", "Blue", "Green", "Yellow"};
//    }
//}
//
//public class Player {
//    private String name;
//    private List<Card> hand;
//
//    public Player(String name) {
//        this.name = name;
//        this.hand = new ArrayList<>();
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public List<Card> getHand() {
//        return hand;
//    }
//
//    public void playCard(Card card, Game game) {
//        // Remove the card from the player's hand
//        hand.remove(card);
//        card.playCard(game, this);
//    }
//
//    public void drawCard(Deck deck) {
//        // Draw a card from the deck and add it to the player's hand
//        Card card = deck.drawCard();
//        hand.add(card);
//    }
//
//    public void drawCards(int numCards, Deck deck) {
//        // Draw multiple cards from the deck and add them to the player's hand
//        for (int i = 0; i < numCards; i++) {
//            drawCard(deck);
//        }
//    }
//}
//
//public class Game {
//    private List<Player> players;
//    private Deck deck;
//    private List<Card> discardPile;
//    private String activeColor;
//    private Player activePlayer;
//    private boolean reverseOrder;
//
//    public Game(List<Player> players) {
//        this.players = players;
//        this.deck = new Deck();
//        this.discardPile = new ArrayList<>();
//        this.activeColor = "None";
//        this.activePlayer = players.get(0);
//        this.reverseOrder = false;
//    }
//
//    public void startGame() {
//        // Deal initial cards to players
//        for (Player player : players) {
//            player.drawCards(7, deck);
//        }
//
//        // Choose a random card to start the discard pile
//        Card firstCard = deck.drawCard();
//        discardPile.add(firstCard);
//        activeColor = firstCard.getColor();
//
//        // Game loop
//        while (!isGameFinished()) {
//            // Display game state, active player, etc.
//            // ...
//
//            // Handle player's turn
//            Player currentPlayer = getNextPlayer();
//            handlePlayerTurn(currentPlayer);
//
//            // Check if the game is finished
//            if (currentPlayer.getHand().isEmpty()) {
//                break;
//            }
//
//            advanceTurn();
//        }
//
//        // Game over, determine the winner, display results, etc.
//        // ...
//    }
//
//    public void validateMove(Player player, Card card) {
//        if (!player.equals(activePlayer)) {
//            throw new IllegalStateException("It is not " + player.getName() + "'s turn.");
//        }
//
//        if (!card.getColor().equals(activeColor) && card.getColor() != "Wild") {
//            throw new IllegalStateException("You must play a card of the active color: " + activeColor);
//        }
//
//        if (!player.getHand().contains(card)) {
//            throw new IllegalStateException("You don't have the card in your hand.");
//        }
//
//        // Additional validation based on game rules
//        // ...
//    }
//
//    public void executeCardEffect(Card card) {
//        // Execute the effect of the card played
//        card.playCard(this, activePlayer);
//
//        // Update active color based on the card played
//        if (!card.getColor().equals("Wild")) {
//            activeColor = card.getColor();
//        }
//
//        // Add the played card to the discard pile
//        discardPile.add(card);
//    }
//
//    public Player getNextPlayer() {
//        int currentIndex = players.indexOf(activePlayer);
//        int nextIndex = reverseOrder ? (currentIndex - 1) : (currentIndex + 1);
//
//        if (nextIndex < 0) {
//            nextIndex = players.size() - 1;
//        } else if (nextIndex >= players.size()) {
//            nextIndex = 0;
//        }
//
//        return players.get(nextIndex);
//    }
//
//    public void reverseTurnOrder() {
//        reverseOrder = !reverseOrder;
//    }
//
//    public void skipNextPlayer() {
//        activePlayer = getNextPlayer();
//    }
//
//    public void advanceTurn() {
//        activePlayer = getNextPlayer();
//    }
//
//    public boolean isGameFinished() {
//        for (Player player : players) {
//            if (player.getHand().isEmpty()) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    // Other methods for managing turns, updating game state, etc.
//
//    private void handlePlayerTurn(Player player) {
//        boolean validMove = false;
//        Card playedCard = null;
//
//        while (!validMove) {
//            // Display player's hand and other relevant information
//            // ...
//
//            // Prompt the player to choose a card to play
//            // ...
//
//            // Validate the move
//            try {
//                validateMove(player, playedCard);
//                validMove = true;
//            } catch (IllegalStateException e) {
//                // Display error message and prompt the player again
//                // ...
//            }
//        }
//
//        // Play the card and execute its effect
//        player.playCard(playedCard, this);
//    }
//}
//
///////////////////////////////////////////////////////////
//
//import java.util.ArrayList;
//        import java.util.List;
//        import java.util.Scanner;
//
//public abstract class Card {
//    private String color;
//
//    public Card(String color) {
//        this.color = color;
//    }
//
//    public String getColor() {
//        return color;
//    }
//
//    public abstract void playCard(Game game, Player currentPlayer);
//}
//
//public class NumberCard extends Card {
//    private int number;
//
//    public NumberCard(String color, int number) {
//        super(color);
//        this.number = number;
//    }
//
//    public int getNumber() {
//        return number;
//    }
//
//    public void playCard(Game game, Player currentPlayer) {
//        // Logic for playing a number card
//        game.advanceTurn();
//    }
//}
//
//public class ActionCard extends Card {
//    private ActionType actionType;
//
//    public ActionCard(String color, ActionType actionType) {
//        super(color);
//        this.actionType = actionType;
//    }
//
//    public ActionType getActionType() {
//        return actionType;
//    }
//
//    public void playCard(Game game, Player currentPlayer) {
//        // Logic for playing an action card
//        switch (actionType) {
//            case SKIP:
//                game.skipNextPlayer();
//                break;
//            case REVERSE:
//                game.reverseTurnOrder();
//                break;
//            case DRAW_TWO:
//                Player nextPlayer = game.getNextPlayer();
//                nextPlayer.drawCards(2, game.getDeck());
//                break;
//        }
//        game.advanceTurn();
//    }
//}
//
//public class WildCard extends Card {
//    private WildType wildType;
//
//    public WildCard(WildType wildType) {
//        super("Wild");
//        this.wildType = wildType;
//    }
//
//    public WildType getWildType() {
//        return wildType;
//    }
//
//    public void playCard(Game game, Player currentPlayer) {
//        // Logic for playing a wild card
//        String chosenColor = null;
//        if (wildType == WildType.WILD_DRAW_FOUR) {
//            // Prompt the player to choose a color
//            chosenColor = promptColorSelection(currentPlayer);
//        } else {
//            // Automatically determine the color based on the wild type
//            switch (wildType) {
//                case WILD:
//                    chosenColor = promptColorSelection(currentPlayer);
//                    break;
//                case WILD_DRAW_FOUR:
//                    chosenColor = game.getActiveColor();
//                    break;
//            }
//        }
//
//        game.setActiveColor(chosenColor);
//        game.advanceTurn();
//    }
//
//    private String promptColorSelection(Player player) {
//        Scanner scanner = new Scanner(System.in);
//        String chosenColor = null;
//        boolean validColor = false;
//
//        while (!validColor) {
//            System.out.print(player.getName() + ", choose a color (Red, Blue, Green, Yellow): ");
//            chosenColor = scanner.nextLine().trim().toLowerCase();
//
//            if (chosenColor.equals("red") || chosenColor.equals("blue") || chosenColor.equals("green") || chosenColor.equals("yellow")) {
//                validColor = true;
//            } else {
//                System.out.println("Invalid color selection. Please choose a valid color.");
//            }
//        }
//
//        return chosenColor;
//    }
//}
//
//public enum ActionType {
//    SKIP,
//    REVERSE,
//    DRAW_TWO
//}
//
//public enum WildType {
//    WILD,
//    WILD_DRAW_FOUR
//}
//
//public class Deck {
//    private List<Card> cards;
//
//    public Deck() {
//        cards = new ArrayList<>();
//        initializeDeck();
//        shuffle();
//    }
//
//    private void initializeDeck() {
//        // Create and add Uno cards to the deck
//        // ...
//    }
//
//    public void shuffle() {
//        // Shuffle the deck
//        // ...
//    }
//
//    public Card drawCard() {
//        // Draw a card from the deck
//        // Remove it from the deck and return it
//        Card card = cards.remove(cards.size() - 1);
//        return card;
//    }
//
//    public void returnCard(Card card) {
//        // Return a card to the deck
//        // Add it back to the deck
//        cards.add(card);
//    }
//}
//
//public class Player {
//    private String name;
//    private List<Card> hand;
//
//    public Player(String name) {
//        this.name = name;
//        this.hand = new ArrayList<>();
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public List<Card> getHand() {
//        return hand;
//    }
//
//    public void playCard(Card card, Game game) {
//        // Remove the card from the player's hand
//        hand.remove(card);
//        card.playCard(game, this);
//    }
//
//    public void drawCard(Deck deck) {
//        // Draw a card from the deck and add it to the player's hand
//        Card card = deck.drawCard();
//        hand.add(card);
//    }
//
//    public void drawCards(int numCards, Deck deck) {
//        // Draw multiple cards from the deck and add them to the player's hand
//        for (int i = 0; i < numCards; i++) {
//            drawCard(deck);
//        }
//    }
//}
//
//public class Game {
//    private List<Player> players;
//    private Deck deck;
//    private List<Card> discardPile;
//    private String activeColor;
//    private Player activePlayer;
//    private boolean reverseOrder;
//
//    public Game(List<Player> players) {
//        this.players = players;
//        this.deck = new Deck();
//        this.discardPile = new ArrayList<>();
//        this.activeColor = "None";
//        this.activePlayer = players.get(0);
//        this.reverseOrder = false;
//    }
//
//    public void startGame() {
//        // Deal initial cards to players
//        for (Player player : players) {
//            player.drawCards(7, deck);
//        }
//
//        // Choose a random card to start the discard pile
//        Card firstCard = deck.drawCard();
//        discardPile.add(firstCard);
//        activeColor = firstCard.getColor();
//
//        // Game loop
//        while (!isGameFinished()) {
//            // Display game state, active player, etc.
//            displayGameState();
//
//            // Handle player's turn
//            Player currentPlayer = getNextPlayer();
//            handlePlayerTurn(currentPlayer);
//
//            // Check if the game is finished
//            if (currentPlayer.getHand().isEmpty()) {
//                break;
//            }
//
//            advanceTurn();
//        }
//
//        // Game over, determine the winner, display results, etc.
//        Player winner = determineWinner();
//        displayGameResults(winner);
//    }
//
//    public void validateMove(Player player, Card card) {
//        if (!player.equals(activePlayer)) {
//            throw new IllegalStateException("It is not " + player.getName() + "'s turn.");
//        }
//
//        if (!card.getColor().equals(activeColor) && !card.getColor().equals("Wild")) {
//            throw new IllegalStateException("You must play a card of the active color: " + activeColor);
//        }
//
//        if (!player.getHand().contains(card)) {
//            throw new IllegalStateException("You don't have the card in your hand.");
//        }
//
//        // Additional validation based on game rules
//        // ...
//    }
//
//    public void executeCardEffect(Card card) {
//        // Execute the effect of the card played
//        card.playCard(this, activePlayer);
//
//        // Update active color based on the card played
//        if (!card.getColor().equals("Wild")) {
//            activeColor = card.getColor();
//        }
//
//        // Add the played card to the discard pile
//        discardPile.add(card);
//    }
//
//    public Player getNextPlayer() {
//        int currentIndex = players.indexOf(activePlayer);
//        int nextIndex = reverseOrder ? (currentIndex - 1) : (currentIndex + 1);
//
//        if (nextIndex < 0) {
//            nextIndex = players.size() - 1;
//        } else if (nextIndex >= players.size()) {
//            nextIndex = 0;
//        }
//
//        return players.get(nextIndex);
//    }
//
//    public void reverseTurnOrder() {
//        reverseOrder = !reverseOrder;
//    }
//
//    public void skipNextPlayer() {
//        activePlayer = getNextPlayer();
//    }
//
//    public void advanceTurn() {
//        activePlayer = getNextPlayer();
//    }
//
//    public boolean isGameFinished() {
//        for (Player player : players) {
//            if (player.getHand().isEmpty()) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private void handlePlayerTurn(Player player) {
//        boolean validMove = false;
//        Card playedCard = null;
//        Scanner scanner = new Scanner(System.in);
//
//        while (!validMove) {
//            // Display player's hand and other relevant information
//            System.out.println("It's " + player.getName() + "'s turn.");
//            System.out.println("Active color: " + activeColor);
//            System.out.println("Your hand: " + player.getHand());
//            System.out.print("Choose a card to play: ");
//
//            // Prompt the player to choose a card to play
//            String input = scanner.nextLine().trim();
//            int cardIndex = Integer.parseInt(input) - 1;
//
//            if (cardIndex >= 0 && cardIndex < player.getHand().size()) {
//                playedCard = player.getHand().get(cardIndex);
//                try {
//                    validateMove(player, playedCard);
//                    validMove = true;
//                } catch (IllegalStateException e) {
//                    System.out.println("Invalid move: " + e.getMessage());
//                }
//            } else {
//                System.out.println("Invalid card index. Please choose a valid card.");
//            }
//        }
//
//        // Play the card and execute its effect
//        player.playCard(playedCard, this);
//    }
//
//    private Player determineWinner() {
//        Player winner = null;
//        int minCards = Integer.MAX_VALUE;
//
//        for (Player player : players) {
//            int numCards = player.getHand().size();
//            if (numCards < minCards) {
//                minCards = numCards;
//                winner = player;
//            }
//        }
//
//        return winner;
//    }
//
//    private void displayGameState() {
//        System.out.println("---------- GAME STATE ----------");
//        System.out.println("Active Color: " + activeColor);
//        System.out.println("Active Player: " + activePlayer.getName());
//        System.out.println("Discard Pile: " + discardPile);
//        System.out.println("--------------------------------");
//    }
//
//    private void displayGameResults(Player winner) {
//        System.out.println("---------- GAME OVER ----------");
//        System.out.println("Winner: " + winner.getName());
//        System.out.println("--------------------------------");
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        Player player1 = new Player("Alice");
//        Player player2 = new Player("Bob");
//        List<Player> players = new ArrayList<>();
//        players.add(player1);
//        players.add(player2);
//
//        Game game = new Game(players);
//        game.startGame();
//    }
//}
//
