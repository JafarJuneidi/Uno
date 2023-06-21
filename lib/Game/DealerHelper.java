import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class DealerHelper {
    public static final int TOTAL_INITIAL_HAND_CARDS = 7;
    /**
     * Cards are shuffled using the modern version of Fisher-Yates shuffle.
     * Refer https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle#The_modern_algorithm
     *
     * @param cards list will not be modified
     * @return a new shuffled card list
     */
    public static List<Card> shuffle(List<Card> cards) {
        var shuffledCards = new ArrayList<>(cards);
        var rand = new Random();

        for (int current = 0; current < shuffledCards.size() - 1; ++current) {
            // get a random index for remaining positions, i.e. [i, CARDS_SIZE - 1)
            var randomIndex = current + rand.nextInt(cards.size() - current);

            swapCard(shuffledCards, current, randomIndex);
        }

        return shuffledCards;
    }

    public static Stack<Card> shuffle(Stack<Card> drawPile, Card lastPlayedCard) {
        var oldCards = new ArrayList<Card>();
        oldCards.add(lastPlayedCard);

        for (int i = 0; i < drawPile.size(); ++i) {
            oldCards.add(drawPile.pop());
        }

        var shuffledCards = shuffle(oldCards);

        Stack<Card> result = new Stack<>();
        result.addAll(shuffledCards);
        return result;
    }

    private static void swapCard(List<Card> shuffledList, int currentIndex, int randomIndex) {
        var randomCard = shuffledList.get(randomIndex);

        shuffledList.set(randomIndex, shuffledList.get(currentIndex));
        shuffledList.set(currentIndex, randomCard);
    }

    public static List<List<Card>> dealInitialHandCards(Stack<Card> drawPile, int numberOfPlayers) {
        List<List<Card>> listOfCardLists = new ArrayList<>(numberOfPlayers);

        for (int i = 0; i < TOTAL_INITIAL_HAND_CARDS; ++i) {
            for (int p = 0; p < numberOfPlayers; ++p) {
                if (i == 0) {
                    listOfCardLists.add(p, new ArrayList<>());
                }

                listOfCardLists.get(p).add(drawPile.pop());
            }
        }

        return listOfCardLists;
    }
}
