package io.github.wotjd243.aladin.person.application;

import io.github.wotjd243.aladin.exception.NotFoundException;
import io.github.wotjd243.aladin.person.application.dto.BuyerCreateDto;
import io.github.wotjd243.aladin.person.application.dto.BuyerUpdateDto;
import io.github.wotjd243.aladin.person.domain.Buyer;
import io.github.wotjd243.aladin.person.domain.BuyerRepository;
import io.github.wotjd243.aladin.person.infra.BuyerTranslate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BuyerService {

    private final BuyerRepository buyerRepository;

    public Buyer createBuyer(BuyerCreateDto create) {
        Buyer buyer = BuyerTranslate.translate(create);
        return buyerRepository.save(buyer);
    }

    public Buyer findById(String id) {

        return buyerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("[%s] 존재하지 않는 구매자 입니다.")));
    }

    @Transactional
    public Buyer updateBuyer(String id, BuyerUpdateDto update) {

        Buyer buyer = buyerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("[%s] 존재하지 않는 구매자 입니다.")));

        buyer.update(update.getPassword(), update.getName(), update.getPhoneNumber(), update.getAddress());
        return buyer;
    }

}
