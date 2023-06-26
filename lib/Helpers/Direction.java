public enum Direction {
    CLOCKWISE(1),
    COUNTER_CLOCKWISE(-1);

    private final int value;

    private Direction(int value) {
        this.value = value;
    };

    public int getValue() {
        return this.value;
    }

    public Direction reverse() {
        return this == CLOCKWISE ? COUNTER_CLOCKWISE : CLOCKWISE;
    }
}
