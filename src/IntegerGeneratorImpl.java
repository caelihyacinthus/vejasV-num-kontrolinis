import lt.itakademija.exam.IntegerGenerator;

public class IntegerGeneratorImpl implements IntegerGenerator {
    private int current;
    private final int END;

    public IntegerGeneratorImpl(int from, int to) {
        this.current = from - 1;
        this.END = to;
    }

    @Override
    public Integer getNext() {
        if (current == END) {
            return null;
        }
        return ++current;
    }
}
