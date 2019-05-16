package io.github.wotjd243.aladin.reservation.ui.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ReservationBookDto {

    private Long bookId;
    private Long amount;
    private Long usedDiscountAmount;
    private Double eventDiscountPercent;

    @Builder
    private ReservationBookDto(Long bookId, Long amount, Long usedDiscountAmount, Double eventDiscountPercent) {
        this.bookId = bookId;
        this.amount = amount;
        this.usedDiscountAmount = usedDiscountAmount;
        this.eventDiscountPercent = eventDiscountPercent;
    }
}
