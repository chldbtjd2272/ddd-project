package io.github.wotjd243.aladin.enrollment.ui;

import io.github.wotjd243.aladin.common.HttpSessionUtil;
import io.github.wotjd243.aladin.enrollment.application.EnrollmentService;
import io.github.wotjd243.aladin.enrollment.application.dto.EnrollmentDto;
import io.github.wotjd243.aladin.enrollment.ui.dto.EventRequestDto;
import io.github.wotjd243.aladin.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/enrollment")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @PostMapping
    public ApiResponse save(HttpSession session, @RequestBody EventRequestDto requestDto) {
        String sellerId = "1L";
        enrollmentService.save(EnrollmentDto.of(sellerId, requestDto.toEventDto()), HttpSessionUtil.getSessionRegisteredBook(session));
        return ApiResponse.createOK();
    }
}
