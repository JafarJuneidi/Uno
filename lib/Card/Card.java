import java.util.Objects;

public class Card {
    private final Color color;
    private final PlayBehavior playBehavior;
    private final Integer value;
    private int points;

    public Card(Color color, PlayBehavior playBehavior, Integer value, int points) {
       this.color = Objects.requireNonNull(color, "Color cannot be null. use NoColor instead");
       this.playBehavior = Objects.requireNonNull(playBehavior, "PlayBehavior cannot be null. Use NoPlayBehavior instead");
       this.value = value;
       this.points = points;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(color.value).append(" ");
        stringBuilder.append(playBehavior).append(" ");
        if (value != null) stringBuilder.append(value);

        return stringBuilder.toString();
    }

    public void play(Game game) {
        this.playBehavior.play(game);
    }

    public int getPoints() {
        return this.points;
    }
}