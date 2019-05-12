package io.github.wotjd243.aladin.enrollment.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class RegisteredBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bookId;

    @Embedded
    private UnitAmount amount;

    private SellType sellType;

    @Column(columnDefinition = "Boolean default false")
    private boolean reserved;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enrollment_id")
    private Enrollment enrollment;

    @Builder
    public RegisteredBook(Long bookId, UnitAmount unitAmount, List<Event> eventsm, SellType sellType) {
        this.bookId = bookId;
        this.amount = unitAmount;
        this.sellType = sellType;
    }

    public void reserve() {
        if (isReserved()) {
            throw new RuntimeException();

        }
        reserved = true;
    }

    public void cancel() {
        if (!isReserved()) {
            throw new RuntimeException();

        }
        reserved = false;
    }

    public boolean isReserved() {
        return reserved;
    }

}
