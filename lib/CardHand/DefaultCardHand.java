import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DefaultCardHand implements CardHand {
    private final List<Card> cards;

    public DefaultCardHand(List<Card> cards) {
        this.cards = cards;
    }

    public int size() {
        return cards.size();
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public Card getCard(int index) {
        if (index < 0 || index >= size()) {
            throw new IllegalArgumentException("Index is out of range");
        }

        return cards.get(index);
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void addCards(List<Card> cards) {
        this.cards.addAll(cards);
    }

    @Override
    public int calculateCardPoints() {
        int points = 0;
        for (Card card: cards) {
            points += card.getPoints();
        }
        return points;
    }

    public boolean removeCard(Card card) {
        return cards.remove(card);
    }

    public void removeCard(int index) {
        cards.remove(index);
    }

    public boolean hasCard(Card card) {
        for (Card c: cards) {
            if (card.equals(c)) {
                return true;
            }
        }

        return false;
    }

    public List<Card> getAllCards() {
        return cards;
    }

    public void reset() {
        this.cards.clear();
    }
}
