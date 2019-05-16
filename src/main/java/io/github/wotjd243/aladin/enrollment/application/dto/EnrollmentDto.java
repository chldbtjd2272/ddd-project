package io.github.wotjd243.aladin.enrollment.application.dto;

import io.github.wotjd243.aladin.enrollment.domain.Enrollment;
import io.github.wotjd243.aladin.enrollment.domain.RegisteredBook;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EnrollmentDto {

    private EventDto eventDto;
    private List<SessionRegisteredBook> registeredBooks;

    @Builder
    public EnrollmentDto(EventDto eventDto, List<SessionRegisteredBook> registeredBooks) {
        this.eventDto = eventDto;
        this.registeredBooks = registeredBooks;
    }

    public static EnrollmentDto of(List<SessionRegisteredBook> books, EventDto eventDto) {
        return EnrollmentDto.builder()
                .registeredBooks(books)
                .eventDto(eventDto)
                .build();
    }

    public Enrollment toEntity(Long sellerId) {
        List<RegisteredBook> books = registeredBooks.stream().map(SessionRegisteredBook::toEntity).collect(Collectors.toList());
        return new Enrollment(sellerId, books, Collections.singletonList(eventDto.toEntity()));

    }

}
