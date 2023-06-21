public class CompleteCardComparer implements CardComparer{
    @Override
    public boolean compare(SkipCard skipCard, ReverseCard reverseCard) {
        return skipCard.getColor().value.equals(reverseCard.getColor().value);
    }
}
