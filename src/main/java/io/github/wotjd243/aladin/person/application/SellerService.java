package io.github.wotjd243.aladin.person.application;

import io.github.wotjd243.aladin.exception.NotFoundException;
import io.github.wotjd243.aladin.person.application.dto.SellerCreateDto;
import io.github.wotjd243.aladin.person.domain.Seller;
import io.github.wotjd243.aladin.person.domain.SellerRepository;
import io.github.wotjd243.aladin.person.infra.SellerTranslate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SellerService {

    private final SellerRepository sellerRepository;

    public Seller createSeller(SellerCreateDto requestDto) {

        Seller seller = SellerTranslate.translate(requestDto);
        return sellerRepository.save(seller);
    }

    public Seller findById(String id) {

        return sellerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("[%s] 존재하지 않는 판매자 입니다.", id)));
    }
}
