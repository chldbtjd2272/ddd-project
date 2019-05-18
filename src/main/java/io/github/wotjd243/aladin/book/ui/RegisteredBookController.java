package io.github.wotjd243.aladin.book.ui;

import io.github.wotjd243.aladin.book.application.RegisteredBookService;
import io.github.wotjd243.aladin.book.ui.dto.NewBookEnrollmentRequest;
import io.github.wotjd243.aladin.book.ui.dto.RegisteredBookRequestTranslate;
import io.github.wotjd243.aladin.book.ui.dto.UsedBookEnrollmentRequest;
import io.github.wotjd243.aladin.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/registered-books")
@RequiredArgsConstructor
public class RegisteredBookController {

    private final RegisteredBookService registeredBookService;

    @PostMapping("/new")
    public ApiResponse save(HttpSession session, @Valid @RequestBody NewBookEnrollmentRequest newBookEnrollmentRequest) {
        registeredBookService.save(session, RegisteredBookRequestTranslate.translate(newBookEnrollmentRequest));
        return ApiResponse.createOK();
    }

    @PostMapping("/used")
    public ApiResponse save(HttpSession session, @Valid @RequestBody UsedBookEnrollmentRequest usedBookEnrollmentRequest) {
        registeredBookService.save(session, RegisteredBookRequestTranslate.translate(usedBookEnrollmentRequest));
        return ApiResponse.createOK();
    }
}
