public class DrawTwoBehavior implements PlayBehavior {
    public void play(Game game) {
        Player nextPlayer = game.getNextPlayer();
        nextPlayer.addCards(game.drawCards(2));
        game.moveIndexToNextPlayer();
    }
}
