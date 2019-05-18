package io.github.wotjd243.aladin.book.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BookRepositoryTest {

    @Autowired
    BookRepository repository;

    @Test
    public void Book_조회() {

        // given
        // when
        List<Book> bookList = repository.findAll();

        // then
        assertThat(bookList.size()).isEqualTo(10);

    }

}
