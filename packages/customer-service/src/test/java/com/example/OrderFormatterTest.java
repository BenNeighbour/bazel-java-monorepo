package com.example;

import com.google.common.base.Joiner;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("OrderIdFormatter.formatOrderIds")
class OrderFormatterTest {

    // TODO - Try and mock/inject this better
    private final OrderFormatter formatter = new OrderFormatterImpl(Joiner.on(",").skipNulls());

    @Nested
    @DisplayName("When the list is empty or null")
    class EmptyOrNullList {

        @Test
        @DisplayName("Empty list should return empty string")
        void testEmptyList() {
            List<String> empty = Collections.emptyList();
            assertEquals("", formatter.formatOrderIds(empty));
        }

        @Test
        @DisplayName("Null list should throw NullPointerException")
        void testNullList() {
            List<String> nullList = null;

            Assertions.assertThrows(
                    NullPointerException.class,
                    () -> formatter.formatOrderIds(nullList)
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
            assertEquals("A1,B2,C3", formatter.formatOrderIds(ids));
        }

        @Test
        @DisplayName("Single ID should return itself")
        void testSingleNonNull() {
            List<String> ids = Collections.singletonList("X9");
            assertEquals("X9", formatter.formatOrderIds(ids));
        }
    }

    @Nested
    @DisplayName("When list contains nulls")
    class MixedNulls {

        @Test
        @DisplayName("Nulls are skipped")
        void testSkipNulls() {
            List<String> ids = Arrays.asList("A1", null, "B2", null, "C3");
            assertEquals("A1,B2,C3", formatter.formatOrderIds(ids));
        }
    }

    @Nested
    @DisplayName("When all entries are null")
    class AllNulls {

        @Test
        @DisplayName("List of only nulls returns empty string")
        void testAllNulls() {
            List<String> ids = Arrays.asList(null, null);
            assertEquals("", formatter.formatOrderIds(ids));
        }
    }
}
