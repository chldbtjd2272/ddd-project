package io.github.wotjd243.aladin.reservation.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reservation {

    private Long registeredBookId;

    private LocalDate reservationDate;

    private Long amount;
    private Long usedDiscountAmount;
    private Double eventDiscountPercent;

    public Reservation(Long registeredBookId, LocalDate reservationDate, Long amount, Long usedDiscountAmount, Double eventDiscountPercent) {
        this.registeredBookId = registeredBookId;
        this.reservationDate = reservationDate;
        this.amount = amount;
        this.usedDiscountAmount = usedDiscountAmount;
        this.eventDiscountPercent = eventDiscountPercent;
    }
}
