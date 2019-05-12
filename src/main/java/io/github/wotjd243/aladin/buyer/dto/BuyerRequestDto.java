package io.github.wotjd243.aladin.buyer.dto;

import io.github.wotjd243.aladin.buyer.domain.Buyer;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BuyerRequestDto {

    private String loginId;

    private String password;

    private String name;

    private String phoneNumber;

    private String email;

    private String address;

    public Buyer toEntity() {
        return Buyer.of(loginId, password, name, phoneNumber, email, address);
    }

    public String getLoginId() {
        return loginId;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}
