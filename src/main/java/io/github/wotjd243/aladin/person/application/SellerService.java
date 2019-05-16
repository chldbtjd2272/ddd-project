package io.github.wotjd243.aladin.person.application;

import io.github.wotjd243.aladin.exception.NotFoundException;
import io.github.wotjd243.aladin.person.application.dto.SellerCreateDto;
import io.github.wotjd243.aladin.person.application.dto.SellerUpdateDto;
import io.github.wotjd243.aladin.person.domain.Seller;
import io.github.wotjd243.aladin.person.domain.SellerRepository;
import io.github.wotjd243.aladin.person.infra.SellerTranslate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SellerService {

    private final SellerRepository sellerRepository;

    public Seller createSeller(SellerCreateDto create) {

        Seller seller = SellerTranslate.translate(create);
        return sellerRepository.save(seller);
    }

    public Seller findById(String id) {

        return sellerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("[%s] 존재하지 않는 판매자 입니다.")));
    }

    @Transactional
    public Seller updateSeller(String id, SellerUpdateDto update) {

        Seller seller = sellerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("[%s] 존재하지 않는 판매자 입니다.")));

        seller.update(update.getPassword(), update.getName(), update.getPhoneNumber());
        return seller;
    }
}
