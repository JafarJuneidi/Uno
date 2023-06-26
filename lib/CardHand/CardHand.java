import java.util.List;

public interface CardHand {
    void addCard(Card card);
    void addCards(List<Card> cards);
    int calculateCardPoints();
    Card getCard(int index);
    List<Card> getAllCards();
    int size();
    boolean isEmpty();
    boolean removeCard(Card card);
    public void removeCard(int index);
    boolean hasCard(Card card);
    void reset();
}
