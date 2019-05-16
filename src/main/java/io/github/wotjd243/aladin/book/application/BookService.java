package io.github.wotjd243.aladin.book.application;

import io.github.wotjd243.aladin.book.domain.Book;
import io.github.wotjd243.aladin.book.domain.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;

    public boolean isExist(Long id) {

        return !ObjectUtils.isEmpty(getBook(id));
    }

    private Book getBook(Long id) {

        return repository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }
}
