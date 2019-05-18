package io.github.wotjd243.aladin.book.ui;

import io.github.wotjd243.aladin.book.application.BookService;
import io.github.wotjd243.aladin.book.ui.dto.BookResponseDto;
import io.github.wotjd243.aladin.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookRestController {

    final private BookService bookService;

    @GetMapping(value = "/books/{id}")
    public ApiResponse<BookResponseDto> getBook(@PathVariable Long id) {

        return ApiResponse.createOK(bookService.findById(id));
    }

    @GetMapping(value = "/books/category")
    public ApiResponse<List<BookResponseDto>> searchBookByCategory(@RequestParam("query") String category) {

        return ApiResponse.createOK(bookService.findByCategory(category));
    }

    @GetMapping(value = "/books/title")
    public ApiResponse<List<BookResponseDto>> searchBookByTitle(@RequestParam("query") String name) {

        return ApiResponse.createOK(bookService.findByName(name));
    }
}
