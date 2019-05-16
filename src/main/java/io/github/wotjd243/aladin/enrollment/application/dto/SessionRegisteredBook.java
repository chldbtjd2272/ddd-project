package io.github.wotjd243.aladin.enrollment.application.dto;

import io.github.wotjd243.aladin.enrollment.domain.RegisteredBook;
import io.github.wotjd243.aladin.enrollment.domain.SellType;
import io.github.wotjd243.aladin.enrollment.domain.UnitAmount;
import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SessionRegisteredBook {

    private Long bookId;

    private UnitAmount amount;

    private SellType sellType;

    @Builder
    public SessionRegisteredBook(Long bookId, UnitAmount amount, SellType sellType) {
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
