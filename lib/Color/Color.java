import java.util.Objects;

public final class Color {
    public String value;
    public static Color Green = new Color("Green");
    public static Color Blue = new Color("Blue");
    public static Color Red = new Color("Red");
    public static Color Yellow = new Color("Yellow");
    public static Color NoColor = new Color("NoColor");
    public Color(String color) {
        this.value = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Color color = (Color) o;
        return Objects.equals(value, color.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
