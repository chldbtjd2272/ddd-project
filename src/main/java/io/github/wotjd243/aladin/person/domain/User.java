package io.github.wotjd243.aladin.person.domain;

import io.github.wotjd243.aladin.common.domain.Email;
import io.github.wotjd243.aladin.common.domain.Name;
import io.github.wotjd243.aladin.common.domain.PhoneNumber;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class User {

    private String password;

    @Embedded
    private Name name;

    @Embedded
    private PhoneNumber phoneNumber;

    @Embedded
    private Email email;

    @Builder
    public User(String password, String name, String phoneNumber, String email) {
        this.password = password;
        this.name = new Name(name);
        this.phoneNumber = new PhoneNumber(phoneNumber);
        this.email = new Email(email);
    }

    public String getName() {
        return name.getName();
    }

    public String getPhoneNumber() {
        return phoneNumber.getPhoneNumber();
    }

    public String getEmail() {
        return email.getEmail();
    }
}
