package io.github.wotjd243.aladin.enrollment.application;

import io.github.wotjd243.aladin.common.HttpSessionUtil;
import io.github.wotjd243.aladin.enrollment.application.dto.RegisteredBookDto;
import io.github.wotjd243.aladin.enrollment.application.dto.SessionRegisteredBook;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.List;

@Component
public class RegisteredBookSessionManager {


    public void addNewRegisteredBook(HttpSession session, RegisteredBookDto dto) {
        List<SessionRegisteredBook> registeredBooks = HttpSessionUtil.getSessionRegisteredBook(session);

        for (int i = 0; i < dto.getCount(); i++) {
            addRegisteredBook(registeredBooks, dto);
        }
        HttpSessionUtil.setSessionRegisteredBook(session, registeredBooks);
    }

    public void addUsedRegisteredBook(HttpSession session, RegisteredBookDto dto) {
        List<SessionRegisteredBook> registeredBooks = HttpSessionUtil.getSessionRegisteredBook(session);
        addRegisteredBook(registeredBooks, dto);
    }

    private void addRegisteredBook(List<SessionRegisteredBook> sessionRegisteredBooks, RegisteredBookDto dto) {
        sessionRegisteredBooks.add(dto.toSession());
    }

}
