package io.github.wotjd243.aladin.enrollment.ui.dto;

import io.github.wotjd243.aladin.enrollment.application.dto.RegisteredBookDto;
import io.github.wotjd243.aladin.enrollment.domain.SellType;
import io.github.wotjd243.aladin.exception.WrongValueException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

@Getter
@NoArgsConstructor
public class UsedBookEnrollmentRequest {

    private Long bookId;

    private Long amount;

    public RegisteredBookDto toDto() {
        validateAmount();
        return RegisteredBookDto.builder()
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

