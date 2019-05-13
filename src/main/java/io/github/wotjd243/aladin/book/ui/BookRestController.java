package io.github.wotjd243.aladin.book.ui;

import io.github.wotjd243.aladin.book.application.BookService;
import io.github.wotjd243.aladin.book.ui.dto.BookResponseDto;
import io.github.wotjd243.aladin.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookRestController {

    final private BookService bookService;

    @GetMapping(value = "/book/{id}")
    public ApiResponse<BookResponseDto> getBook(@PathVariable Long id) {

        return ApiResponse.createOK(bookService.findById(id));
    }
}
