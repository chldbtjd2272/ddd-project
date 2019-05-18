package io.github.wotjd243.aladin.reservation.infra;

import io.github.wotjd243.aladin.reservation.domain.Reservation;
import io.github.wotjd243.aladin.reservation.domain.ShoppingBasket;
import io.github.wotjd243.aladin.reservation.ui.dto.ReservationBookDto;
import io.github.wotjd243.aladin.reservation.ui.dto.ShoppingBasketResponseDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShoppingBasketTranslate {

    public static ShoppingBasketResponseDto translate(ShoppingBasket shoppingBasket) {

        return ShoppingBasketResponseDto.responseBuilder()
                .shoppingBasket(shoppingBasket)
                .build();
    }

    public static ReservationBookDto translate(Reservation reservation) {

        return ReservationBookDto.builder()
                .bookId(reservation.getRegisteredBookId())
                .amount(reservation.getAmount())
                .build();
    }
}
