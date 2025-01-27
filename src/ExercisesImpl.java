import lt.itakademija.exam.Exercises;
import lt.itakademija.exam.IntegerGenerator;
import lt.itakademija.exam.NumberFilter;

import java.util.*;
import java.util.stream.Stream;

public class ExercisesImpl implements Exercises {
    @Override
    public Integer findSmallest(List<Integer> list) {
        return list.stream().min(Integer::compareTo).orElse(null);
    }

    @Override
    public Integer findLargest(List<Integer> list) {
        return list.stream().max(Integer::compareTo).orElse(null);
    }

    @Override
    public boolean isEqual(Object o1, Object o2) {
        return Objects.equals(o1, o2);
    }

    @Override
    public boolean isSameObject(Object o1, Object o2) {
        return o1 == o2;
    }

    @Override
    public List<Integer> consume(Iterator<Integer> iterator) {
        List<Integer> numbers = new ArrayList<>();
        while (iterator.hasNext()) {
            numbers.add(iterator.next());
        }
        return numbers;
    }

    @Override
    public int computeSumOfNumbers(int number) {
        int sum = 0;
        for (int i = 0; i <= number; i++) {
            sum += i;
        }
        return sum;
    }

    @Override
    public int computeSumOfNumbers(int number, NumberFilter numberFilter) {
        int sum = 0;
        for (int i = 0; i <= number; i++) {
            if (numberFilter.accept(i)) {
                sum += i;
            }
        }
        return sum;
    }

    @Override
    public List<Integer> computeNumbersUpTo(int number) {
        return Stream.iterate(1, i -> i < number, i -> i += 1).toList();
    }

    @Override
    public Map<Integer, Integer> countOccurrences(List<Integer> list) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int n : list) {
            if (occurrences.containsKey(n)) {
                occurrences.replace(n, occurrences.get(n) + 1);
            } else {
                occurrences.put(n, 1);
            }
        }
        return occurrences;
    }

    @Override
    public IntegerGenerator createIntegerGenerator(int from, int to) {
        return new IntegerGeneratorImpl(from, to);
    }

    @Override
    public IntegerGenerator createFilteredIntegerGenerator(IntegerGenerator integerGenerator, NumberFilter numberFilter) {
        return new FilteredIntegerGenerator(integerGenerator, numberFilter);
    }
}
