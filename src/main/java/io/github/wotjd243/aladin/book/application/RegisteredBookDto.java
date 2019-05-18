package io.github.wotjd243.aladin.book.application;

import io.github.wotjd243.aladin.book.domain.RegisteredBook;
import io.github.wotjd243.aladin.common.domain.UnitAmount;
import io.github.wotjd243.aladin.enrollment.domain.SellType;
import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RegisteredBookDto {

    private Long bookId;

    private UnitAmount amount;

    private SellType sellType;

    @Builder
    public RegisteredBookDto(Long bookId, UnitAmount amount, SellType sellType) {
        this.bookId = bookId;
        this.amount = amount;
        this.sellType = sellType;
    }

    public RegisteredBook toEntity() {
        return RegisteredBook.builder()
                .bookId(bookId)
                .unitAmount(amount)
                .sellType(sellType)
                .build();
    }
}
