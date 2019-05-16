package io.github.wotjd243.aladin.reservation.ui.dto;

import io.github.wotjd243.aladin.reservation.domain.Reservations;
import io.github.wotjd243.aladin.reservation.infra.ReservationTranslate;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ReservationBookDtoCollection {

    private List<ReservationBookDto> reservationBooks;

    ReservationBookDtoCollection(Reservations reservations) {
        reservationBooks = reservations.getReservations().stream()
                .map(ReservationTranslate::translate)
                .collect(Collectors.toList());
    }
}
