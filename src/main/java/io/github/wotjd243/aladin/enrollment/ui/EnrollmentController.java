package io.github.wotjd243.aladin.enrollment.ui;

import io.github.wotjd243.aladin.common.HttpSessionUtil;
import io.github.wotjd243.aladin.enrollment.application.EnrollmentService;
import io.github.wotjd243.aladin.enrollment.application.dto.EnrollmentDto;
import io.github.wotjd243.aladin.enrollment.ui.dto.EventDtoTranslate;
import io.github.wotjd243.aladin.enrollment.ui.dto.EventRequestDto;
import io.github.wotjd243.aladin.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/enrollment")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @PostMapping
    public ApiResponse save(HttpSession session, @RequestBody @Valid EventRequestDto requestDto) {
        String sellerId = "1L";
        enrollmentService.save(EnrollmentDto.of(sellerId, EventDtoTranslate.translate(requestDto)),
                HttpSessionUtil.getSessionRegisteredBook(session));

        return ApiResponse.createOK();
    }

    @GetMapping
    @Transactional
    public ApiResponse save() {
        String sellerId = "1L";
        log.info("@@@@@@@");
        log.info(enrollmentService.findById(1L).getEvents().size() + "");

        return ApiResponse.createOK();
    }
}
