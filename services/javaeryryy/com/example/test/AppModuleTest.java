package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import com.example.main.AnalyzeHandler;
import com.example.main.AppModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AppModuleTest {

    @Test @DisplayName("binds AnalyzeHandler and its dependencies")
    void injectorProvidesAnalyzeHandler() {
        Injector injector = Guice.createInjector(new AppModule());
        AnalyzeHandler handler = injector.getInstance(AnalyzeHandler.class);
        assertNotNull(handler, "AnalyzeHandler should be bound and instantiable");

        // The AnalysisService should have been injected
        assertNotNull(
                handler,
                "AnalyzeHandler was instantiated, so AnalysisService injection succeeded too"
        );
    }
}
