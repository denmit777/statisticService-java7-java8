package homework12.task1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class Java7StatisticServiceTest {

    private Java7StatisticService serviceJava7;

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
        serviceJava7 = new Java7StatisticService();

        numbersList = new ArrayList<>(Arrays.asList(1L, 2L, 13L, -4L, 0L, 12L, -4L, 8L, 13L, 18L, 15L, 0L, -12L));
        sumOfEvenNumbers = 20;
        squareOfDistinctNumbersList = new ArrayList<>(Arrays.asList(0L, 1L, 4L, 16L, 64L, 144L, 169L, 225L, 324L));

        listOfStringsSet = new HashSet<>();
        stringList1 = Arrays.asList("aeroplan", "good", "", "wolf", "nose");
        stringList2 = Arrays.asList("plan", "fort", "wolf", "new", "stone");
        stringList3 = Arrays.asList("sport", "fond", "", "wolf", "fine");
        listOfStringsSet.add(stringList1);
        listOfStringsSet.add(stringList2);
        listOfStringsSet.add(stringList3);

        stringsByLastLetterDList = Arrays.asList("good", "fond");
        stringsByLastLetterEList = Arrays.asList("nose", "fine", "stone");
        stringsByLastLetterFList = Arrays.asList("wolf");
        stringsByLastLetterNList = Arrays.asList("aeroplan", "plan");
        stringsByLastLetterTList = Arrays.asList("fort", "sport");
        stringsByLastLetterWList = Arrays.asList("new");

        stringsByLastLetterMap = new TreeMap<>();
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

        long actual = serviceJava7.countEvenNumbers(numbersList);

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCountEvenNumbersNegative_IfListIsNull() {
        serviceJava7.countEvenNumbers(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCountEvenNumbersNegative_IfListContainsNull() {
        numbersList = new ArrayList<>(Arrays.asList(1L, null, 13L, -4L, 0L));

        serviceJava7.countEvenNumbers(numbersList);
    }

    @Test
    public void testCalculateSquareOfDistinctNumbers() {
        List<Long> expected = squareOfDistinctNumbersList;

        List<Long> actual = serviceJava7.calculateSquareOfDistinctNumbers(numbersList);

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateSquareOfDistinctNumbersNegative_IfListIsNull() {
        serviceJava7.calculateSquareOfDistinctNumbers(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateSquareOfDistinctNumbersNegative_IfListContainsNull() {
        numbersList = new ArrayList<>(Arrays.asList(1L, null, 13L, -4L, 0L));

        serviceJava7.calculateSquareOfDistinctNumbers(numbersList);
    }

    @Test
    public void testGroupStringsByLastLetter() {
        Map<Character, List<String>> expected = stringsByLastLetterMap;

        Map<Character, List<String>> actual = serviceJava7.groupStringsByLastLetter(listOfStringsSet);

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGroupStringsByLastLetterNegative_IfSetIsNull() {
        serviceJava7.groupStringsByLastLetter(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGroupStringsByLastLetterNegative_IfSetContainsNull() {
        listOfStringsSet = new HashSet<>();
        listOfStringsSet.add(stringList1);
        listOfStringsSet.add(null);

        serviceJava7.groupStringsByLastLetter(listOfStringsSet);
    }
}