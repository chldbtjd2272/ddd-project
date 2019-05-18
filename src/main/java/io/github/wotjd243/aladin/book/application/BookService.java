package io.github.wotjd243.aladin.book.application;

import io.github.wotjd243.aladin.book.domain.Book;
import io.github.wotjd243.aladin.book.domain.BookRepository;
import io.github.wotjd243.aladin.book.domain.Category;
import io.github.wotjd243.aladin.book.infra.BookTranslator;
import io.github.wotjd243.aladin.book.ui.dto.BookResponseDto;
import io.github.wotjd243.aladin.common.domain.Name;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;

    public BookResponseDto findById(Long id) {

        Book book = repository.findById(id)
                .orElseThrow(IllegalArgumentException::new);

        return BookTranslator.translate(book);

    }

    public List<BookResponseDto> findByCategory(String category) {

        List<Book> bookList = repository.findBooksByCategory(new Category(category));

        return bookList.stream()
                .map(BookTranslator::translate)
                .collect(Collectors.toList());

    }

    public List<BookResponseDto> findByName(String name) {

        List<Book> bookList = repository.findBooksByNameNameContaining(name);

        return bookList.stream()
                .map(BookTranslator::translate)
                .collect(Collectors.toList());

    }
}
