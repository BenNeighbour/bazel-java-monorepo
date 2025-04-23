package com.example;

import com.google.common.primitives.Ints;
import com.google.inject.Guice;

import java.util.Collections;

public class Main {
    public static int compare(int a, int b) {
        return Ints.compare(a, b);
    }

    public static void main(String[] args) {
        var injector = Guice.createInjector(new ServiceModule());
        var formatter = injector.getInstance(OrderFormatter.class);

        System.out.println(formatter.formatOrderIds(Collections.singletonList("123")));
    }
}
