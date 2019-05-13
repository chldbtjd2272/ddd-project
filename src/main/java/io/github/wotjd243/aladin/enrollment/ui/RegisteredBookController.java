package io.github.wotjd243.aladin.enrollment.ui;

import io.github.wotjd243.aladin.enrollment.application.RegisteredBookService;
import io.github.wotjd243.aladin.enrollment.ui.dto.NewBookEnrollmentRequest;
import io.github.wotjd243.aladin.enrollment.ui.dto.UsedBookEnrollmentRequest;
import io.github.wotjd243.aladin.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequestMapping("/registered-books")
@RequiredArgsConstructor
public class RegisteredBookController {

    private final RegisteredBookService registeredBookService;

    @PostMapping("/new")
    public ApiResponse save(HttpSession session, @RequestBody NewBookEnrollmentRequest newBookEnrollmentRequest) {
        registeredBookService.save(session, newBookEnrollmentRequest.toDto());
        return ApiResponse.createOK();
    }

    @PostMapping("/used")
    public ApiResponse save(HttpSession session, @RequestBody UsedBookEnrollmentRequest usedBookEnrollmentRequest) {
        registeredBookService.save(session, usedBookEnrollmentRequest.toDto());
        return ApiResponse.createOK();
    }
}
