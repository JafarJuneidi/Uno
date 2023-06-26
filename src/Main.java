import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Player[] players = new Player[3];
        players[0] = new DefaultPlayer("Jafar", new DefaultCardHand(new ArrayList<>()));
        players[1] = new DefaultPlayer("Ameer", new DefaultCardHand(new ArrayList<>()));
        players[2] = new DefaultPlayer("Adam", new DefaultCardHand(new ArrayList<>()));
        Game game = new DefaultGame(new DefaultCardPileFactory().create(), players, 1, 1);
        game.play();
    }
}