package io.github.wotjd243.aladin.reservation.application;

import io.github.wotjd243.aladin.enrollment.application.RegisteredBookService;
import io.github.wotjd243.aladin.enrollment.domain.RegisteredBook;
import io.github.wotjd243.aladin.reservation.domain.Reservation;
import io.github.wotjd243.aladin.reservation.domain.ShoppingBasket;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ShoppingBasketService shoppingBasketService;
    private final RegisteredBookService registeredBookService;

    @Transactional
    public void add(String buyerId, Long registeredBookId) {

        ShoppingBasket shoppingBasket = shoppingBasketService.findByBuyerId(buyerId);

        RegisteredBook registeredBook = registeredBookService.findById(registeredBookId);

        shoppingBasket.addReservation(reserve(registeredBook));
    }

    @Transactional
    public void delete(String buyerId, Long registeredBookId) {

        ShoppingBasket shoppingBasket = shoppingBasketService.findByBuyerId(buyerId);

        RegisteredBook registeredBook = registeredBookService.findById(registeredBookId);

        shoppingBasket.removeReservation(cancel(registeredBook));
    }

    private Reservation cancel(RegisteredBook registeredBook) {

        registeredBook.cancel();

        return convert(registeredBook);
    }

    private Reservation reserve(RegisteredBook registeredBook) {

        registeredBook.reserve();

        return convert(registeredBook);
    }

    private Reservation convert(RegisteredBook registeredBook) {

        return new Reservation(registeredBook.getBookId(), getDate(), registeredBook.getAmount().getAmount());
    }

    LocalDate getDate() {
        return LocalDate.now();
    }
}
