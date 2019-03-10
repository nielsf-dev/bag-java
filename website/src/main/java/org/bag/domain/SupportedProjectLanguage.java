package org.bag.domain;

public enum SupportedProjectLanguage {
    Chinese("zh"),
    English("en"),
    Dutch("nl");

    public final String text;

    SupportedProjectLanguage(final String text) {
        this.text = text;
    }
}
