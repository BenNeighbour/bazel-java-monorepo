package com.example;

import com.google.common.primitives.Ints;
import com.google.inject.Guice;

public class Main {
    public static int compare(int a, int b) {
        return Ints.compare(a, b);
    }

    public static void main(String[] args) {
        var injector = Guice.createInjector(new ServiceModule());

        // todo - .....

        System.out.println("Server started at http://localhost:8080/hello");
    }
}
