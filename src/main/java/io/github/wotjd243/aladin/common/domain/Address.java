package io.github.wotjd243.aladin.common.domain;

import io.github.wotjd243.aladin.exception.NotFoundException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Address {

    private String address;

    public Address(String address) {

        this.address = validation(address);
    }

    private String validation(String address) {

        if (StringUtils.isEmpty(address)) {
            throw new NotFoundException("주소가 없습니다.");
        }

        return address;
    }
}
