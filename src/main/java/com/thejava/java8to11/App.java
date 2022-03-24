package com.thejava.java8to11;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

        List<List<OnlineClass>> keesunEvents = new ArrayList<>();
        keesunEvents.add(springClasses);
        keesunEvents.add(javaClasses);

        System.out.println("spring 으로 시작하는 수업");
        springClasses.stream().filter(oc -> oc.getTitle().startsWith("spring"))
                        .forEach(oc -> System.out.println(oc.getId()));

        System.out.println("close 되지 않은 수업");
        springClasses.stream().filter(Predicate.not(OnlineClass::isClosed))
                .forEach(oc -> System.out.println(oc.getId()));

        System.out.println("수업 이름만 모아서 스트림 만들기");
        springClasses.stream().map(OnlineClass::getTitle).forEach(System.out::println);



        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
        keesunEvents.stream().flatMap(Collection::stream).forEach(oc -> System.out.println(oc.getId()));

        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");
        Stream.iterate(10, i -> i + 1).skip(10).limit(10).forEach(System.out::println);

        System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
        boolean test = javaClasses.stream().anyMatch(oc -> oc.getTitle().contains("Test"));
        System.out.println("test = " + test);

        System.out.println("스프링 수업 중에 제목에 spring이 들어간 제목만 모아서 List로 만들기");
        List<String> spring = springClasses.stream().map(OnlineClass::getTitle)
                .filter(title -> title.contains("spring")).collect(Collectors.toList());
        spring.forEach(System.out::println);

        Optional<OnlineClass> spring1 = springClasses.stream().filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();
        boolean present = spring1.isPresent();
        System.out.println(present);

        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        OnlineClass onlineClass = optional.orElseGet(App::createNewClasses);

    }

    private static OnlineClass createNewClasses() {
        System.out.println("creating new online class");
        return new OnlineClass(10, "New class", false);
    }
}
