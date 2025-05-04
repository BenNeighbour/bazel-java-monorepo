package com.example.main;

import com.google.common.base.Splitter;
import com.google.common.collect.Multiset;
import com.google.gson.Gson;
import com.google.inject.Inject;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.util.stream.Collectors;

public class AnalyzeHandler implements HttpHandler {
    private final AnalysisService analysisService;
    private final Gson gson = new Gson();

    @Inject
    public AnalyzeHandler(AnalysisService analysisService) {
        this.analysisService = analysisService;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if (!"POST".equals(exchange.getRequestMethod())) {
            exchange.sendResponseHeaders(405, -1);
            return;
        }

        var body = new String(exchange.getRequestBody().readAllBytes());

        // Split body into words via Guava Splitter
        var words = Splitter.onPattern("\\W+")
                .omitEmptyStrings()
                .splitToList(body);

        var counts = analysisService.analyzeText(String.join(" ", words));
        var result = counts.entrySet().stream()
                .collect(Collectors.toMap(
                        Multiset.Entry::getElement,
                        Multiset.Entry::getCount
                ));

        var json = gson.toJson(result);
        exchange.getResponseHeaders()
                .add("Content-Type", "application/json");

        byte[] bytes = json.getBytes();
        exchange.sendResponseHeaders(200, bytes.length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(bytes);
        }
    }
}
