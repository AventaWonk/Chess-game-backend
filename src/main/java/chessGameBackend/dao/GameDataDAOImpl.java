package chessGameBackend.dao;

import chessGameBackend.model.GameData;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class GameDataDAOImpl implements GameDataDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private Logger logger;

    @Override
    public void addGameData(GameData gameData) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(gameData);
        logger.info("Game data saved successfully");
    }

    @Override
    public void updateGameData(GameData gameData) {
        Session session = sessionFactory.getCurrentSession();
        session.update(gameData);
        logger.info("Game data saved successfully");
    }

    @Override
    public void deleteGameData(GameData gameData) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(gameData);
        logger.info("Game data saved successfully");
    }
}
