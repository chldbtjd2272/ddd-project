//package io.github.wotjd243.aladin.reservation.infra;
//
//import io.github.wotjd243.aladin.reservation.domain.ShoppingBasket;
//import io.github.wotjd243.aladin.reservation.domain.ShoppingBasketRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.persistence.EntityManager;
//import javax.persistence.Query;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//@RequiredArgsConstructor
//public class JpaShoppingBasketRepository implements ShoppingBasketRepository {
//
//    private final EntityManager entityManager;
//
//    @Override
//    public Optional<ShoppingBasket> findById(Long buyerId) {
//
//        return Optional.ofNullable(entityManager.find(ShoppingBasket.class, buyerId));
//    }
//
//    @Override
//    @Transactional
//    public ShoppingBasket save(ShoppingBasket shoppingBasket) {
//        entityManager.persist(shoppingBasket);
//        return shoppingBasket;
//    }
//
//    @Override
//    @Transactional
//    public void deleteAll() {
//
//        Query query = entityManager.createQuery("SELECT s from ShoppingBasket s", ShoppingBasket.class);
//
//        List<ShoppingBasket> list = query.getResultList();
//        list.forEach(entityManager::remove);
//    }
//}
