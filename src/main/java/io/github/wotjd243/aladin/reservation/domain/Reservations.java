package io.github.wotjd243.aladin.reservation.domain;

import io.github.wotjd243.aladin.exception.MaxOverReservationException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Reservations {

    private static final int LIMIT_RESERVATION_COUNT = 15;

    @ElementCollection
    @CollectionTable(
            joinColumns = @JoinColumn(name = "shopping_basket_buyer_id")
    )
    private List<Reservation> reservations = new ArrayList<>();

    public Reservations(List<Reservation> reservations) {
        this.reservations.addAll(reservations);
    }

    void remove(Reservation reservation) {
        reservations.remove(reservation);
    }

    void add(Reservation reservation) {

        enableReservation();

        reservations.add(reservation);
    }

    public int size() {
        return reservations.size();
    }

    private void enableReservation() {

        if (reservations.size() >= LIMIT_RESERVATION_COUNT) {
            throw new MaxOverReservationException(String.format("최대 %s 권을 찜할 수 있습니다.", LIMIT_RESERVATION_COUNT));
        }
    }
}
