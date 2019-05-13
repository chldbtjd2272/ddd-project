package io.github.wotjd243.aladin.enrollment.ui.dto;

import io.github.wotjd243.aladin.enrollment.application.dto.EventDto;
import io.github.wotjd243.aladin.exception.WrongValueException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;


@Getter
@NoArgsConstructor
public class EventRequestDto {
    private LocalDate startDate;

    private LocalDate endDate;

    private Double periodPercent;

    public EventDto toEventDto() {
        validateDate();
        validatePercent();
        return new EventDto(startDate, endDate, periodPercent);
    }

    private void validateDate() {
        if (ObjectUtils.isEmpty(startDate) || ObjectUtils.isEmpty(endDate)) {
            throw new WrongValueException("잘못된 기간설정 입니다.");
        }

        if (endDate.isBefore(startDate)) {
            throw new WrongValueException("잘못된 기간설정 입니다.");
        }
    }

    private void validatePercent() {
        if (ObjectUtils.isEmpty(startDate) || periodPercent < 0) {
            throw new WrongValueException("잘못된 할인율입니다.");
        }
    }
}




