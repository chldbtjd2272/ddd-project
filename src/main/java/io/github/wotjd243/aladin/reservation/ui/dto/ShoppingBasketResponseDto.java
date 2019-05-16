package io.github.wotjd243.aladin.reservation.ui.dto;

import io.github.wotjd243.aladin.reservation.domain.Reservation;
import io.github.wotjd243.aladin.reservation.domain.Reservations;
import io.github.wotjd243.aladin.reservation.domain.ShoppingBasket;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ShoppingBasketResponseDto {

    private final ReservationBooks reservationBooks;

    private ShoppingBasketResponseDto(ShoppingBasket shoppingBasket) {
        this.reservationBooks = new ReservationBooks(shoppingBasket.getReservations());
    }

    public static ShoppingBasketResponseDto of(ShoppingBasket shoppingBasket) {

        return new ShoppingBasketResponseDto(shoppingBasket);
    }

    @Getter
    private static class ReservationBooks {

        private List<ReservationBook> reservationBooks;

        private ReservationBooks(Reservations reservations) {
            reservationBooks = null;
//            reservationBooks = reservations.getReservations().stream()
//                    .map(ReservationBook::of)
//                    .collect(Collectors.toList());
        }
    }

    @Getter
    public static class ReservationBook {

        private Long bookId;
        private Long amount;
        private Long usedDiscountAmount;
        private Double eventDiscountPercent;

        @Builder
        private ReservationBook(Long bookId, Long amount, Long usedDiscountAmount, Double eventDiscountPercent) {
            this.bookId = bookId;
            this.amount = amount;
            this.usedDiscountAmount = usedDiscountAmount;
            this.eventDiscountPercent = eventDiscountPercent;
        }


        public static ReservationBook of(Reservation reservation) {
            return ReservationBook.builder()
                    .bookId(reservation.getRegisteredBookId())
                    .amount(reservation.getAmount())
                    .usedDiscountAmount(reservation.getUsedDiscountAmount())
                    .eventDiscountPercent(reservation.getEventDiscountPercent())
                    .build();
        }
    }
}
