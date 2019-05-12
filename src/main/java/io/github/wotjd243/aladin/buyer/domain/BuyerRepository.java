package io.github.wotjd243.aladin.buyer.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BuyerRepository extends JpaRepository<Buyer, Long> {

    Optional<Buyer> findByUserLoginId(String loginId);

}
