package com.thejava.java8to11;

public class DefaultBar implements Bar{
    String name;

    public DefaultBar(String name) {
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println(name);
    }

    @Override
    public String getName() {
        return name;
    }
}
