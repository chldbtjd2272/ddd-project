package io.github.wotjd243.aladin.buyer.domain;

import io.github.wotjd243.aladin.common.domain.Address;
import io.github.wotjd243.aladin.user.domain.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private User user;

    @Embedded
    private Address address;

    public Buyer(User user, String address) {
        this.user = user;
        this.address = new Address(address);
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Address getAddress() {
        return address;
    }

    public static Buyer of(String loginId, String password, String name, String phoneNumber, String email, String address) {
        return new Buyer(new User(loginId, password, name, phoneNumber, email), address);
    }
}
