package io.github.wotjd243.aladin.reservation.ui.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.wotjd243.aladin.reservation.domain.ShoppingBasket;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class ShoppingBasketResponseDto {

    @JsonIgnore
    private final ReservationBookDtoCollection reservationBooks;

    @Builder(builderMethodName = "responseBuilder")
    private ShoppingBasketResponseDto(ShoppingBasket shoppingBasket) {
        this.reservationBooks = new ReservationBookDtoCollection(shoppingBasket.getReservations());
    }

    public List<ReservationBookDto> getBooks() {

        return reservationBooks.getReservationBooks();
    }

    public Long getDeliveryFee() {

        return reservationBooks.computeDeliveryFee();
    }

    public Long getTotalResultAmount() {

        return getTotalAmount() + getDeliveryFee();
    }

    public Long getTotalAmount() {

        return reservationBooks.computeTotalAmount();
    }

    public Integer getCount() {

        return reservationBooks.computeCount();
    }
}
