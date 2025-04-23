package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for Main.compare(int, int) using JUnit 5 and Java 17.
 * No parameterized tests are used — all test cases are explicit.
 */
@DisplayName("Main.compare(int, int)")
public class MainTest {

    @Nested
    @DisplayName("Main.main(String[])")
    class MainMethod {

        @Test
        @DisplayName("Should execute main without exceptions")
        void testMain() {
            Main.main(new String[]{});
        }
    }

    @Nested
    @DisplayName("When both integers are equal")
    class EqualNumbers {

        @Test
        @DisplayName("compare(1, 1) should return 0")
        void testOneAndOne() {
            assertEquals(0, Main.compare(1, 1));
        }

        @Test
        @DisplayName("compare(0, 0) should return 0")
        void testZeroAndZero() {
            assertEquals(0, Main.compare(0, 0));
        }

        @Test
        @DisplayName("compare(-5, -5) should return 0")
        void testNegativeFiveAndNegativeFive() {
            assertEquals(0, Main.compare(-5, -5));
        }
    }

    @Nested
    @DisplayName("When the first integer is less than the second")
    class LessThan {

        @Test
        @DisplayName("compare(1, 2) should return negative")
        void testOneAndTwo() {
            var result = Main.compare(1, 2);
            assert result < 0 : "Expected negative result, got: " + result;
        }

        @Test
        @DisplayName("compare(-10, -5) should return negative")
        void testNegativeTenAndNegativeFive() {
            var result = Main.compare(-10, -5);
            assert result < 0;
        }

        @Test
        @DisplayName("compare(0, 100) should return negative")
        void testZeroAndHundred() {
            var result = Main.compare(0, 100);
            assert result < 0;
        }
    }

    @Nested
    @DisplayName("When the first integer is greater than the second")
    class GreaterThan {

        @Test
        @DisplayName("compare(3, 1) should return positive")
        void testThreeAndOne() {
            var result = Main.compare(3, 1);
            assert result > 0;
        }

        @Test
        @DisplayName("compare(100, 50) should return positive")
        void testHundredAndFifty() {
            var result = Main.compare(100, 50);
            assert result > 0;
        }

        @Test
        @DisplayName("compare(0, -1) should return positive")
        void testZeroAndNegativeOne() {
            var result = Main.compare(0, -1);
            assert result > 0;
        }
    }
}
