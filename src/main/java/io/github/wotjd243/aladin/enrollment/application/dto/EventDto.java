package io.github.wotjd243.aladin.enrollment.application.dto;

import io.github.wotjd243.aladin.enrollment.domain.Event;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EventDto {

    private LocalDate startDate;

    private LocalDate endDate;

    private Double periodPercent;

    public EventDto(LocalDate startDate, LocalDate endDate, Double periodPercent) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.periodPercent = periodPercent;
    }

    public Event toEntity() {
        return new Event(startDate, endDate, periodPercent);
    }
}
