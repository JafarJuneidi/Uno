import java.util.Objects;

public class Card {
    private final Color color;
    private final PlayBehavior playBehavior;
    private final Integer value;
    private final Integer points;

    public Card(Color color, PlayBehavior playBehavior, Integer value, Integer points) {
       this.color = Objects.requireNonNull(color, "Color cannot be null. use NoColor instead");
       this.playBehavior = Objects.requireNonNull(playBehavior, "PlayBehavior cannot be null. Use NoPlayBehavior instead");
       this.value = value;
       this.points = points;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(color.value).append(" ");
        stringBuilder.append(playBehavior.getClass().getName()).append(" ");
        if (value != null) stringBuilder.append(value);

        return stringBuilder.toString();
    }

    public void play(Game game) {
        this.playBehavior.play(game);
    }

    public int getPoints() {
        return this.points;
    }

    public boolean matches(Card card) {
        return this.color.equals(card.color) ||
                (hasPlayBehavior() && card.hasPlayBehavior() && (this.playBehavior.getClass() == card.playBehavior.getClass())) ||
                (this.value != null && card.value != null && this.value.equals(card.value)) ||
                card.playBehavior instanceof WildBehavior ||
                card.playBehavior instanceof WildDrawFourBehavior;
    }

    public boolean hasPlayBehavior() {
        return !(this.playBehavior instanceof NoPlayBehavior);
    }
}