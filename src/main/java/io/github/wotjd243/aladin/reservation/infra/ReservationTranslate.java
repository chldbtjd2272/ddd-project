package io.github.wotjd243.aladin.reservation.infra;

import io.github.wotjd243.aladin.reservation.domain.Reservation;
import io.github.wotjd243.aladin.reservation.ui.dto.ReservationBookDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReservationTranslate {

    public static ReservationBookDto translate(Reservation reservation) {

        return ReservationBookDto.builder()
                .bookId(reservation.getRegisteredBookId())
                .amount(reservation.getAmount())
                .build();
    }
}
