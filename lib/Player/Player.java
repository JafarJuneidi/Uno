import java.util.List;

public interface Player {
    void addCard(Card card);
    String getName();
    void addCards(List<Card> card);
    boolean removeCard(Card card);
    Card getCard(int index);
    List<Card> getAllCards();
    int handSize();
    int getHandPoints();
    int getPlayerPoints();
    void setPlayerPoints(int points);
    void resetHand();
}

