package io.github.wotjd243.aladin.book.ui;

import io.github.wotjd243.aladin.book.application.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookRestController {

    final private BookService bookService;

    @GetMapping(value = "/book/{id}")
    public boolean isExist(@PathVariable Long id) {
        return bookService.isExist(id);
    }
}
