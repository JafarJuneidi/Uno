import java.util.List;

public interface CardPile {
    void addCard(Card card);
    void addCards(List<Card> card);
    Card removeCard();
    Card peekCard();
    void shuffle();
    List<List<Card>> getPlayerHands(int playersCount, int cardsPerPlayerCount);
}
