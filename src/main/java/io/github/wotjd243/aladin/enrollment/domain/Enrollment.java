package io.github.wotjd243.aladin.enrollment.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
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

    public void addRegisteredBook(List<RegisteredBook> registeredBooks) {
        this.registeredBooks.addAll(registeredBooks);
        registeredBooks.forEach(registeredBook -> registeredBook.setEnrollment(this));

    }

    public void addEvents(List<Event> events) {
        this.events.addAll(events);
        events.forEach(event -> event.setEnrollment(this));
    }
}
