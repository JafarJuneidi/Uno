public class WildDrawFourBehavior implements PlayBehavior {
    private final PlayBehavior wildBehavior = new WildBehavior();
    public void play(Game game) {
        wildBehavior.play(game);

        Player nextPlayer = game.getNextPlayer();
        nextPlayer.addCards(game.drawCards(4));
        game.moveIndexToNextPlayer();
    }
}
