package io.github.wotjd243.aladin.seller.dto;

import io.github.wotjd243.aladin.seller.domain.Seller;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SellerRequestDto {

    private String loginId;

    private String password;

    private String name;

    private String phoneNumber;

    private String email;

    public Seller toEntity() {
        return Seller.of(loginId, password, name, phoneNumber, email);
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

}
