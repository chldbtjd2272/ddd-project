package io.github.wotjd243.aladin.book.ui.dto;

import io.github.wotjd243.aladin.book.application.RegisteredBookRequestDto;
import io.github.wotjd243.aladin.enrollment.domain.SellType;
import io.github.wotjd243.aladin.exception.WrongValueException;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UsedBookEnrollmentRequest {

    private Long bookId;

    private Long amount;

    @Builder(builderMethodName = "createBuilder")
    private UsedBookEnrollmentRequest(Long bookId, Long amount) {
        this.bookId = bookId;
        this.amount = amount;
    }

    public RegisteredBookRequestDto toDto() {
        validateAmount();
        return RegisteredBookRequestDto.builder()
                .bookId(bookId)
                .amount(amount)
                .sellType(SellType.USED)
                .build();
    }

    private void validateAmount() {
        if (ObjectUtils.isEmpty(amount) || amount <= 1000) {
            throw new WrongValueException("잘못된 가격입니다.");
        }
    }
}

