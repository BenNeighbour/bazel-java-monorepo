package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for OrderFormatter.formatOrderIds(List<String>).
 */
@DisplayName("OrderFormatter.formatOrderIds")
class OrderFormatterTest {

    @Nested
    @DisplayName("When the list is empty or null")
    class EmptyOrNullList {

        @Test
        @DisplayName("Empty list should return empty string")
        void testEmptyList() {
            List<String> empty = Collections.emptyList();
            assertEquals("", OrderFormatter.formatOrderIds(empty));
        }

        @Test
        @DisplayName("Null list should throw NullPointerException")
        void testNullList() {
            List<String> nullList = null;

            // Joiner.join(null) throws NPE by default if iterable is null
            org.junit.jupiter.api.Assertions.assertThrows(
                    NullPointerException.class,
                    () -> OrderFormatter.formatOrderIds(nullList)
            );
        }
    }

    @Nested
    @DisplayName("When all IDs are non-null")
    class AllNonNull {

        @Test
        @DisplayName("Multiple IDs should be joined with commas")
        void testMultipleNonNull() {
            List<String> ids = Arrays.asList("A1", "B2", "C3");
            assertEquals("A1,B2,C3", OrderFormatter.formatOrderIds(ids));
        }

        @Test
        @DisplayName("Single ID should return itself")
        void testSingleNonNull() {
            List<String> ids = Collections.singletonList("X9");
            assertEquals("X9", OrderFormatter.formatOrderIds(ids));
        }
    }

    @Nested
    @DisplayName("When list contains nulls")
    class MixedNulls {

        @Test
        @DisplayName("Nulls are skipped")
        void testSkipNulls() {
            List<String> ids = Arrays.asList("A1", null, "B2", null, "C3");

            // skipNulls() drops all null entries
            assertEquals("A1,B2,C3", OrderFormatter.formatOrderIds(ids));
        }
    }

    @Nested
    @DisplayName("When all entries are null")
    class AllNulls {

        @Test
        @DisplayName("List of only nulls returns empty string")
        void testAllNulls() {
            List<String> ids = Arrays.asList(null, null);
            assertEquals("", OrderFormatter.formatOrderIds(ids));
        }
    }
}
