package io.github.wotjd243.aladin.person.ui;

import io.github.wotjd243.aladin.person.application.SellerService;
import io.github.wotjd243.aladin.person.application.dto.SellerCreateDto;
import io.github.wotjd243.aladin.person.infra.SellerTranslate;
import io.github.wotjd243.aladin.person.ui.dto.SellerResponseDto;
import io.github.wotjd243.aladin.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("seller")
@RestController
@RequiredArgsConstructor
public class SellerController {

    private final SellerService sellerService;

    @GetMapping("{id}")
    public ApiResponse<SellerResponseDto> findUser(@PathVariable String id) {

        return ApiResponse.createOK(SellerTranslate.translate(sellerService.findById(id)));
    }

    @PostMapping
    public ApiResponse createUser(@RequestBody @Valid SellerCreateDto request) {

        sellerService.createSeller(request);
        return ApiResponse.createOK();
    }
}
