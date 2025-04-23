package com.example;

import com.google.common.base.Joiner;
import com.google.inject.Inject;

import java.util.List;

/**
 * Default implementation that uses a Guava Joiner with comma delimiter,
 * skipping null elements.
 */
public class OrderFormatterImpl implements OrderFormatter {
    // Thread-safe, immutable Joiner instance
    private final Joiner joiner;

    @Inject
    public OrderFormatterImpl(Joiner joiner) {
        this.joiner = joiner;
    }

    @Override
    public String formatOrderIds(List<String> orderIds) {
        return joiner.join(orderIds);
    }
}