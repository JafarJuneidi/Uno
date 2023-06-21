public class ColorCard implements Card {
    private final Color color;

    public ColorCard(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public String getColorString() {
        return color.value;
    }
}