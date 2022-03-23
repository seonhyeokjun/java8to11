package com.thejava.java8to11;

import java.util.function.*;

public class Foo {
    public static void main(String[] args) {
        Function<Integer, Integer> plus10 = (i) -> i + 10;
        Function<Integer, Integer> multiply2 = (i) -> i * 2;

        Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2);
        System.out.println(plus10.andThen(multiply2).apply(2));

        Consumer<Integer> printT = System.out::println;
        printT.accept(10);

        Supplier<Integer> get10 = () -> 10;
        System.out.println("get10 = " + get10);

        Predicate<String> startsWith = (s) -> s.startsWith("heyeok");
        Predicate<Integer> isEven = (i) -> i%2 == 0;

        UnaryOperator<Integer> unaryOperator = (i) -> i + 10; // Function<Integer, Integer> plus10 = (i) -> i + 10;
    }

    private void run() {
        int baseNumber = 10;

        // 로컬 클래스
        class LocalClass{
            void printBaseNumber() {
                int baseNumber = 11;
                System.out.println(baseNumber);
            }
        }

        // 익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) {
                System.out.println(baseNumber);
            }
        };

        // 람다
        IntConsumer printInt = (i) -> {
            System.out.println(i + baseNumber);
        };

        printInt.accept(10);
    }
}
