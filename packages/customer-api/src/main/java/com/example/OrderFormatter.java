package com.example;

import java.util.List;

/**
 * Strategy for joining order IDs into a single String.
 * Implementations may choose different delimiters or null-handling policies.
 */
public interface OrderFormatter {
    /**
     * Joins the given order IDs into a String.
     *
     * @param orderIds IDs to join (may contain nulls)
     * @return formatted String (never null)
     */
    String formatOrderIds(List<String> orderIds);
}
