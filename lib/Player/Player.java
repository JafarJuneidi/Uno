import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Player {
    private final String name;
    private final List<Card> cardList;

    public Player(String name,  List<Card> cardList){
        this.name = name;
        this.cardList = cardList;
    }

    public void addCard(Card newCard){
        cardList.add(newCard);
    }

    public boolean removeCard(Card card) {
        return cardList.remove(card);
    }

    public boolean hasCard(Card card) {
        for (Card c: cardList) {
            if (card.equals(c)) {
                return true;
            }
        }

        return false;
    }

    public int size() {
        return cardList.size();
    }

    public Card pickCard(Card card) {
        for (int i = 0; i < cardList.size(); ++i) {
            System.out.println(i + ": " + card.toString());
        }

        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        System.out.println("Your Index is: " + index);

        return cardList.get(index);
    }
}