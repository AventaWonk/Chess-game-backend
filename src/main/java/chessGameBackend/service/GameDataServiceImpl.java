package chessGameBackend.service;

import chessGameBackend.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class GameDataServiceImpl implements GameDataService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void setPieceSet(User user, String serializedPieceSet) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
//        @TODO
        session.flush();
        session.close();
    }

    @Override
    public String getPieceSet(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
//        @TODO
        session.flush();
        session.close();
    }
}
