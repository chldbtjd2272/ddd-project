package io.github.wotjd243.aladin.seller.application;

import io.github.wotjd243.aladin.exception.NotFoundException;
import io.github.wotjd243.aladin.seller.domain.Seller;
import io.github.wotjd243.aladin.seller.domain.SellerRepository;
import io.github.wotjd243.aladin.seller.dto.SellerRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SellerService {

    private final SellerRepository sellerRepository;

    public Seller createSeller(SellerRequestDto requestDto) {
        Seller seller = requestDto.toEntity();
        return sellerRepository.save(seller);
    }

    public Seller findByUserLoginId(String loginId) {
        return sellerRepository.findByUserLoginId(loginId)
                .orElseThrow(() -> new NotFoundException("존재하지 않는 사용자 입니다."));
    }

    public Seller findById(Long id) {
        return sellerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("존재하지 않는 사용자 입니다."));
    }

}
