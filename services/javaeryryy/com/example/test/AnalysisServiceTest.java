package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import com.example.main.AnalysisService;
import com.google.common.collect.Multiset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class AnalysisServiceTest {

    private final AnalysisService service = new AnalysisService();

    @Nested
    @DisplayName("when given simple text")
    class SimpleText {

        @Test @DisplayName("counts single word")
        void countsSingleWord() {
            Multiset<String> result = service.analyzeText("Hello");
            assertEquals(1, result.count("hello"));
            assertEquals(1, result.elementSet().size());
        }

        @Test @DisplayName("is case‑insensitive")
        void caseInsensitive() {
            Multiset<String> result = service.analyzeText("Hello hello HELLO");
            assertEquals(3, result.count("hello"));
        }

        @Test @DisplayName("splits on punctuation and non‑word chars")
        void splitsOnPunctuation() {
            Multiset<String> result = service.analyzeText("One, two; three!four?");
            assertEquals(1, result.count("one"));
            assertEquals(1, result.count("two"));
            assertEquals(1, result.count("three"));
            assertEquals(1, result.count("four"));
        }

        @Test @DisplayName("handles empty string")
        void handlesEmpty() {
            Multiset<String> result = service.analyzeText("");
            assertTrue(result.isEmpty());
        }
    }
}
