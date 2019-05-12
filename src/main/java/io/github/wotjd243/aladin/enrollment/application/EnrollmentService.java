package io.github.wotjd243.aladin.enrollment.application;

import io.github.wotjd243.aladin.enrollment.application.dto.EnrollmentDto;
import io.github.wotjd243.aladin.enrollment.domain.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    public void save(Long sellerId, EnrollmentDto enrollmentDto) {
        enrollmentRepository.save(enrollmentDto.toEntity(sellerId));
    }

}
