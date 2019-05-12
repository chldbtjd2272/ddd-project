package io.github.wotjd243.aladin.buyer.domain;

import io.github.wotjd243.aladin.user.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@RunWith(SpringRunner.class)
public class BuyerRepositoryTest {


    @Autowired
    BuyerRepository repository;

    @Test
    public void Buyer_조회() {

        // given
        Buyer buyer = createBuyer();

        // when
        Optional<Buyer> resultBuyer = repository.findByUserLoginId("test");

        // then
        assertThat(resultBuyer.get().getUser().getLoginId()).isEqualTo(buyer.getUser().getLoginId());

    }

    public Buyer createBuyer() {
        return repository.save(new Buyer(new User("test", "password", "sehee", "010-1111-2222", "sehee@naver.com"), "행당동"));
    }


}
