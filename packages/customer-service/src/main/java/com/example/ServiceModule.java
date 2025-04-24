package com.example;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.common.base.Joiner;

public class ServiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(CustomerService.class).to(CustomerServiceImpl.class);
        bind(OrderFormatter.class).to(OrderFormatterImpl.class);
    }

    @Provides
    public Joiner provideJoiner() {
        return Joiner.on(",").skipNulls();
    }
}