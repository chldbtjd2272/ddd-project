package io.github.wotjd243.aladin.person.ui;

import io.github.wotjd243.aladin.person.application.BuyerService;
import io.github.wotjd243.aladin.person.application.dto.BuyerCreateDto;
import io.github.wotjd243.aladin.person.infra.BuyerTranslate;
import io.github.wotjd243.aladin.person.ui.dto.BuyerResponseDto;
import io.github.wotjd243.aladin.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("buyer")
@RestController
@RequiredArgsConstructor
public class BuyerController {

    private final BuyerService buyerService;

    @GetMapping("{id}")
    public ApiResponse<BuyerResponseDto> findBuyer(@PathVariable String id) {

        return ApiResponse.createOK(BuyerTranslate.translate(buyerService.findById(id)));
    }

    @PostMapping
    public ApiResponse createBuyer(@RequestBody @Valid BuyerCreateDto request) {

        buyerService.createBuyer(request);
        return ApiResponse.createOK();
    }
}
