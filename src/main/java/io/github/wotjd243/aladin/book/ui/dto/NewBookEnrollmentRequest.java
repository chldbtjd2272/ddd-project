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
public class NewBookEnrollmentRequest {

    private Long bookId;

    private Long count;

    @Builder(builderMethodName = "createBuilder")
    private NewBookEnrollmentRequest(Long bookId, Long count) {
        this.bookId = bookId;
        this.count = count;
    }

    public RegisteredBookRequestDto toDto() {
        validateCount();
        return RegisteredBookRequestDto.builder()
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
