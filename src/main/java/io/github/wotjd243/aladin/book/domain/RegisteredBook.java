package io.github.wotjd243.aladin.book.domain;

import io.github.wotjd243.aladin.common.domain.UnitAmount;
import io.github.wotjd243.aladin.enrollment.domain.Enrollment;
import io.github.wotjd243.aladin.enrollment.domain.SellType;
import io.github.wotjd243.aladin.exception.AlreadyReservationException;
import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RegisteredBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bookId;

    @Embedded
    private UnitAmount amount;

    @Enumerated(EnumType.STRING)
    private SellType sellType;

    private boolean reserved;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enrollment_id")
    private Enrollment enrollment;

    @Builder
    public RegisteredBook(Long bookId, UnitAmount unitAmount, SellType sellType) {
        this.bookId = bookId;
        this.amount = unitAmount;
        this.sellType = sellType;
    }

    public void reserve() {

        if (isReserved()) {
            throw new AlreadyReservationException();
        }

        reserved = true;
    }

    public void cancel() {

        if (isCanceled()) {
            throw new AlreadyReservationException("이미 예약 취소 되었습니다.");
        }

        reserved = false;
    }

    private boolean isReserved() {
        return reserved;
    }

    private boolean isCanceled() {
        return !reserved;
    }
}
