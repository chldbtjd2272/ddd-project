package io.github.wotjd243.aladin.person.ui;

import io.github.wotjd243.aladin.person.application.SellerService;
import io.github.wotjd243.aladin.person.application.dto.SellerCreateDto;
import io.github.wotjd243.aladin.person.application.dto.SellerUpdateDto;
import io.github.wotjd243.aladin.person.domain.Seller;
import io.github.wotjd243.aladin.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class SellerController {

    private final SellerService sellerService;

    @GetMapping(value = "/seller/{id}")
    public ApiResponse<Seller> findSeller(@PathVariable String id) {

        return ApiResponse.createOK(sellerService.findById(id));
    }

    @PostMapping(value = "/seller")
    public ApiResponse<Seller> createSeller(@RequestBody @Valid SellerCreateDto createDto) {

        return ApiResponse.createOK(sellerService.createSeller(createDto));
    }


    @PutMapping(value = "/seller/{id}")
    public ApiResponse<Seller> updateSeller(@PathVariable String id, @RequestBody @Valid SellerUpdateDto updateDto) {

        return ApiResponse.createOK(sellerService.updateSeller(id, updateDto));
    }
}
