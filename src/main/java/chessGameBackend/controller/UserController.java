package chessGameBackend.controller;

import chessGameBackend.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    SessionFactory sessionFactory;

    @PostMapping(value = "/add")
    public String addUser(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(user);
        session.flush();
        session.close();
    }

    @PostMapping(value = "/delete")
    public String deleteUser(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.find(User.class, id);
        session.remove(user);
        session.flush();
        session.close();
    }

    @PostMapping(value = "/update")
    public String updateUser(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(user);
        session.flush();
        session.close();
    }

}
