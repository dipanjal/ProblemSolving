package com.dipanjal.ocp.practiece.chapter11;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author dipanjal
 * @since 4/21/2021
 */

public class StreamPractice {

    private static void intStreamTest(){
/*        List<Integer> sortedNumbers = IntStream.of(2,7,4,8,7)
                .filter(n -> n > 5)
                .collect()*/
        int sum = IntStream.range(5, 10).sum();
        int sum2 = IntStream
                .generate(() -> (int) (Math.random()*10))
                .takeWhile(n -> n!=3)
                .sum();

/*        System.out.println(sum);
        System.out.println(sum2);*/

        Predicate<String> filterPredicate = name -> name.length() < 6;

        UnaryOperator<String> trimString = String::trim;
        UnaryOperator<String> uppercaseString = String::toUpperCase;

        Function<String, String> compositeFunction = trimString.andThen(uppercaseString);

        List<String> names = List.of("dip", "rahul", "shamar", "ramit", "prottay")
                .stream()
                .filter(filterPredicate)
                .map(trimString.andThen(uppercaseString))
                .collect(Collectors.toList());
        names.forEach(System.out::println);

        System.out.println(
                names
                .stream()
                .mapToInt(String::length)
                .sum()
        );

        Optional<String> joinedNameOptional = names
                .stream()
                .reduce((s1, s2) -> s1.concat("-").concat(s2));
        joinedNameOptional.ifPresent(System.out::println);

        String nameJoined = names
                .stream()
                .reduce("",(s1, s2) -> s1.concat("-").concat(s2));
        System.out.println(nameJoined);

    }

    public static void main(String[] args) {
        intStreamTest();
    }
}
