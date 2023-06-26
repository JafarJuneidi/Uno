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
}
