import lt.itakademija.exam.IntegerGenerator;

public abstract class IntegerGeneratorDecorator implements IntegerGenerator {
    protected IntegerGenerator integerGenerator;

    public IntegerGeneratorDecorator(IntegerGenerator integerGenerator) {
        this.integerGenerator = integerGenerator;
    }
}
