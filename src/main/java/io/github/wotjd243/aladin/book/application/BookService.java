package io.github.wotjd243.aladin.book.application;

import io.github.wotjd243.aladin.book.domain.Book;
import io.github.wotjd243.aladin.book.domain.BookRepository;
import io.github.wotjd243.aladin.book.infra.BookTranslator;
import io.github.wotjd243.aladin.book.ui.dto.BookResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;

    public BookResponseDto findById(Long id) {

        Book book = repository.findById(id)
                .orElseThrow(IllegalArgumentException::new);

        return BookTranslator.translate(book);

    }
}
