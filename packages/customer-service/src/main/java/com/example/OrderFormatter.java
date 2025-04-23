package com.example;

import com.google.common.base.Joiner;

import java.util.List;

public final class OrderFormatter {
    // Thread-safe, immutable Joiner instance that skips nulls
    private static final Joiner JOINER = Joiner.on(",").skipNulls();

    /**
     * Joins the given order IDs into a CSV string, omitting any nulls.
     *
     * @param orderIds list of order ID strings (may contain nulls)
     * @return comma-separated IDs (e.g. "A123,B456,C789"), or "" if input is empty or all null
     */
    public static String formatOrderIds(List<String> orderIds) {
        // e.g. Joiner.on(",").skipNulls().join(Arrays.asList("A1", null, "B2")) ⇒ "A1,B2"
        return JOINER.join(orderIds);
    }
}