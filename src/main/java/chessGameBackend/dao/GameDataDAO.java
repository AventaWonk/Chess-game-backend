package chessGameBackend.dao;

import chessGameBackend.model.GameData;

public interface GameDataDAO {
    void addGameData(GameData gameData);
    void updateGameData(GameData gameData);
    void deleteGameData(GameData gameData);
}
