package chessGameBackend.service;

import chessGameBackend.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addUser(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(user);
        session.flush();
        session.close();
    }

    @Override
    public void deleteUser(int userId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.find(User.class, userId);
        session.remove(user);
        session.flush();
        session.close();
    }

    @Override
    public void updateUser(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(user);
        session.flush();
        session.close();
    }

    @Override
    public boolean isUserExists(String login) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        return session.find(User.class, userId);
    }
}
