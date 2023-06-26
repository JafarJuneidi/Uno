import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public abstract class CardPileFactory {
    protected  Color[] colors;
    protected List<Pair<Integer>> pairsOfNumberCards;
    protected int numberOfDrawTwoCards;
    protected int numberOfSkipCards;
    protected int numberOfReverseCards;
    protected int numberOfWildCards;
    protected int numberOfWildDrawFourCards;
    protected int actionCardsPointValue;
    protected int wildCardsPointValue;

    {
        this.colors = new Color[]{ Color.Red, Color.Yellow, Color.Blue, Color.Green };

        this.pairsOfNumberCards = new ArrayList<>();
        this.pairsOfNumberCards.add(new Pair<>(0, 1));
        for (int i = 1; i < 10; ++i) {
            this.pairsOfNumberCards.add(new Pair<>(i, 2));
        }

        this.numberOfDrawTwoCards = 2;
        this.numberOfSkipCards = 2;
        this.numberOfReverseCards = 2;
        this.numberOfWildCards = 4;
        this.numberOfWildDrawFourCards = 4;

        this.actionCardsPointValue = 20;
        this.wildCardsPointValue = 50;
    }

    // This needs to be more extendable, what If I added new cards and new cards adders, there must be a better way to call them.
    public CardPile create() {
        Stack<Card> cards = new Stack<>();
        cards.addAll(addNumberCards(pairsOfNumberCards));
        cards.addAll(addDrawTwoCards(numberOfDrawTwoCards));
        cards.addAll(addSkipCards(numberOfSkipCards));
        cards.addAll(addReverseCards(numberOfReverseCards));
        cards.addAll(addWildCards(numberOfWildCards));
        cards.addAll(addWildDrawFourCard(numberOfWildDrawFourCards));

        return createCardPile(cards);
    }
    protected abstract CardPile createCardPile(Stack<Card> cards);

    private List<Card> addNumberCards(List<Pair<Integer>> values) {
        List<Card> numberCards = new ArrayList<>();
        for (Color color: colors) {
            for (Pair<Integer> p: values) {
                int number = p.first;
                int quantity = p.second;
                for (int i = 0; i < quantity; ++i) {
                    numberCards.add(new Card(color, new NoPlayBehavior(), number, number));
                }
            }
        }

        return numberCards;
    }

    private List<Card> addDrawTwoCards(int quantity) {
        List<Card> drawTwoCards = new ArrayList<>();
        for (Color color: colors) {
            for (int i = 0; i < quantity; ++i) {
                drawTwoCards.add(new Card(color, new DrawTwoBehavior(), null, actionCardsPointValue));
            }
        }

        return drawTwoCards;
    }

    private List<Card> addSkipCards(int quantity) {
        List<Card> skipCards = new ArrayList<>();
        for (Color color: colors) {
            for (int i = 0; i < quantity; ++i) {
                skipCards.add(new Card(color, new SkipBehavior(), null, actionCardsPointValue));
            }
        }

        return skipCards;
    }

    private List<Card> addReverseCards(int quantity) {
        List<Card> reverseCards = new ArrayList<>();
        for (Color color: colors) {
            for (int i = 0; i < quantity; ++i) {
                reverseCards.add(new Card(color, new ReverseBehavior(), null, actionCardsPointValue));
            }
        }

        return reverseCards;
    }

    private List<Card> addWildCards(int quantity) {
        List<Card> wildCards = new ArrayList<>();
        for (int i = 0; i < quantity; ++i) {
            wildCards.add(new Card(Color.NoColor, new WildBehavior(), null, wildCardsPointValue));
        }
        return wildCards;
    }

    private List<Card> addWildDrawFourCard ( int quantity){
        List<Card> wildDrawFourCards = new ArrayList<>();
        for (int i = 0; i < quantity; ++i) {
            wildDrawFourCards.add(new Card(Color.NoColor, new WildDrawFourBehavior(), null, wildCardsPointValue));
        }

        return wildDrawFourCards;
    }
}