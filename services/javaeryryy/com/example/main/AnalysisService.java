package com.example.main;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import java.util.Arrays;

public class AnalysisService {

    /** Counts word frequencies in the input text */
    public Multiset<String> analyzeText(String text) {
        Multiset<String> counts = HashMultiset.create();
        counts.addAll(Arrays.asList(text.toLowerCase().split("\\W+")));

        return counts;
    }
}
