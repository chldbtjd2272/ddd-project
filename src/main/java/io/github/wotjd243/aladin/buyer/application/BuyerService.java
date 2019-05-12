package io.github.wotjd243.aladin.buyer.application;

import io.github.wotjd243.aladin.buyer.domain.Buyer;
import io.github.wotjd243.aladin.buyer.domain.BuyerRepository;
import io.github.wotjd243.aladin.buyer.dto.BuyerRequestDto;
import io.github.wotjd243.aladin.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuyerService {

    private final BuyerRepository buyerRepository;

    public Buyer createBuyer(BuyerRequestDto requestDto) {
        Buyer buyer = requestDto.toEntity();
        return buyerRepository.save(buyer);
    }

    public Buyer findByLoginId(String loginId) {

        return buyerRepository.findByUserLoginId(loginId)
                .orElseThrow(() -> new NotFoundException(String.format("[%s] 존재하지 않는 구매자 입니다.")));
    }

    public Buyer findById(Long id) {

        return buyerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("[%s] 존재하지 않는 구매자 입니다.")));
    }

}
