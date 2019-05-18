package io.github.wotjd243.aladin.book.ui.dto;

import io.github.wotjd243.aladin.book.application.dto.RegisteredBookRequestDto;
import io.github.wotjd243.aladin.enrollment.domain.SellType;

public class RegisteredBookRequestTranslate {

    public static RegisteredBookRequestDto translate(NewBookEnrollmentRequest request) {
        return RegisteredBookRequestDto.builder()
                .bookId(request.getBookId())
                .count(request.getCount())
                .sellType(SellType.NEW)
                .build();
    }

    public static RegisteredBookRequestDto translate(UsedBookEnrollmentRequest request) {
        return RegisteredBookRequestDto.builder()
                .bookId(request.getBookId())
                .amount(request.getAmount())
                .sellType(SellType.USED)
                .build();
    }
}
