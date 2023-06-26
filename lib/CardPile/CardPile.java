import java.util.List;

public interface CardPile {
    void addCard(Card card);
    void addCards(List<Card> card);
    Card removeCard();
    List<Card> removeAllCards();
    Card peekCard();
    void shuffle();
    List<List<Card>> getPlayerHands(int playersCount, int cardsPerPlayerCount);
    int size();
}
