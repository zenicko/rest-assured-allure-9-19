package ru.zenicko.demoqa.helpers;

import io.qameta.allure.restassured.AllureRestAssured;

public class AllureRestAssuredCustomFilter {
    private static final AllureRestAssured FILTER = new AllureRestAssured();

    private AllureRestAssuredCustomFilter() {
    }
    public static AllureRestAssuredCustomFilter customLogFilter() {
        return InitLogFilter.logFilter;
    }
    public AllureRestAssured withCustomTemplates() {
        FILTER.setRequestTemplate("request.ftl");
        FILTER.setResponseTemplate("response.ftl");
        return FILTER;
    }

    private static class InitLogFilter {
        private static final AllureRestAssuredCustomFilter logFilter = new AllureRestAssuredCustomFilter();
    }

}
