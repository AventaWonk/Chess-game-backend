package chessGameBackend.controller;

import chessGameBackend.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

public class UserController {

    @Autowired
    SessionFactory sessionFactory;

    @PostMapping(value = "/addUser")
    public String addUser(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(user);
        session.flush();
        session.close();
    }

}
