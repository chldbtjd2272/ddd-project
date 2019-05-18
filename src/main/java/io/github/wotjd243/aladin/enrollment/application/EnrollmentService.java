package io.github.wotjd243.aladin.enrollment.application;

import io.github.wotjd243.aladin.book.application.RegisteredBookService;
import io.github.wotjd243.aladin.book.application.dto.RegisteredBookDto;
import io.github.wotjd243.aladin.enrollment.application.dto.EnrollmentDto;
import io.github.wotjd243.aladin.enrollment.application.dto.EventDto;
import io.github.wotjd243.aladin.enrollment.domain.Enrollment;
import io.github.wotjd243.aladin.enrollment.domain.EnrollmentRepository;
import io.github.wotjd243.aladin.enrollment.domain.Event;
import io.github.wotjd243.aladin.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    private final RegisteredBookService registeredBookService;

    public Enrollment findById(Long id) {
        return enrollmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("[%s] 등록이 존재하지 않습니다.", id)));
    }

    public void save(EnrollmentDto enrollmentDto, List<RegisteredBookDto> registeredBookDtos) {
        Enrollment enrollment = enrollmentRepository.save(convert(enrollmentDto));
        registeredBookService.save(enrollment.getId(), registeredBookDtos);
    }

    private Enrollment convert(EnrollmentDto dto) {
        Event event = convert(dto.getEventDto());
        return new Enrollment(dto.getSellerId(), Collections.singletonList(event));
    }

    private Event convert(EventDto dto) {
        return new Event(dto.getStartDate(), dto.getEndDate(), dto.getPeriodPercent());
    }

}
