package com.example.main;

import com.google.inject.AbstractModule;

public class AppModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(AnalyzeHandler.class);
    }
}
