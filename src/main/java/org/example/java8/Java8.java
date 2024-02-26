package org.example.java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Java8 {
    public static void main(String[] args) {
        List<List<String>> stringList = List.of(List.of("prajjwal"), List.of("pandey"));

        List<String> collect = stringList.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(collect);


        String s = "i am working from home";
        int n = 1;
        String first = Arrays.stream(s.split(" ")).sorted((n1, n2) -> n1.length() - n2.length()).skip(n - 1).findFirst().orElse("");
        System.out.println(first);


        List<Integer> integers = List.of(1, 4, 7, 9, 3, 1, 3);
        System.out.println(integers.stream().mapToInt(in -> in).average().orElse(2.0));
    }
}
