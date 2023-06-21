import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Stack<Card> deck = new CardListBuilder().buildAsStack();
        Player[] players = new Player[];
        Game game = new Game(deck, );
    }
}