package io.github.wotjd243.aladin.enrollment.application;

import io.github.wotjd243.aladin.book.domain.Book;
import io.github.wotjd243.aladin.book.domain.BookRepository;
import io.github.wotjd243.aladin.enrollment.application.dto.RegisteredBookDto;
import io.github.wotjd243.aladin.enrollment.domain.SellType;
import io.github.wotjd243.aladin.exception.NotFoundException;
import io.github.wotjd243.aladin.exception.WrongValueException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@RequiredArgsConstructor
public class RegisteredBookService {

    private final BookRepository bookRepository;

    private final RegisteredBookSessionManager sessionManager;

    public void save(HttpSession session, RegisteredBookDto registeredBookDto) {
        Book book = findBy(registeredBookDto);

        if (registeredBookDto.getSellType() == SellType.NEW) {
            registeredBookDto.setAmount(book.getPrice());
            sessionManager.addNewRegisteredBook(session, registeredBookDto);
            return;
        }

        validateAmount(book.getPrice(), registeredBookDto.getAmount());
        sessionManager.addUsedRegisteredBook(session, registeredBookDto);
    }

    private void validateAmount(Long price, Long amountOfUsedBook) {
        if (price < amountOfUsedBook) {
            throw new WrongValueException("원래 책값보다 비쌉니다.");
        }
    }

    private Book findBy(RegisteredBookDto dto) {
        return bookRepository.findById(dto.getBookId()).orElseThrow(() -> new NotFoundException("책을 찾을 수 없습니다."));
    }
}
