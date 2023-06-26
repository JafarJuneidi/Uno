import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class DefaultCardPile implements CardPile {
    private final Stack<Card> pile;

    public DefaultCardPile(Stack<Card> pile) {
        this.pile = pile;
    }

    @Override
    public void addCard(Card card) {
        pile.push(card);
    }

    @Override
    public void addCards(List<Card> cards) {
        pile.addAll(cards);
    }

    @Override
    public Card removeCard() {
        return pile.pop();
    }

    @Override
    public Card peekCard() {
        return pile.peek();
    }

    public int size() {
        return pile.size();
    }

    public void shuffle() {
        Collections.shuffle(pile);
    }

    @Override
    public List<List<Card>> getPlayerHands(int playersCount, int cardsPerPlayerCount) {
        List<List<Card>> playerHands = new ArrayList<>();

        if (playersCount * cardsPerPlayerCount > size()) {
            throw new IllegalArgumentException("Not enough cards in pile");
        }

        for (int player = 0; player < playersCount; player++) {
            List<Card> hand = new ArrayList<>();
            for (int cardCount = 0; cardCount < cardsPerPlayerCount; cardCount++) {
                hand.add(removeCard());
            }
            playerHands.add(hand);
        }

        return playerHands;
    }
}