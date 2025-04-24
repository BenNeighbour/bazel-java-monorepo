package com.example;

import com.google.common.base.Joiner;
import com.google.inject.Inject;

import java.util.List;

/**
 * Default implementation that uses a Guava Joiner with comma delimiter,
 * skipping null elements.
 */
public class OrderFormatterImpl implements OrderFormatter {
    private final Joiner joiner;  // Thread-safe, immutable Joiner instance

    @Inject
    public OrderFormatterImpl(Joiner joiner) {
        this.joiner = joiner;
    }

    @Override
    public String formatOrderIds(List<String> orderIds) {
        return joiner.join(orderIds);
    }
}