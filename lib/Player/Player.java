import java.util.List;

public class Player {
    private final String name;
    private final CardHand hand;

    private int points;

    public Player(String name,  CardHand hand){
        this.name = name;
        this.hand = hand;
        this.points = 0;
    }

    public void addCard(Card newCard){
        hand.addCard(newCard);
    }

    public boolean removeCard(Card card) {
        return hand.removeCard(card);
    }

    public boolean removeCard(int index) {
        if (index >= 0 && index < hand.size()) {
            hand.removeCard(index);
            return true;
        }
        return false;
    }
    public boolean hasCard(Card card) {
        return hand.hasCard(card);
    }

    public int handSize() {
        return hand.size();
    }

    public Card pickCard(int index) {
        return hand.getCard(index);
    }

    public String getName() {
        return name;
    }

    public List<Card> getAllCards() {
        return hand.getAllCards();
    }

    public void resetHand() {
        hand.reset();
    }

    public void addCards(List<Card> cards) {
        hand.addCards(cards);
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getHandPoints() {
        return hand.calculateCardPoints();
    }
}