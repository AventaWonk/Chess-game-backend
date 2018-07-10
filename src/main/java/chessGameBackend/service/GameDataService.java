package chessGameBackend.service;

import chessGameBackend.model.GameData;
import chessGameBackend.model.User;

public interface GameDataService {
    void addGameData(User user, GameData gd);
    void updateGameData(GameData gd);
    void deleteGameData(GameData gd);
}
