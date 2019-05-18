package io.github.wotjd243.aladin.reservation.application;

import io.github.wotjd243.aladin.person.application.BuyerService;
import io.github.wotjd243.aladin.person.domain.Buyer;
import io.github.wotjd243.aladin.reservation.domain.ShoppingBasket;
import io.github.wotjd243.aladin.reservation.domain.ShoppingBasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShoppingBasketService {

    private final BuyerService buyerService;
    private final ShoppingBasketRepository shoppingBasketRepository;

    public ShoppingBasket findByBuyerId(String buyerId) {

        Buyer buyer = buyerService.findById(buyerId);

        return shoppingBasketRepository.findById(buyer.getId())
                .orElseGet(() -> shoppingBasketRepository.save(new ShoppingBasket(buyer.getId())));
    }
}
