package io.github.wotjd243.aladin.book.application;

import io.github.wotjd243.aladin.book.domain.Book;
import io.github.wotjd243.aladin.book.domain.BookRepository;
import io.github.wotjd243.aladin.book.ui.dto.BookResponseDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    public void Id로_책_조회() {
        // given
        given(bookRepository.findById(any()))
                .willReturn(
                        Optional.of(
                                Book.createBuilder()
                                        .name("이펙티브 자바 (Effective Java)")
                                        .author("조슈아 블로크")
                                        .category("IT")
                                        .publisher("인사이트")
                                        .price(10000L)
                                        .build()
                        )
                )
        ;

        Book book = Book.createBuilder()
                .name("이펙티브 자바 (Effective Java)")
                .author("조슈아 블로크")
                .category("IT")
                .publisher("인사이트")
                .price(10000L)
                .build();

        // when
        BookResponseDto bookDto = bookService.findById(1L);

        // then
        assertThat(bookDto.getName()).isEqualTo(book.getName());
        assertThat(bookDto.getAuthor()).isEqualTo(book.getAuthor());
    }

    @Test
    public void 카테고리로_책_조회() {
        // given
        given(bookRepository.findBooksByCategory(any()))
                .willReturn(
                        Arrays.asList(
                                (
                                        Book.createBuilder()
                                                .name("이펙티브 자바 (Effective Java)")
                                                .author("조슈아 블로크")
                                                .category("IT")
                                                .publisher("인사이트")
                                                .price(10000L)
                                                .build()
                                )
                        )
                )
        ;

        Book book = Book.createBuilder()
                .name("이펙티브 자바 (Effective Java)")
                .author("조슈아 블로크")
                .category("IT")
                .publisher("인사이트")
                .price(10000L)
                .build();

        // when
        List<BookResponseDto> bookDtoList = bookService.findByCategory("IT");

        // then
        assertThat(bookDtoList.get(0).getName()).isEqualTo(book.getName());
        assertThat(bookDtoList.get(0).getAuthor()).isEqualTo(book.getAuthor());
    }

    @Test
    public void 제목으로_책_조회() {
        // given
        given(bookRepository.findBooksByNameNameContaining(any()))
                .willReturn(
                        Arrays.asList(
                                (
                                        Book.createBuilder()
                                                .name("이펙티브 자바 (Effective Java)")
                                                .author("조슈아 블로크")
                                                .category("IT")
                                                .publisher("인사이트")
                                                .price(10000L)
                                                .build()
                                )
                        )
                )
        ;

        Book book = Book.createBuilder()
                .name("이펙티브 자바 (Effective Java)")
                .author("조슈아 블로크")
                .category("IT")
                .publisher("인사이트")
                .price(10000L)
                .build();

        // when
        List<BookResponseDto> bookDtoList = bookService.findByName("이펙티브");

        // then
        assertThat(bookDtoList.get(0).getName()).isEqualTo(book.getName());
        assertThat(bookDtoList.get(0).getAuthor()).isEqualTo(book.getAuthor());
    }
}
