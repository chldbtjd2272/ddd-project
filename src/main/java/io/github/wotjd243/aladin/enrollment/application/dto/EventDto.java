package io.github.wotjd243.aladin.enrollment.application.dto;

import io.github.wotjd243.aladin.enrollment.domain.Event;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public class EventDto {
    private LocalDate startDate;

    private LocalDate endDate;

    private Double periodPercent;

    public Event toEntity() {
        return new Event(startDate, endDate, periodPercent);
    }
}
