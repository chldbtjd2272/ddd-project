package io.github.wotjd243.aladin.person.ui;

import io.github.wotjd243.aladin.person.application.BuyerService;
import io.github.wotjd243.aladin.person.application.dto.BuyerCreateDto;
import io.github.wotjd243.aladin.person.application.dto.BuyerUpdateDto;
import io.github.wotjd243.aladin.person.domain.Buyer;
import io.github.wotjd243.aladin.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BuyerController {

    private final BuyerService buyerService;

    @GetMapping(value = "/buyer/{id}")
    public ApiResponse<Buyer> findBuyer(@PathVariable String id) {

        return ApiResponse.createOK(buyerService.findById(id));
    }

    @PostMapping(value = "/buyer")
    public ApiResponse<Buyer> createBuyer(@RequestBody BuyerCreateDto createDto) {

        return ApiResponse.createOK(buyerService.createBuyer(createDto));
    }

    @PutMapping(value = "/buyer/{id}")
    public ApiResponse<Buyer> updateBuyer(@PathVariable String id, @RequestBody BuyerUpdateDto updateDto) {

        return ApiResponse.createOK(buyerService.updateBuyer(id, updateDto));
    }
}
