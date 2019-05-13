package io.github.wotjd243.aladin.enrollment.domain;

public enum SellType {
    NEW("새 책"),
    USED("중고책");

    private String description;

    SellType(String description) {
        this.description = description;
    }
}
