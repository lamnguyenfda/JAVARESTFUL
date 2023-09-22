package com.demolambda.main;

import java.util.Arrays;
import java.util.List;

public class DemoStreamApi {
    public static void main(String[] args) {
       n();
    }

     static void n() {
        List<Integer> ls = Arrays.asList(1, 4, 2, 4, 454, 54, 2, 2);
        Double a = ls.stream().filter(x -> x % 2 == 0).peek(System.out::println).map(n -> Math.sqrt(n))
                .mapToDouble(d -> d).average().getAsDouble();
        System.out.print(a);
    }
}
