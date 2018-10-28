package com.romanso.java_8_lambdas;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

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
    }
}
