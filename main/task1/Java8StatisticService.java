package homework12.task1;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Java8StatisticService implements StatisticService {

    @Override
    public long countEvenNumbers(List<Long> numbers) {
        if (isNull(numbers)) {
            throw new IllegalArgumentException("Numbers should not be null");
        }
        return numbers
                .stream()
                .filter(p -> p % 2 == 0)
                .reduce(Long::sum)
                .orElse(0L);
    }

    @Override
    public List<Long> calculateSquareOfDistinctNumbers(List<Long> numbers) {
        if (isNull(numbers)) {
            throw new IllegalArgumentException("Numbers should not be null");
        }
        return numbers
                .stream()
                .map(s -> s * s)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public Map<Character, List<String>> groupStringsByLastLetter(Set<List<String>> strings) {
        if (isNull(strings)) {
            throw new IllegalArgumentException("Numbers should not be null");
        }
        return strings.stream()
                .flatMap(Collection::stream)
                .distinct()
                .filter(s -> !s.isEmpty())
                .collect(Collectors.groupingBy(this::getStringLastLetter));
    }

    private boolean isNull(Collection collection) {
        return collection == null || collection.contains(null);
    }

    private char getStringLastLetter(String s) {
        return s.toUpperCase().charAt(s.length() - 1);
    }
}
