package io.github.wotjd243.aladin.seller.domain;

import io.github.wotjd243.aladin.user.domain.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private User user;

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Seller(User user) {
        this.user = user;
    }

    public static Seller of(String loginId, String password, String name, String phoneNumber, String email) {
        return new Seller(new User(loginId, password, name, phoneNumber, email));
    }
}
