package io.github.wotjd243.aladin.book.application;

import io.github.wotjd243.aladin.book.application.dto.RegisteredBookDto;
import io.github.wotjd243.aladin.book.application.dto.RegisteredBookRequestDto;
import io.github.wotjd243.aladin.book.domain.Book;
import io.github.wotjd243.aladin.book.domain.BookRepository;
import io.github.wotjd243.aladin.book.domain.RegisteredBook;
import io.github.wotjd243.aladin.book.domain.RegisteredBookRepository;
import io.github.wotjd243.aladin.enrollment.domain.SellType;
import io.github.wotjd243.aladin.exception.NotFoundException;
import io.github.wotjd243.aladin.exception.WrongValueException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RegisteredBookService {

    private final BookRepository bookRepository;
    private final RegisteredBookRepository registeredBookRepository;

    private final RegisteredBookSessionManager sessionManager;

    public RegisteredBook findById(Long registeredBookId) {

        return registeredBookRepository.findById(registeredBookId)
                .orElseThrow(() -> new NotFoundException(String.format("[%s] 책이 존재하지 않습니다.", registeredBookId)));
    }

    public void save(HttpSession session, RegisteredBookRequestDto registeredBookRequestDto) {
        Book book = findBy(registeredBookRequestDto);

        if (registeredBookRequestDto.getSellType() == SellType.NEW) {
            registeredBookRequestDto.setAmount(book.getPrice());
            sessionManager.addNewRegisteredBook(session, registeredBookRequestDto);
            return;
        }

        validateAmount(book.getPrice(), registeredBookRequestDto.getAmount());
        sessionManager.addUsedRegisteredBook(session, registeredBookRequestDto);
    }

    private void validateAmount(Long price, Long amountOfUsedBook) {
        if (price < amountOfUsedBook) {
            throw new WrongValueException("원래 책값보다 비쌉니다.");
        }
    }

    private Book findBy(RegisteredBookRequestDto dto) {
        return bookRepository.findById(dto.getBookId()).orElseThrow(() -> new NotFoundException("책을 찾을 수 없습니다."));
    }

    public void save(Long enrollmentId, List<RegisteredBookDto> registeredBookDtos) {
        List<RegisteredBook> registeredBooks = registeredBookDtos.stream()
                .map(dto -> convert(enrollmentId, dto))
                .collect(Collectors.toList());

        registeredBookRepository.saveAll(registeredBooks);
    }

    private RegisteredBook convert(Long enrollmentId, RegisteredBookDto dto) {
        return RegisteredBook.builder()
                .bookId(dto.getBookId())
                .unitAmount(dto.getAmount())
                .sellType(dto.getSellType())
                .enrollmentId(enrollmentId)
                .build();
    }

}
