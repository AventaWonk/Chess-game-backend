package chessGameBackend.service;

import chessGameBackend.dao.GameDataDAO;
import chessGameBackend.dao.UserDAO;
import chessGameBackend.model.GameData;
import chessGameBackend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class GameDataServiceImpl implements GameDataService {

    @Autowired
    private GameDataDAO gameDataDAO;

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public void addGameData(User user, GameData gameData) {
        gameDataDAO.addGameData(gameData);
        user.getGames().add(gameData);
        userDAO.updateUser(user);
    }

    @Override
    @Transactional
    public void updateGameData(GameData gameData) {
        gameDataDAO.updateGameData(gameData);
    }

    @Override
    @Transactional
    public void deleteGameData(GameData gameData) {
        gameDataDAO.deleteGameData(gameData);
    }
}
