package com.romanso.java_8_lambdas;

import com.romanso.java_8_lambdas.all.Track;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

//        failure example (name is not final or effectively final)
//        String name = getUserName();
//        name = formatUserName(name);
//        button.addActionListener(event -> System.out.println("hi " + name));

    public final static ThreadLocal<DateFormatter> FORMATTER = ThreadLocal.withInitial(() ->
        new DateFormatter(new SimpleDateFormat("dd-MMM-yyyy"))
    );

    public static void main(String[] args) {
        Predicate<Integer> atLeast5 = x -> x > 5;
        BinaryOperator<Long> addLongs = (x, y) -> x + y;

        List<String> collected = Stream.of("a", "b", "c").collect(Collectors.toList());
        System.out.println(collected);

        reduce();
    }

    private static void reduce() {
        int count = Stream.of(1, 2, 3, 4)
                .reduce(1, (acc, obj) -> acc + obj);
        System.out.println(count);
    }

    private static void max() {
        List<Track> tracks = asList(new Track("Until It Sleeps", 270),
                new Track("For Whom The Bell Tolls", 310),
                new Track("One", 448),
                new Track("Creeping Death", 396),
                new Track("Wherever I May Roam", 404),
                new Track("Enter Sandman", 332),
                new Track("Master Of Puppets", 516),
                new Track("Disposable Heroes", 497));
        Track longestTrack = tracks.stream()
                .max(Comparator.comparing(Track::getLength))
                .get();
        System.out.println(longestTrack);
    }

    private static void flatMap() {
        List<Integer> together = Stream.of(asList(1, 2), asList(3, 4))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(together);
    }

    private static void filter() {
        List<String> beginsWithNumbers = Stream.of("a", "1abc", "abc1")
                .filter(Test::startsWithDigit)
                .collect(Collectors.toList());
        System.out.println(beginsWithNumbers);
    }

    private static void map() {
        List<String> uppers = Stream.of("a", "b", "hello")
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(uppers);
    }

    private static boolean startsWithDigit(String s) {
        return s.charAt(0) > '0' && s.charAt(0) < '9';
    }

    private static <T> List<T> asList(T... objects) {
        return Stream.of(objects).collect(Collectors.toList());
    }
}
