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
public class Name {

    private String name;

    public Name(String name) {

        this.name = validation(name);
    }

    private String validation(String name) {

        if (StringUtils.isEmpty(name)) {
            throw new NotFoundException("이름이 없습니다.");
        }

        return name;
    }
}
