package io.github.wotjd243.aladin.seller.ui;

import io.github.wotjd243.aladin.response.ApiResponse;
import io.github.wotjd243.aladin.seller.application.SellerService;
import io.github.wotjd243.aladin.seller.domain.Seller;
import io.github.wotjd243.aladin.seller.dto.SellerRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SellerController {

    private final SellerService sellerService;

    @GetMapping(value = "/seller/{loginId}")
    public ApiResponse<Seller> findUser(@PathVariable String loginId) {

        return ApiResponse.createOK(sellerService.findByUserLoginId(loginId));
    }

    @PostMapping(value = "/seller")
    public ApiResponse<Seller> createUser(@RequestBody SellerRequestDto request) {

        return ApiResponse.createOK(sellerService.createSeller(request));
    }
}
