import lt.itakademija.exam.IntegerGenerator;
import lt.itakademija.exam.NumberFilter;

public class FilteredIntegerGenerator extends IntegerGeneratorDecorator{
    private NumberFilter numberFilter;

    public FilteredIntegerGenerator(IntegerGenerator integerGenerator, NumberFilter numberFilter){
        super(integerGenerator);
        this.numberFilter = numberFilter;
    }

    @Override
    public Integer getNext() {
        Integer next = integerGenerator.getNext();
        while (next != null){
            if (numberFilter.accept(next)) return next;
            next = integerGenerator.getNext();
        }
        return null;
    }
}
