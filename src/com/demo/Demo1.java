package com.demo;

import java.util.Arrays;

public class Demo1 {
    public static void main(String[] args) {
        Arrays.asList("Foo", "Bar").stream()
                .filter(s -> s.equalsIgnoreCase("foo"))
                .map(s -> s.toUpperCase())
                .forEach(System.out::println);

        Arrays.stream(new String[] {"s1", "s2", "s3"})
                .map(s -> Arrays.asList(s))
                .flatMap(l -> l.stream())
                .forEach(System.out::println);
    }
}
