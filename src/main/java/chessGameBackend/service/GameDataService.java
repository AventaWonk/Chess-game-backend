package chessGameBackend.service;

import chessGameBackend.model.User;

public interface GameDataService {
    void setPieceSet(User user, String serializedPieceSet);
    String getPieceSet(User user);
}
