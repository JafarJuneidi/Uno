import java.util.List;

public class CardList {
    private final List<Card> cards;

    public CardList(List<Card> cards) {
        this.cards = cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public Card removeCard(Card card) {
        cards.remove(card);
        return card;
    }

    public boolean includes(Card card) {
        for (Card c: cards) {
            if (card.equals(c)) {
                return true;
            }
        }

        return false;
    }

    public int size() {
        return cards.size();
    }
}
