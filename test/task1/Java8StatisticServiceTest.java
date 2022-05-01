package homework12.task1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class Java8StatisticServiceTest {

    private Java8StatisticService serviceJava8;

    private List<Long> numbersList;
    private Set<List<String>> listOfStringsSet;
    private List<String> stringList1;
    private List<String> stringList2;
    private List<String> stringList3;
    private long sumOfEvenNumbers;
    private List<Long> squareOfDistinctNumbersList;
    private List<String> stringsByLastLetterDList;
    private List<String> stringsByLastLetterEList;
    private List<String> stringsByLastLetterFList;
    private List<String> stringsByLastLetterNList;
    private List<String> stringsByLastLetterTList;
    private List<String> stringsByLastLetterWList;
    private Map<Character, List<String>> stringsByLastLetterMap;

    @Before
    public void setUp() throws Exception {
        serviceJava8 = new Java8StatisticService();

        numbersList = new ArrayList<>(Arrays.asList(1L, 2L, 13L, 5L, 0L, 12L, -4L, -12L));
        sumOfEvenNumbers = -2;
        squareOfDistinctNumbersList = new ArrayList<>(Arrays.asList(0L, 1L, 4L, 16L, 25L, 144L, 169L));

        listOfStringsSet = new HashSet<>();
        stringList1 = Arrays.asList("aeroplan", "good", "", "wolf", "nose");
        stringList2 = Arrays.asList("plan", "fort", "wolf", "new", "stone");
        stringList3 = Arrays.asList("sport", "fond", "", "wolf", "");
        listOfStringsSet.add(stringList1);
        listOfStringsSet.add(stringList2);
        listOfStringsSet.add(stringList3);

        stringsByLastLetterDList = Arrays.asList("fond", "good");
        stringsByLastLetterEList = Arrays.asList("stone", "nose");
        stringsByLastLetterFList = Arrays.asList("wolf");
        stringsByLastLetterNList = Arrays.asList("plan", "aeroplan");
        stringsByLastLetterTList = Arrays.asList("sport", "fort");
        stringsByLastLetterWList = Arrays.asList("new");

        stringsByLastLetterMap = new HashMap<>();
        stringsByLastLetterMap.put('D', stringsByLastLetterDList);
        stringsByLastLetterMap.put('E', stringsByLastLetterEList);
        stringsByLastLetterMap.put('F', stringsByLastLetterFList);
        stringsByLastLetterMap.put('N', stringsByLastLetterNList);
        stringsByLastLetterMap.put('T', stringsByLastLetterTList);
        stringsByLastLetterMap.put('W', stringsByLastLetterWList);
    }

    @Test
    public void testCountEvenNumbers() {
        long expected = sumOfEvenNumbers;

        long actual = serviceJava8.countEvenNumbers(numbersList);

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCountEvenNumbersNegative_IfListIsNull() {
        serviceJava8.countEvenNumbers(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCountEvenNumbersNegative_IfListContainsNull() {
        numbersList = new ArrayList<>(Arrays.asList(1L, null, 13L, -4L, 0L));

        serviceJava8.countEvenNumbers(numbersList);
    }

    @Test
    public void testCalculateSquareOfDistinctNumbers() {
        List<Long> expected = squareOfDistinctNumbersList;

        List<Long> actual = serviceJava8.calculateSquareOfDistinctNumbers(numbersList);

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateSquareOfDistinctNumbersNegative_IfListIsNull() {
        serviceJava8.calculateSquareOfDistinctNumbers(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateSquareOfDistinctNumbersNegative_IfListContainsNull() {
        numbersList = new ArrayList<>(Arrays.asList(1L, null, 13L, -4L, 0L));

        serviceJava8.calculateSquareOfDistinctNumbers(numbersList);
    }

    @Test
    public void testGroupStringsByLastLetter() {
        Map<Character, List<String>> expected = stringsByLastLetterMap;

        Map<Character, List<String>> actual = serviceJava8.groupStringsByLastLetter(listOfStringsSet);

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGroupStringsByLastLetterNegative_IfSetIsNull() {
        serviceJava8.groupStringsByLastLetter(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGroupStringsByLastLetterNegative_IfSetContainsNull() {
        listOfStringsSet = new HashSet<>();
        listOfStringsSet.add(stringList1);
        listOfStringsSet.add(null);

        serviceJava8.groupStringsByLastLetter(listOfStringsSet);
    }
}