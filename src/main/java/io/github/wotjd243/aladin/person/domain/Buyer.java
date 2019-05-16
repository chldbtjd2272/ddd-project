package io.github.wotjd243.aladin.person.domain;

import io.github.wotjd243.aladin.common.domain.Address;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Buyer {

    @Id
    private String id;

    @Embedded
    private User user;

    @Embedded
    private Address address;

    @Builder(builderMethodName = "createBuilder")
    private Buyer(final String id, final String password, final String name, final String phoneNumber, final String email, final String address) {
        this.id = id;
        this.user = new User(password, name, phoneNumber, email);
        this.address = new Address(address);
    }
}
