package io.github.wotjd243.aladin.user.domain;

import io.github.wotjd243.aladin.common.domain.Email;
import io.github.wotjd243.aladin.common.domain.Name;
import io.github.wotjd243.aladin.common.domain.PhoneNumber;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(uniqueConstraints = @UniqueConstraint(name = "UNIQUE_LOGIN_ID", columnNames = {"loginId"}))
public class User {

    private String loginId;

    private String password;

    @Embedded
    private Name name;

    @Embedded
    private PhoneNumber phoneNumber;

    @Embedded
    private Email email;

    @Builder
    public User(String loginId, String password, String name, String phoneNumber, String email) {
        this.loginId = loginId;
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

    public String getLoginId() {
        return loginId;
    }

    public String getPassword() {
        return password;
    }

}
