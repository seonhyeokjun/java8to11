package com.thejava.java8to11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {
    public static void main(String[] args) {
        Greeting greeting = new Greeting();
        UnaryOperator<String> hi = Greeting::hi;
        UnaryOperator<String> hi2 = greeting::hello;

        Supplier<Greeting> newGreeting = Greeting::new;

        Function<String, Greeting> greetingFunction = Greeting::new;

        String[] names = {"c", "a", "b"};
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));

        DefaultBar defaultBar = new DefaultBar("hyeokjun");
        defaultBar.printName();
        defaultBar.printNameUpperCase();

        Bar.printAnything();

        List<String> name = new ArrayList<>();
        name.add("a");
        name.add("b");
        name.add("c");
        name.add("d");

        Spliterator<String> spliterator = name.spliterator();
        Spliterator<String> stringSpliterator = spliterator.trySplit();
        while (spliterator.tryAdvance(System.out::println));
        System.out.println("================");
        while (stringSpliterator.tryAdvance(System.out::println));
    }
}
