package com.thejava.java8to11;

public class Foo {
    public static void main(String[] args) {
        RunSomething runSomething = () -> System.out.println("Hello");
        runSomething.doIt();
    }
}
