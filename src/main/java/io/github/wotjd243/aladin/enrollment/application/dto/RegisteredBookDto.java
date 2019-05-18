package io.github.wotjd243.aladin.enrollment.application.dto;

import io.github.wotjd243.aladin.enrollment.domain.SellType;
import io.github.wotjd243.aladin.common.domain.UnitAmount;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RegisteredBookDto {

    private Long bookId;

    private Long count;

    @Setter
    private Long amount;

    private SellType sellType;

    @Builder
    public RegisteredBookDto(Long bookId, Long count, Long amount, SellType sellType) {
        this.bookId = bookId;
        this.count = count;
        this.amount = amount;
        this.sellType = sellType;
    }

    public SessionRegisteredBook toSession() {
        return SessionRegisteredBook.builder()
                .bookId(bookId)
                .amount(new UnitAmount(amount))
                .sellType(sellType)
                .build();

    }

}
