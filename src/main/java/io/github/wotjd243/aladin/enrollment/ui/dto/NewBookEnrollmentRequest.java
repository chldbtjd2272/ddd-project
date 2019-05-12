package io.github.wotjd243.aladin.enrollment.ui.dto;

import io.github.wotjd243.aladin.enrollment.application.dto.RegisteredBookDto;
import io.github.wotjd243.aladin.enrollment.domain.SellType;
import io.github.wotjd243.aladin.exception.WrongValueException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

@Getter
@NoArgsConstructor
public class NewBookEnrollmentRequest {

    private Long bookId;

    private Long count;

    public RegisteredBookDto toDto() {
        validateCount();
        return RegisteredBookDto.builder()
                .bookId(bookId)
                .count(count)
                .sellType(SellType.NEW)
                .build();
    }

    private void validateCount() {
        if (ObjectUtils.isEmpty(count) || count <= 0) {
            throw new WrongValueException("권수가 잘못되었습니다.");
        }
    }
}
