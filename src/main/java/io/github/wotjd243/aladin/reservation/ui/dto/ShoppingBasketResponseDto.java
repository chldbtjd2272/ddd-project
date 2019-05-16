package io.github.wotjd243.aladin.reservation.ui.dto;

import io.github.wotjd243.aladin.reservation.domain.ShoppingBasket;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ShoppingBasketResponseDto {

    private final ReservationBookDtoCollection reservationBooks;

    @Builder(builderMethodName = "responseBuilder")
    private ShoppingBasketResponseDto(ShoppingBasket shoppingBasket) {
        this.reservationBooks = new ReservationBookDtoCollection(shoppingBasket.getReservations());
    }
}
