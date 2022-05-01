package homework12.task1;

import java.util.*;

public class Java7StatisticService implements StatisticService {

    @Override
    public long countEvenNumbers(List<Long> numbers) {
        if (isNull(numbers)) {
            throw new IllegalArgumentException("Numbers should not be null");
        }
        long sum = 0;
        for (Long number : numbers) {
            if (number % 2 == 0) {
                sum += number;
            }
        }
        return sum;
    }

    @Override
    public List<Long> calculateSquareOfDistinctNumbers(List<Long> numbers) {
        if (isNull(numbers)) {
            throw new IllegalArgumentException("Numbers should not be null");
        }
        Set<Long> distinctNum = new TreeSet<>();
        for (Long number : numbers) {
            distinctNum.add((long)Math.pow(number, 2));
        }
        return new ArrayList<>(distinctNum);
    }

    @Override
    public Map<Character, List<String>> groupStringsByLastLetter(Set<List<String>> strings) {
        if (isNull(strings)) {
            throw new IllegalArgumentException("Strings should not be null");
        }
        Set<String> mainSet = new HashSet<>();
        for (List<String> string : strings) {
            mainSet.addAll(string);
        }
        Map<Character, List<String>> map = new TreeMap<>();
        for (String string : mainSet) {
            if (!string.isEmpty()) {
                Character key = string.toUpperCase().charAt(string.length() - 1);
                List<String> list = map.get(key);
                if (list == null) {
                    list = new ArrayList<>();
                    map.put(key, list);
                }
                list.add(string);
            }
        }
        return map;
    }

    private boolean isNull(Collection collection) {
        return collection == null || collection.contains(null);
    }
}
