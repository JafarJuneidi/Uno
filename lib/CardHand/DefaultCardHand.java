import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DefaultCardHand implements CardHand {
    private final List<Card> cards;

    public DefaultCardHand(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public int size() {
        return cards.size();
    }

    @Override
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    @Override
    public Card getCard(int index) {
        if (index < 0 || index >= size()) {
            throw new IllegalArgumentException("Index is out of range");
        }

        return cards.get(index);
    }

    @Override
    public void addCard(Card card) {
        cards.add(card);
    }

    @Override
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

    @Override
    public boolean removeCard(Card card) {
        return cards.remove(card);
    }

    @Override
    public void removeCard(int index) {
        cards.remove(index);
    }

    @Override
    public boolean hasCard(Card card) {
        for (Card c: cards) {
            if (card.equals(c)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public List<Card> getAllCards() {
        return cards;
    }

    @Override
    public void reset() {
        this.cards.clear();
    }
}
