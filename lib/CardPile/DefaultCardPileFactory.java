import java.util.Stack;

public class DefaultCardPileFactory extends CardPileFactory {
    @Override
    protected CardPile createCardPile(Stack<Card> cards) {
        return new DefaultCardPile(cards);
    }
}
