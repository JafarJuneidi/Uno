public class ReverseBehavior implements PlayBehavior {
    public void play(Game game) {
        if (game.getNumberOfPlayers() == 2) {
            game.moveIndexToNextPlayer();
            return;
        }
        game.reverseDirection();
    }
}
