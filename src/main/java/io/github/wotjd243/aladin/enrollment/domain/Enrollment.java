package io.github.wotjd243.aladin.enrollment.domain;

import io.github.wotjd243.aladin.book.domain.RegisteredBook;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long sellerId;

    @OneToMany(mappedBy = "enrollment", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<RegisteredBook> registeredBooks = new ArrayList<>();

    @OneToMany(mappedBy = "enrollment", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Event> events = new ArrayList<>();

    public Enrollment(Long sellerId, List<RegisteredBook> registeredBooks, List<Event> events) {
        this.sellerId = sellerId;
        addRegisteredBook(registeredBooks);
        addEvents(events);
    }

    private void addRegisteredBook(List<RegisteredBook> registeredBooks) {
        this.registeredBooks.addAll(registeredBooks);
        registeredBooks.forEach(registeredBook -> registeredBook.setEnrollment(this));

    }

    private void addEvents(List<Event> events) {
        this.events.addAll(events);
        events.forEach(event -> event.setEnrollment(this));
    }
}
