package io.github.wotjd243.aladin.reservation.ui;

import io.github.wotjd243.aladin.reservation.application.ShoppingBasketService;
import io.github.wotjd243.aladin.reservation.infra.ShoppingBasketTranslate;
import io.github.wotjd243.aladin.reservation.ui.dto.ShoppingBasketResponseDto;
import io.github.wotjd243.aladin.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("shopping-basket")
@RestController
@RequiredArgsConstructor
public class ShoppingBasketController {

    private final ShoppingBasketService shoppingBasketService;

    @GetMapping
    public ApiResponse<ShoppingBasketResponseDto> findShoppingBasket(@RequestHeader("user-id") String buyerId) {

        return ApiResponse.createOK(ShoppingBasketTranslate.translate(shoppingBasketService.findByBuyerId(buyerId)));
    }
}
