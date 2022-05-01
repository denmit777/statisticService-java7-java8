package homework12.task1;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        StatisticService serviceJava7 = new Java7StatisticService();
        StatisticService serviceJava8 = new Java8StatisticService();

        List<Long> numbers = new ArrayList<>(Arrays.asList(1L, 2L, 13L, -4L, 0L, 12L, -4L, 8L, 13L, 18L, 15L, 0L, -12L));
        System.out.println(numbers);

        Set<List<String>> strings = new HashSet<>();
        List<String> str1 = Arrays.asList("aeroplan", "good", "", "wolf", "nose");
        List<String> str2 = Arrays.asList("plan", "fort", "wolf", "new", "stone");
        List<String> str3 = Arrays.asList("sport", "fond", "", "wolf", "fine");
        strings.add(str1);
        strings.add(str2);
        strings.add(str3);
        System.out.println(strings);

        System.out.println(serviceJava7.countEvenNumbers(numbers)); //20
        System.out.println(serviceJava8.countEvenNumbers(numbers)); //20

        System.out.println(serviceJava7.calculateSquareOfDistinctNumbers(numbers)); //[0, 1, 4, 16, 64, 144, 169, 225, 324]
        System.out.println(serviceJava8.calculateSquareOfDistinctNumbers(numbers)); //[0, 1, 4, 16, 64, 144, 169, 225, 324]

        System.out.println(serviceJava7.groupStringsByLastLetter(strings)); //{D=[good, fond], E=[nose, fine, stone], F=[wolf], N=[aeroplan, plan], T=[fort, sport], W=[new]}
        System.out.println(serviceJava8.groupStringsByLastLetter(strings)); //{D=[fond, good], T=[fort, sport], E=[stone, fine, nose], F=[wolf], W=[new], N=[plan, aeroplan]}
    }
}
