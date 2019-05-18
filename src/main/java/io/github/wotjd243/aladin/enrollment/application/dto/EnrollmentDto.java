package io.github.wotjd243.aladin.enrollment.application.dto;

import io.github.wotjd243.aladin.book.application.RegisteredBookDto;
import io.github.wotjd243.aladin.book.domain.RegisteredBook;
import io.github.wotjd243.aladin.enrollment.domain.Enrollment;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EnrollmentDto {

    private EventDto eventDto;
    private List<RegisteredBookDto> registeredBooks;

    @Builder
    public EnrollmentDto(EventDto eventDto, List<RegisteredBookDto> registeredBooks) {
        this.eventDto = eventDto;
        this.registeredBooks = registeredBooks;
    }

    public static EnrollmentDto of(List<RegisteredBookDto> books, EventDto eventDto) {
        return EnrollmentDto.builder()
                .registeredBooks(books)
                .eventDto(eventDto)
                .build();
    }

    public Enrollment toEntity(Long sellerId) {
        List<RegisteredBook> books = registeredBooks.stream().map(RegisteredBookDto::toEntity).collect(Collectors.toList());
        return new Enrollment(sellerId, books, Collections.singletonList(eventDto.toEntity()));

    }

}
