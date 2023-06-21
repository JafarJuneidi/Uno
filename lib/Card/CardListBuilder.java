import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CardListBuilder {
    private final List<Color> colors;
    private List<Pair<Integer>> pairsOfNumberCards;
    private int numberOfDrawTwoCards;
    private int numberOfSkipCards;
    private int numberOfReverseCards;
    private int numberOfWildCards;
    private int numberOfWildDrawFourCards;

    public CardListBuilder(List<Color> colors) {
        this.colors = colors;
    }

    public CardListBuilder() {
        this.colors = new ArrayList<Color>(Arrays.asList(new RedColor(), new BlueColor(), new YellowColor(), new GreenColor()));

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
    }

    public CardListBuilder setPairsOfNumberCards(List<Pair<Integer>> pairsOfNumberCards) {
        this.pairsOfNumberCards = pairsOfNumberCards;
        return this;
    }

    public CardListBuilder setNumberOfDrawTwoCards(int numberOfDrawTwoCards) {
        this.numberOfDrawTwoCards = numberOfDrawTwoCards;
        return this;
    }

    public CardListBuilder setNumberOfSkipCards(int numberOfSkipCards) {
        this.numberOfSkipCards = numberOfSkipCards;
        return this;
    }

    public CardListBuilder setNumberOfReverseCards(int numberOfReverseCards) {
        this.numberOfReverseCards = numberOfReverseCards;
        return this;
    }

    public CardListBuilder setNumberOfWildCards(int numberOfWildCards) {
        this.numberOfWildCards = numberOfWildCards;
        return this;
    }

    public CardListBuilder setNumberOfWildDrawFourCards(int numberOfWildDrawFourCards) {
        this.numberOfWildDrawFourCards = numberOfWildDrawFourCards;
        return this;
    }

    public CardList build() {
        List<Card> cards = new ArrayList<>();
        cards.addAll(addNumberCards(pairsOfNumberCards));
        cards.addAll(addDrawTwoCards(numberOfDrawTwoCards));
        cards.addAll(addSkipCards(numberOfSkipCards));
        cards.addAll(addReverseCards(numberOfReverseCards));
        cards.addAll(addWildCards(numberOfWildCards));
        cards.addAll(addWildDrawFourCard(numberOfWildDrawFourCards));

        return new CardList(cards);
    }

    public Stack<Card> buildAsStack() {
        List<Card> cards = new ArrayList<>();
        cards.addAll(addNumberCards(pairsOfNumberCards));
        cards.addAll(addDrawTwoCards(numberOfDrawTwoCards));
        cards.addAll(addSkipCards(numberOfSkipCards));
        cards.addAll(addReverseCards(numberOfReverseCards));
        cards.addAll(addWildCards(numberOfWildCards));
        cards.addAll(addWildDrawFourCard(numberOfWildDrawFourCards));

        Stack<Card> result = new Stack<>();
        result.addAll(cards);
        return result;
    }
    private List<Card> addNumberCards(List<Pair<Integer>> values) {
        List<Card> numberCards = new ArrayList<>();
        for (Color color: colors) {
            for (Pair<Integer> p: values) {
                int number = p.first;
                int quantity = p.second;
                for (int i = 0; i < quantity; ++i) {
                    numberCards.add(new NumberCard(color, number));
                }
            }
        }

        return numberCards;
    }

    private List<Card> addDrawTwoCards(int quantity) {
        List<Card> drawTwoCards = new ArrayList<>();
        for (Color color: colors) {
            for (int i = 0; i < quantity; ++i) {
                drawTwoCards.add(new DrawTwoCard(color));
            }
        }

        return drawTwoCards;
    }

    private List<Card> addSkipCards(int quantity) {
        List<Card> skipCards = new ArrayList<>();
        for (Color color: colors) {
            for (int i = 0; i < quantity; ++i) {
                skipCards.add(new SkipCard(color));
            }
        }

        return skipCards;
    }

    private List<Card> addReverseCards(int quantity) {
        List<Card> reverseCards = new ArrayList<>();
        for (Color color: colors) {
            for (int i = 0; i < quantity; ++i) {
                reverseCards.add(new SkipCard(color));
            }
        }

        return reverseCards;
    }

    private List<Card> addWildCards(int quantity) {
        List<Card> wildCards = new ArrayList<>();
        for (int i = 0; i < quantity; ++i) {
            wildCards.add(new WildCard());
        }
        return wildCards;
    }

    private List<Card> addWildDrawFourCard ( int quantity){
        List<Card> wildDrawFourCards = new ArrayList<>();
        for (int i = 0; i < quantity; ++i) {
            wildDrawFourCards.add(new WildDrawFourCard());
        }

        return wildDrawFourCards;
    }
}