import java.util.List;

public class DefaultPlayer implements Player {
    private final String name;
    private final CardHand hand;
    private int points;

    public DefaultPlayer(String name, CardHand hand){
        this.name = name;
        this.hand = hand;
        this.points = 0;
    }

    @Override
    public void addCard(Card newCard){
        hand.addCard(newCard);
    }

    @Override
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

    @Override
    public int handSize() {
        return hand.size();
    }

    @Override
    public Card getCard(int index) {
        return hand.getCard(index);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Card> getAllCards() {
        return hand.getAllCards();
    }

    @Override
    public void resetHand() {
        hand.reset();
    }

    @Override
    public void addCards(List<Card> cards) {
        hand.addCards(cards);
    }

    @Override
    public int getHandPoints() {
        return hand.calculateCardPoints();
    }

    @Override
    public int getPlayerPoints() {
        return this.points;
    }

    @Override
    public void setPlayerPoints(int points) {
        this.points = points;
    }
}