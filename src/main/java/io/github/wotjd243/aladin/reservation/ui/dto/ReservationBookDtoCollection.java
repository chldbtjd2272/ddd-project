package io.github.wotjd243.aladin.reservation.ui.dto;

import io.github.wotjd243.aladin.reservation.domain.Reservations;
import io.github.wotjd243.aladin.reservation.infra.ReservationTranslate;
import lombok.Getter;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ReservationBookDtoCollection {

    private static final Integer DELIVERY_FEE_MIN_COUNT = 3;
    private static final Long DELIVERY_FEE = 2500L;

    private List<ReservationBookDto> reservationBooks;

    ReservationBookDtoCollection(Reservations reservations) {
        reservationBooks = reservations.getReservations().stream()
                .map(ReservationTranslate::translate)
                .collect(Collectors.toList());
    }

    public Long computeDeliveryFee() {

        if (CollectionUtils.isEmpty(reservationBooks)) {
            return 0L;
        }

        if (reservationBooks.size() > DELIVERY_FEE_MIN_COUNT) {
            return 0L;
        }

        return DELIVERY_FEE;
    }

    public Long computeTotalAmount() {

        if (CollectionUtils.isEmpty(reservationBooks)) {
            return 0L;
        }

        return reservationBooks.stream()
                .mapToLong(ReservationBookDto::getAmount)
                .sum();
    }

    public Integer computeCount() {

        if (CollectionUtils.isEmpty(reservationBooks)) {
            return 0;
        }

        return reservationBooks.size();
    }
}
