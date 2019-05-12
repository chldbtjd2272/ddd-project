package io.github.wotjd243.aladin.buyer.ui;

import io.github.wotjd243.aladin.buyer.application.BuyerService;
import io.github.wotjd243.aladin.buyer.domain.Buyer;
import io.github.wotjd243.aladin.buyer.dto.BuyerRequestDto;
import io.github.wotjd243.aladin.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BuyerController {

    private final BuyerService buyerService;

    @GetMapping(value = "/buyer/{loginId}")
    public ApiResponse<Buyer> findBuyer(@PathVariable String loginId) {

        return ApiResponse.createOK(buyerService.findByLoginId(loginId));
    }

    @PostMapping(value = "/buyer")
    public ApiResponse<Buyer> createBuyer(@RequestBody BuyerRequestDto request) {

        return ApiResponse.createOK(buyerService.createBuyer(request));
    }
}
